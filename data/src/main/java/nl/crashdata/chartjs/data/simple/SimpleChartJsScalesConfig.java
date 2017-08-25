package nl.crashdata.chartjs.data.simple;

import java.util.Collections;
import java.util.List;

import nl.crashdata.chartjs.data.ChartJsAxisConfig;
import nl.crashdata.chartjs.data.ChartJsScalesConfig;

public class SimpleChartJsScalesConfig implements ChartJsScalesConfig
{
	private static final long serialVersionUID = 1L;

	private ChartJsAxisConfig xAxis;

	private ChartJsAxisConfig yAxis;

	public ChartJsAxisConfig getxAxis()
	{
		return xAxis;
	}

	public void setxAxis(ChartJsAxisConfig xAxis)
	{
		this.xAxis = xAxis;
	}

	public ChartJsAxisConfig getyAxis()
	{
		return yAxis;
	}

	public void setyAxis(ChartJsAxisConfig yAxis)
	{
		this.yAxis = yAxis;
	}

	@Override
	public List<ChartJsAxisConfig> getXAxes()
	{
		return Collections.singletonList(xAxis);
	}

	@Override
	public List<ChartJsAxisConfig> getYAxes()
	{
		return Collections.singletonList(yAxis);
	}
}
