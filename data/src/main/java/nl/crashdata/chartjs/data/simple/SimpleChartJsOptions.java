package nl.crashdata.chartjs.data.simple;

import nl.crashdata.chartjs.data.ChartJsHoverConfig;
import nl.crashdata.chartjs.data.ChartJsOptions;
import nl.crashdata.chartjs.data.ChartJsPluginsConfig;
import nl.crashdata.chartjs.data.ChartJsScalesConfig;

public class SimpleChartJsOptions implements ChartJsOptions
{
	private static final long serialVersionUID = 1L;

	private Boolean responsive;

	private Boolean maintainAspectRatio;

	private Integer cutoutPercentage;

	private Integer rotation;

	private Integer circumference;

	private ChartJsHoverConfig hoverConfig;

	private ChartJsScalesConfig scalesConfig;

	private ChartJsPluginsConfig pluginsConfig;

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
	public ChartJsPluginsConfig getPluginsConfig()
	{
		return pluginsConfig;
	}

	public void setPluginsConfig(ChartJsPluginsConfig pluginsConfig)
	{
		this.pluginsConfig = pluginsConfig;
	}
}
