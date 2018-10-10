package nl.crashdata.chartjs.data.simple;

import java.io.Serializable;
import java.util.Map;

import nl.crashdata.chartjs.data.ChartJsHoverConfig;
import nl.crashdata.chartjs.data.ChartJsLegendConfig;
import nl.crashdata.chartjs.data.ChartJsOptions;
import nl.crashdata.chartjs.data.ChartJsScalesConfig;
import nl.crashdata.chartjs.data.ChartJsTitleConfig;
import nl.crashdata.chartjs.data.ChartJsTooltipConfig;

public class SimpleChartJsOptions implements ChartJsOptions
{
	private static final long serialVersionUID = 1L;

	private Boolean responsive;

	private Boolean maintainAspectRatio;

	private Integer cutoutPercentage;

	private Integer rotation;

	private Integer circumference;

	private ChartJsTooltipConfig tooltipConfig;

	private ChartJsHoverConfig hoverConfig;

	private ChartJsScalesConfig scalesConfig;

	private ChartJsTitleConfig titleConfig;

	private ChartJsLegendConfig legendConfig;

	private Map<String, Serializable> plugins;

	@Override
	public Boolean getResponsive()
	{
		return responsive;
	}

	public void setResponsive(Boolean responsive)
	{
		this.responsive = responsive;
	}

	@Override
	public Boolean getMaintainAspectRatio()
	{
		return maintainAspectRatio;
	}

	public void setMaintainAspectRatio(Boolean maintainAspectRatio)
	{
		this.maintainAspectRatio = maintainAspectRatio;
	}

	@Override
	public Integer getCutoutPercentage()
	{
		return cutoutPercentage;
	}

	public void setCutoutPercentage(Integer cutoutPercentage)
	{
		this.cutoutPercentage = cutoutPercentage;
	}

	@Override
	public Integer getRotation()
	{
		return rotation;
	}

	public void setRotation(Integer rotation)
	{
		this.rotation = rotation;
	}

	@Override
	public Integer getCircumference()
	{
		return circumference;
	}

	public void setCircumference(Integer circumference)
	{
		this.circumference = circumference;
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
