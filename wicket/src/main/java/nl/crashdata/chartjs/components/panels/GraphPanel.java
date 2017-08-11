package nl.crashdata.chartjs.components.panels;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;

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
import org.danekja.java.util.function.serializable.SerializableFunction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import nl.crashdata.chartjs.components.resources.ChartJSJavaScriptResourceReference;
import nl.crashdata.chartjs.data.ChartJsAxisConfig;
import nl.crashdata.chartjs.data.ChartJsCartesianAxisType;
import nl.crashdata.chartjs.data.ChartJsChartType;
import nl.crashdata.chartjs.data.ChartJsConfig;
import nl.crashdata.chartjs.data.ChartJsData;
import nl.crashdata.chartjs.data.ChartJsDataset;
import nl.crashdata.chartjs.data.ChartJsHoverConfig;
import nl.crashdata.chartjs.data.ChartJsInteractionMode;
import nl.crashdata.chartjs.data.ChartJsOptions;
import nl.crashdata.chartjs.data.ChartJsScaleLabelConfig;
import nl.crashdata.chartjs.data.ChartJsScalesConfig;
import nl.crashdata.chartjs.data.ChartJsTickConfig;
import nl.crashdata.chartjs.data.ChartJsTooltipConfig;
import nl.crashdata.chartjs.data.simple.SimpleChartJsAxisConfig;
import nl.crashdata.chartjs.data.simple.SimpleChartJsConfig;
import nl.crashdata.chartjs.data.simple.SimpleChartJsData;
import nl.crashdata.chartjs.data.simple.SimpleChartJsDataset;
import nl.crashdata.chartjs.data.simple.SimpleChartJsHoverConfig;
import nl.crashdata.chartjs.data.simple.SimpleChartJsOptions;
import nl.crashdata.chartjs.data.simple.SimpleChartJsScaleLabelConfig;
import nl.crashdata.chartjs.data.simple.SimpleChartJsScalesConfig;
import nl.crashdata.chartjs.data.simple.SimpleChartJsTickConfig;
import nl.crashdata.chartjs.data.simple.SimpleChartJsTooltipConfig;

public class GraphPanel<K extends Serializable, V extends Serializable>
		extends Panel
{
	private static final long serialVersionUID = 1L;

	private IModel<String> caption;

	private WebMarkupContainer canvas;

	private IModel<String> graphLabelModel;

	private IModel<String> xAxisLabel = Model.of("");

	private IModel<String> yAxisLabel = Model.of("");

	private SerializableFunction<K, String> keyFormatFunction = Object::toString;

	private SerializableFunction<V, Integer> valueFormatFunction =
		v -> Integer.parseInt(String.valueOf(v));

	public GraphPanel(String id, IModel<SortedMap<K, V>> model, IModel<String> caption)
	{
		this(id, model, caption, caption);
	}

	public GraphPanel(String id, IModel<SortedMap<K, V>> model, IModel<String> caption,
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

	public void setKeyFormatFunction(SerializableFunction<K, String> keyFormatFunction)
	{
		this.keyFormatFunction = keyFormatFunction;
	}

	public void setValueFormatFunction(SerializableFunction<V, Integer> valueFormatFunction)
	{
		this.valueFormatFunction = valueFormatFunction;
	}

	private StringBuilder jsStatement()
	{
		StringBuilder statement = new StringBuilder();

		statement
			.append("moment.locale('" + Session.get().getLocale().toLanguageTag() + "');");

		ChartJsConfig<K, V> config = createChartConfig();

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
			statement.append(mapper.writeValueAsString(config));
		}
		catch (JsonProcessingException e1)
		{
			throw new RuntimeException(e1);
		}
		return statement;
	}

	private ChartJsConfig<K, V> createChartConfig()
	{
		List<K> keys = new ArrayList<>();
		List<V> values = new ArrayList<>();
		getModelObject().entrySet().stream().forEach(e -> toKeyAndValue(e, keys, values));

		SimpleChartJsConfig<K, V> config = new SimpleChartJsConfig<>();
		config.setChartType(ChartJsChartType.LINE);

		SimpleChartJsData<K, V> data = new SimpleChartJsData<>();
		data.setLabels(keys);
		SimpleChartJsDataset<V> dataset = new SimpleChartJsDataset<>();
		dataset.setLabel(graphLabelModel.getObject());
		dataset.setBorderColor("rgb(54, 162, 235)");
		dataset.setData(values);
		dataset.setFill(false);
		data.setDatasets(Collections.singletonList(dataset));
		config.setData(data);

		SimpleChartJsOptions options = new SimpleChartJsOptions();
		options.setResponsive(true);
		SimpleChartJsTooltipConfig tooltipConfig = new SimpleChartJsTooltipConfig();
		tooltipConfig.setMode(ChartJsInteractionMode.INDEX);
		tooltipConfig.setIntersect(false);
		options.setTooltipConfig(tooltipConfig);
		SimpleChartJsHoverConfig hoverConfig = new SimpleChartJsHoverConfig();
		hoverConfig.setMode(ChartJsInteractionMode.NEAREST);
		hoverConfig.setIntersect(true);
		options.setHoverConfig(hoverConfig);
		SimpleChartJsScalesConfig scalesConfig = new SimpleChartJsScalesConfig();
		SimpleChartJsAxisConfig xAxisConfig = new SimpleChartJsAxisConfig();
		xAxisConfig.setDisplay(true);
		xAxisConfig.setType(ChartJsCartesianAxisType.TIME);
		SimpleChartJsScaleLabelConfig xScaleLabelConfig = new SimpleChartJsScaleLabelConfig();
		xScaleLabelConfig.setDisplay(true);
		xScaleLabelConfig.setLabelString(xAxisLabel.getObject());
		xAxisConfig.setLabelConfig(xScaleLabelConfig);
		SimpleChartJsAxisConfig yAxisConfig = new SimpleChartJsAxisConfig();
		yAxisConfig.setDisplay(true);
		yAxisConfig.setType(ChartJsCartesianAxisType.LINEAR);
		SimpleChartJsScaleLabelConfig yScaleLabelConfig = new SimpleChartJsScaleLabelConfig();
		yScaleLabelConfig.setDisplay(true);
		yScaleLabelConfig.setLabelString(yAxisLabel.getObject());
		SimpleChartJsTickConfig yTickConfig = new SimpleChartJsTickConfig();
		yTickConfig.setSuggestedMinimum(0);
		yTickConfig.setStepSize(1);
		yAxisConfig.setTickConfig(yTickConfig);
		scalesConfig.setXAxes(Collections.singletonList(xAxisConfig));
		scalesConfig.setYAxes(Collections.singletonList(yAxisConfig));
		options.setScalesConfig(scalesConfig);
		config.setOptions(options);
		return config;
	}
}
