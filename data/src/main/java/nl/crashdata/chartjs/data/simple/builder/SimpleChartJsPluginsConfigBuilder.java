package nl.crashdata.chartjs.data.simple.builder;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import nl.crashdata.chartjs.data.ChartJsChartType;
import nl.crashdata.chartjs.data.simple.SimpleChartJsPluginsConfig;

public class SimpleChartJsPluginsConfigBuilder
		implements SimpleChartJsBuilder<SimpleChartJsPluginsConfig>
{
	private Supplier<ChartJsChartType> chartTypeSupplier;

	private SimpleChartJsTooltipConfigBuilder tooltipConfigBuilder;

	private SimpleChartJsTitleConfigBuilder titleConfigBuilder;

	private SimpleChartJsLegendConfigBuilder legendConfigBuilder;

	private Map<String, Serializable> plugins;

	public SimpleChartJsPluginsConfigBuilder(Supplier<ChartJsChartType> chartTypeSupplier)
	{
		this.chartTypeSupplier = chartTypeSupplier;
	}

	public SimpleChartJsTooltipConfigBuilder tooltipConfig()
	{
		if (tooltipConfigBuilder == null)
			tooltipConfigBuilder = new SimpleChartJsTooltipConfigBuilder();
		return tooltipConfigBuilder;
	}

	public SimpleChartJsTitleConfigBuilder titleConfig()
	{
		if (titleConfigBuilder == null)
			titleConfigBuilder = new SimpleChartJsTitleConfigBuilder();
		return titleConfigBuilder;
	}

	public SimpleChartJsLegendConfigBuilder legendConfig()
	{
		if (legendConfigBuilder == null)
			legendConfigBuilder = new SimpleChartJsLegendConfigBuilder(chartTypeSupplier);
		return legendConfigBuilder;
	}

	public SimpleChartJsPluginsConfigBuilder withPlugin(String name, Serializable configuration)
	{
		if (plugins == null)
			plugins = new LinkedHashMap<>();
		plugins.put(name, configuration);
		return this;
	}

	@Override
	public boolean isValid()
	{
		return allNullOrValid(tooltipConfigBuilder, titleConfigBuilder, legendConfigBuilder);
	}

	@Override
	public SimpleChartJsPluginsConfig build() throws IllegalStateException
	{
		SimpleChartJsPluginsConfig ret = new SimpleChartJsPluginsConfig();
		ret.setTooltipConfig(buildIfNotNull(tooltipConfigBuilder));
		ret.setTitleConfig(buildIfNotNull(titleConfigBuilder));
		ret.setLegendConfig(buildIfNotNull(legendConfigBuilder));
		ret.setPlugins(plugins);
		return ret;
	}
}
