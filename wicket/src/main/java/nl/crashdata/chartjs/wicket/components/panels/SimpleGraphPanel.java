package nl.crashdata.chartjs.wicket.components.panels;

import org.apache.wicket.Application;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.Session;
import org.apache.wicket.core.request.handler.IPartialPageRequestHandler;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import nl.crashdata.chartjs.data.ChartJsConfig;
import nl.crashdata.chartjs.data.ChartJsDataset;
import nl.crashdata.chartjs.serialization.ChartJsObjectMapperFactory;
import nl.crashdata.chartjs.wicket.resources.ChartJsCssResourceReference;
import nl.crashdata.chartjs.wicket.resources.ChartJsJavaScriptResourceReference;

public class SimpleGraphPanel<T extends ChartJsConfig< ? >> extends GenericPanel<T>
{
	private static final long serialVersionUID = 1L;

	private WebMarkupContainer canvas;

	public SimpleGraphPanel(String id, IModel<T> model)
	{
		super(id, model);
	}

	public WebMarkupContainer getCanvas()
	{
		return canvas;
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		add(canvas = new WebMarkupContainer("canvas"));
	}

	@Override
	public void renderHead(IHeaderResponse response)
	{
		super.renderHead(response);

		response
			.render(JavaScriptHeaderItem.forReference(ChartJsJavaScriptResourceReference.get()));
		response.render(CssHeaderItem.forReference(ChartJsCssResourceReference.get()));
		response.render(OnDomReadyHeaderItem
			.forScript("moment.locale('" + Session.get().getLocale().toLanguageTag() + "');\n"
				+ "Chart.platform.disableCSSInjection = true;\n" + "document.getElementById(\""
				+ canvas.getMarkupId() + "\").chartjs = " + "new Chart(document.getElementById(\""
				+ canvas.getMarkupId() + "\").getContext(\"2d\"), " + marshal(getModelObject())
				+ ");"));
	}

	private String marshal(Object obj)
	{
		boolean isDevelopment = Application.exists() && RuntimeConfigurationType.DEVELOPMENT
			.equals(Application.get().getConfigurationType());
		try
		{
			ObjectMapper mapper = ChartJsObjectMapperFactory.getObjectMapper(isDevelopment);
			return mapper.writeValueAsString(obj);
		}
		catch (JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}
	}

	public void update(IPartialPageRequestHandler target)
	{
		target.appendJavaScript("document.getElementById(\"" + canvas.getMarkupId()
			+ "\").chartjs.options = " + marshal(getModelObject().getOptions()) + ";");
		int index = 0;
		for (ChartJsDataset< ? > curDataset : getModelObject().getData().getDatasets())
		{
			target
				.appendJavaScript("Object.assign(document.getElementById(\"" + canvas.getMarkupId()
					+ "\").chartjs.data.datasets[" + index + "], " + marshal(curDataset) + ");");
			index++;
		}
		target.appendJavaScript(
			"document.getElementById(\"" + canvas.getMarkupId() + "\").chartjs.update();");
	}
}
