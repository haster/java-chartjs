package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.ChartJsTimeConfig;
import nl.crashdata.chartjs.data.ChartJsTimeUnit;
import nl.crashdata.chartjs.data.simple.SimpleChartJsTimeConfig;

public class SimpleChartJsTimeConfigBuilder implements SimpleChartJsBuilder<ChartJsTimeConfig>
{
	private Boolean isoWeekday;

	private ChartJsTimeUnit timeUnit;

	private ChartJsTimeUnit minimumDisplayUnit;

	private Number stepSize;

	/**
	 * @param isoWeekday
	 *            if {@code true}, the week starts on Monday, otherwise it starts on Sunday. Only
	 *            relevant if {@link #withTimeUnit(ChartJsTimeUnit)} is set to
	 *            {@link ChartJsTimeUnit#WEEK}
	 */
	public SimpleChartJsTimeConfigBuilder withIsoWeekday(Boolean isoWeekday)
	{
		this.isoWeekday = isoWeekday;
		return this;
	}

	public SimpleChartJsTimeConfigBuilder withStepSize(Number stepSize)
	{
		this.stepSize = stepSize;
		return this;
	}

	public SimpleChartJsTimeConfigBuilder withTimeUnit(ChartJsTimeUnit timeUnit)
	{
		this.timeUnit = timeUnit;
		return this;
	}

	public SimpleChartJsTimeConfigBuilder withMinimumDisplayUnit(ChartJsTimeUnit minimumDisplayUnit)
	{
		this.minimumDisplayUnit = minimumDisplayUnit;
		return this;
	}

	@Override
	public boolean isValid()
	{
		return true;
	}

	@Override
	public ChartJsTimeConfig build() throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsTimeConfig ret = new SimpleChartJsTimeConfig();
		ret.setIsoWeekday(isoWeekday);
		ret.setTimeUnit(timeUnit);
		ret.setMinimumDisplayUnit(minimumDisplayUnit);
		ret.setStepSize(stepSize);
		return ret;
	}
}
