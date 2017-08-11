package nl.crashdata.chartjs.data.simple;

import nl.crashdata.chartjs.data.ChartJsTickConfig;

public class SimpleChartJsTickConfig implements ChartJsTickConfig
{
	private static final long serialVersionUID = 1L;

	private Number suggestedMinimum;

	private Number forcedMinimum;

	private Number suggestedMaximum;

	private Number forcedMaximum;

	private Number stepSize;

	@Override
	public Number getSuggestedMinimum()
	{
		return suggestedMinimum;
	}

	public void setSuggestedMinimum(Number suggestedMinimum)
	{
		this.suggestedMinimum = suggestedMinimum;
	}

	@Override
	public Number getForcedMinimum()
	{
		return forcedMinimum;
	}

	public void setForcedMinimum(Number forcedMinimum)
	{
		this.forcedMinimum = forcedMinimum;
	}

	@Override
	public Number getSuggestedMaximum()
	{
		return suggestedMaximum;
	}

	public void setSuggestedMaximum(Number suggestedMaximum)
	{
		this.suggestedMaximum = suggestedMaximum;
	}

	@Override
	public Number getForcedMaximum()
	{
		return forcedMaximum;
	}

	public void setForcedMaximum(Number forcedMaximum)
	{
		this.forcedMaximum = forcedMaximum;
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
