package nl.crashdata.chartjs.data.simple;

import java.util.List;

import nl.crashdata.chartjs.data.ChartJsAxisConfig;
import nl.crashdata.chartjs.data.ChartJsScalesConfig;

public class SimpleChartJsScalesConfig implements ChartJsScalesConfig
{
	private static final long serialVersionUID = 1L;

	private List<ChartJsAxisConfig> xAxes;

	private List<ChartJsAxisConfig> yAxes;

	@Override
	public List<ChartJsAxisConfig> getXAxes()
	{
		return xAxes;
	}

	public void setXAxes(List<ChartJsAxisConfig> xAxes)
	{
		this.xAxes = xAxes;
	}

	@Override
	public List<ChartJsAxisConfig> getYAxes()
	{
		return yAxes;
	}

	public void setYAxes(List<ChartJsAxisConfig> yAxes)
	{
		this.yAxes = yAxes;
	}
}
