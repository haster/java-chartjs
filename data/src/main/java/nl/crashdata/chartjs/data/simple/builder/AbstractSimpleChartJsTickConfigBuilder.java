package nl.crashdata.chartjs.data.simple.builder;

import java.io.Serializable;

import nl.crashdata.chartjs.data.simple.AbstractSimpleChartJsTickConfig;

public abstract class AbstractSimpleChartJsTickConfigBuilder<E extends Serializable,
		T extends AbstractSimpleChartJsTickConfig<E>> implements ChartJsBuildContextBuilder<T>
{
	private E suggestedMinimum;

	private E forcedMinimum;

	private E suggestedMaximum;

	private E forcedMaximum;

	private E stepSize;

	public AbstractSimpleChartJsTickConfigBuilder<E, T> withSuggestedMinimum(E suggestedMinimum)
	{
		this.suggestedMinimum = suggestedMinimum;
		return this;
	}

	public AbstractSimpleChartJsTickConfigBuilder<E, T> withForcedMinimum(E forcedMinimum)
	{
		this.forcedMinimum = forcedMinimum;
		return this;
	}

	public AbstractSimpleChartJsTickConfigBuilder<E, T> withSuggestedMaximum(E suggestedMaximum)
	{
		this.suggestedMaximum = suggestedMaximum;
		return this;
	}

	public AbstractSimpleChartJsTickConfigBuilder<E, T> withForcedMaximum(E forcedMaximum)
	{
		this.forcedMaximum = forcedMaximum;
		return this;
	}

	public AbstractSimpleChartJsTickConfigBuilder<E, T> withStepSize(E stepSize)
	{
		this.stepSize = stepSize;
		return this;
	}

	@Override
	public boolean isValid()
	{
		return true;
	}

	protected abstract T createNewTickConfig();

	@Override
	public T build(BuildContext context) throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		T ret = createNewTickConfig();
		ret.setForcedMaximum(forcedMaximum);
		ret.setForcedMinimum(forcedMinimum);
		ret.setStepSize(stepSize);
		ret.setSuggestedMaximum(suggestedMaximum);
		ret.setSuggestedMinimum(suggestedMinimum);
		return ret;
	}
}
