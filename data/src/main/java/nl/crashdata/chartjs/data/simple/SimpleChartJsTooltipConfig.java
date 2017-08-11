package nl.crashdata.chartjs.data.simple;

import nl.crashdata.chartjs.data.ChartJsInteractionMode;
import nl.crashdata.chartjs.data.ChartJsTooltipConfig;

public class SimpleChartJsTooltipConfig implements ChartJsTooltipConfig
{
	private static final long serialVersionUID = 1L;

	private ChartJsInteractionMode mode;

	private boolean intersect;

	@Override
	public ChartJsInteractionMode getMode()
	{
		return mode;
	}

	public void setMode(ChartJsInteractionMode mode)
	{
		this.mode = mode;
	}

	@Override
	public boolean isIntersect()
	{
		return intersect;
	}

	public void setIntersect(boolean intersect)
	{
		this.intersect = intersect;
	}
}
