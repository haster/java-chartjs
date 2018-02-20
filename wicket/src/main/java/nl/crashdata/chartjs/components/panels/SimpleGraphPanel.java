package nl.crashdata.chartjs.components.panels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import nl.crashdata.chartjs.components.resources.ChartJSJavaScriptResourceReference;
import nl.crashdata.chartjs.data.ChartJsConfig;
import org.apache.wicket.Application;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.Session;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class SimpleGraphPanel extends Panel
{
	private static final long serialVersionUID = 1L;

	private IModel<String> caption;

	private WebMarkupContainer canvas;

	public SimpleGraphPanel(String id, IModel< ? extends ChartJsConfig< ? , ? >> model,
			IModel<String> caption)
	{
		super(id, model);
		this.caption = caption;
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		add(new Label("title", caption));
		add(canvas = new WebMarkupContainer("canvas"));
	}

	@Override
	public void renderHead(IHeaderResponse response)
	{
		super.renderHead(response);
		response
			.render(JavaScriptHeaderItem.forReference(ChartJSJavaScriptResourceReference.get()));
		response.render(
			JavaScriptHeaderItem.forScript(jsStatement().toString(), "chartjs_" + getMarkupId()));
		response.render(OnDomReadyHeaderItem.forScript("var ctx = document.getElementById(\""
			+ canvas.getMarkupId() + "\").getContext(\"2d\");new Chart(ctx, config);"));
	}

	private StringBuilder jsStatement()
	{
		StringBuilder statement = new StringBuilder();

		statement.append("moment.locale('" + Session.get().getLocale().toLanguageTag() + "');");

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
		mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		if (Application.exists() && RuntimeConfigurationType.DEVELOPMENT
			.equals(Application.get().getConfigurationType()))
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		statement.append("var config = ");
		try
		{
			statement.append(mapper.writeValueAsString(getDefaultModelObject()));
		}
		catch (JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}
		return statement;
	}

	@Override
	protected void onDetach()
	{
		super.onDetach();
		this.caption.detach();
	}
}
