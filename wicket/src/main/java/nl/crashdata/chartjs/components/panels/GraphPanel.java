package nl.crashdata.chartjs.components.panels;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import nl.crashdata.chartjs.components.resources.ChartJSJavaScriptResourceReference;
import nl.crashdata.chartjs.data.ChartJsCartesianAxisType;
import nl.crashdata.chartjs.data.ChartJsConfig;
import nl.crashdata.chartjs.data.ChartJsInteractionMode;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsAxisConfigBuilder;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsConfigBuilder;
import nl.crashdata.chartjs.data.simple.builder.SimpleChartJsOptionsBuilder;
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
import org.apache.wicket.model.Model;

public class GraphPanel<K extends Serializable, V extends Serializable> extends Panel
{
	private static final long serialVersionUID = 1L;

	private IModel<String> caption;

	private WebMarkupContainer canvas;

	private IModel<String> graphLabelModel;

	private IModel<String> xAxisLabel = Model.of("");

	private IModel<String> yAxisLabel = Model.of("");

	public GraphPanel(String id, IModel<Map<K, V>> model, IModel<String> caption)
	{
		this(id, model, caption, caption);
	}

	public GraphPanel(String id, IModel<Map<K, V>> model, IModel<String> caption,
			IModel<String> graphLabelModel)
	{
		super(id, model);
		this.caption = caption;
		this.graphLabelModel = graphLabelModel;
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
		mapper.setPropertyInclusion(JsonInclude.Value.empty()
			.withValueInclusion(JsonInclude.Include.NON_NULL)
			.withContentInclusion(JsonInclude.Include.NON_NULL));
		mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);

		if (Application.exists() && RuntimeConfigurationType.DEVELOPMENT
			.equals(Application.get().getConfigurationType()))
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		statement.append("var config = ");
		try
		{
			statement.append(mapper.writeValueAsString(createChartConfig()));
		}
		catch (JsonProcessingException e)
		{
			throw new RuntimeException(e);
		}
		return statement;
	}

	@SuppressWarnings("unchecked")
	private ChartJsConfig<K, V> createChartConfig()
	{
		SimpleChartJsConfigBuilder<K, V> config = SimpleChartJsConfigBuilder.lineChart();

		config.data()
			.addDataset()
			.withDataPoints((Map<K, V>) getDefaultModelObject())
			.withLabel(graphLabelModel.getObject())
			.withBorderColor("rgb(54, 162, 235)");

		SimpleChartJsOptionsBuilder optionsBuilder = config.options();
		optionsBuilder.withResponsive(true);
		optionsBuilder.hoverConfig().withIntersect(true).withMode(ChartJsInteractionMode.NEAREST);
		optionsBuilder.tooltipConfig().withIntersect(false).withMode(ChartJsInteractionMode.INDEX);
		optionsBuilder.scalesConfig()
			.xAxisConfig()
			.withDisplay(true)
			.withAxisType(ChartJsCartesianAxisType.TIME)
			.labelConfig()
			.withDisplay(true)
			.withLabelString(xAxisLabel.getObject());
		SimpleChartJsAxisConfigBuilder yAxisBuilder = optionsBuilder.scalesConfig().yAxisConfig();
		yAxisBuilder.withDisplay(true)
			.withAxisType(ChartJsCartesianAxisType.LINEAR)
			.labelConfig()
			.withDisplay(true)
			.withLabelString(yAxisLabel.getObject());
		yAxisBuilder.tickConfig().withSuggestedMinimum(0).withStepSize(1);
		return config.build();
	}
}
