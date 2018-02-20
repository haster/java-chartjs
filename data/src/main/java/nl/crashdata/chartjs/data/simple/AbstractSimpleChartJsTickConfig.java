package nl.crashdata.chartjs.data.simple;

import java.io.Serializable;

import nl.crashdata.chartjs.data.ChartJsTickConfig;

public abstract class AbstractSimpleChartJsTickConfig<T extends Serializable>
		implements ChartJsTickConfig<T>
{
	private static final long serialVersionUID = 1L;

	private T suggestedMinimum;

	private T forcedMinimum;

	private T suggestedMaximum;

	private T forcedMaximum;

	private T stepSize;

	@Override
	public T getSuggestedMinimum()
	{
		return suggestedMinimum;
	}

	public void setSuggestedMinimum(T suggestedMinimum)
	{
		this.suggestedMinimum = suggestedMinimum;
	}

	@Override
	public T getForcedMinimum()
	{
		return forcedMinimum;
	}

	public void setForcedMinimum(T forcedMinimum)
	{
		this.forcedMinimum = forcedMinimum;
	}

	@Override
	public T getSuggestedMaximum()
	{
		return suggestedMaximum;
	}

	public void setSuggestedMaximum(T suggestedMaximum)
	{
		this.suggestedMaximum = suggestedMaximum;
	}

	@Override
	public T getForcedMaximum()
	{
		return forcedMaximum;
	}

	public void setForcedMaximum(T forcedMaximum)
	{
		this.forcedMaximum = forcedMaximum;
	}

	@Override
	public T getStepSize()
	{
		return stepSize;
	}

	public void setStepSize(T stepSize)
	{
		this.stepSize = stepSize;
	}

}
