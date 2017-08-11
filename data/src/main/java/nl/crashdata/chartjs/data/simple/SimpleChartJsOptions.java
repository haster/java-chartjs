package nl.crashdata.chartjs.data.simple;

import nl.crashdata.chartjs.data.ChartJsHoverConfig;
import nl.crashdata.chartjs.data.ChartJsOptions;
import nl.crashdata.chartjs.data.ChartJsScalesConfig;
import nl.crashdata.chartjs.data.ChartJsTooltipConfig;

public class SimpleChartJsOptions implements ChartJsOptions
{
	private static final long serialVersionUID = 1L;

	private Boolean responsive;

	private ChartJsTooltipConfig tooltipConfig;

	private ChartJsHoverConfig hoverConfig;

	private ChartJsScalesConfig scalesConfig;

	@Override
	public Boolean isResponsive()
	{
		return responsive;
	}

	public void setResponsive(Boolean responsive)
	{
		this.responsive = responsive;
	}

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
	public ChartJsHoverConfig getHoverConfig()
	{
		return hoverConfig;
	}

	public void setHoverConfig(ChartJsHoverConfig hoverConfig)
	{
		this.hoverConfig = hoverConfig;
	}

	@Override
	public ChartJsScalesConfig getScalesConfig()
	{
		return scalesConfig;
	}

	public void setScalesConfig(ChartJsScalesConfig scalesConfig)
	{
		this.scalesConfig = scalesConfig;
	}
}
