package nl.crashdata.chartjs.data.simple;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import nl.crashdata.chartjs.data.ChartJsAxisConfig;
import nl.crashdata.chartjs.data.ChartJsScalesConfig;

public class SimpleChartJsScalesConfig<X extends Serializable, Y extends Serializable>
		implements ChartJsScalesConfig
{
	private static final long serialVersionUID = 1L;

	private ChartJsAxisConfig<X> xAxis;

	private ChartJsAxisConfig<Y> yAxis;

	public ChartJsAxisConfig<X> getxAxis()
	{
		return xAxis;
	}

	public void setxAxis(ChartJsAxisConfig<X> xAxis)
	{
		this.xAxis = xAxis;
	}

	public ChartJsAxisConfig<Y> getyAxis()
	{
		return yAxis;
	}

	public void setyAxis(ChartJsAxisConfig<Y> yAxis)
	{
		this.yAxis = yAxis;
	}

	@Override
	public List<ChartJsAxisConfig< ? extends Serializable>> getXAxes()
	{
		return Collections.singletonList(xAxis);
	}

	@Override
	public List<ChartJsAxisConfig< ? extends Serializable>> getYAxes()
	{
		return Collections.singletonList(yAxis);
	}
}
