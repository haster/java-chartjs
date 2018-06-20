package nl.crashdata.chartjs.data.simple;

import nl.crashdata.chartjs.data.ChartJsTimeConfig;
import nl.crashdata.chartjs.data.ChartJsTimeUnit;

public class SimpleChartJsTimeConfig implements ChartJsTimeConfig
{
	private static final long serialVersionUID = 1L;

	private Boolean isoWeekday;

	private ChartJsTimeUnit timeUnit;

	private ChartJsTimeUnit minimumDisplayUnit;

	private Number stepSize;

	@Override
	public Boolean getIsoWeekday()
	{
		return isoWeekday;
	}

	public void setIsoWeekday(Boolean isoWeekday)
	{
		this.isoWeekday = isoWeekday;
	}

	@Override
	public ChartJsTimeUnit getTimeUnit()
	{
		return timeUnit;
	}

	public void setTimeUnit(ChartJsTimeUnit timeUnit)
	{
		this.timeUnit = timeUnit;
	}

	@Override
	public ChartJsTimeUnit getMinimumDisplayUnit()
	{
		return minimumDisplayUnit;
	}

	public void setMinimumDisplayUnit(ChartJsTimeUnit minimumDisplayUnit)
	{
		this.minimumDisplayUnit = minimumDisplayUnit;
	}

	@Override
	public Number getStepSize()
	{
		return stepSize;
	}

	public void setStepSize(Number stepSize)
	{
		this.stepSize = stepSize;
	}
}
