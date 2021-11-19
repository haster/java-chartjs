package nl.crashdata.chartjs.data.simple;

import java.io.Serializable;
import java.util.Map;

import nl.crashdata.chartjs.data.ChartJsLegendConfig;
import nl.crashdata.chartjs.data.ChartJsPluginsConfig;
import nl.crashdata.chartjs.data.ChartJsTitleConfig;
import nl.crashdata.chartjs.data.ChartJsTooltipConfig;

public class SimpleChartJsPluginsConfig implements ChartJsPluginsConfig
{
	private static final long serialVersionUID = 1L;

	private ChartJsTooltipConfig tooltipConfig;

	private ChartJsTitleConfig titleConfig;

	private ChartJsLegendConfig legendConfig;

	private Map<String, Serializable> plugins;

	@Override
	public ChartJsTooltipConfig getTooltipConfig()
	{
		return tooltipConfig;
	}

	public void setTooltipConfig(ChartJsTooltipConfig tooltipConfig)
	{
		this.tooltipConfig = tooltipConfig;
	}

	@Override
	public ChartJsTitleConfig getTitleConfig()
	{
		return titleConfig;
	}

	public void setTitleConfig(ChartJsTitleConfig titleConfig)
	{
		this.titleConfig = titleConfig;
	}

	@Override
	public ChartJsLegendConfig getLegendConfig()
	{
		return legendConfig;
	}

	public void setLegendConfig(ChartJsLegendConfig legendConfig)
	{
		this.legendConfig = legendConfig;
	}

	@Override
	public Map<String, Serializable> getPlugins()
	{
		return plugins;
	}

	public void setPlugins(Map<String, Serializable> plugins)
	{
		this.plugins = plugins;
	}
}
