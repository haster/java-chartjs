package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.simple.SimpleChartJsTickConfig;

public class SimpleChartJsTickConfigBuilder implements SimpleChartJsBuilder<SimpleChartJsTickConfig>
{
	private Number suggestedMinimum;

	private Number forcedMinimum;

	private Number suggestedMaximum;

	private Number forcedMaximum;

	private Number stepSize;

	public SimpleChartJsTickConfigBuilder withSuggestedMinimum(Number suggestedMinimum)
	{
		this.suggestedMinimum = suggestedMinimum;
		return this;
	}

	public SimpleChartJsTickConfigBuilder withForcedMinimum(Number forcedMinimum)
	{
		this.forcedMinimum = forcedMinimum;
		return this;
	}

	public SimpleChartJsTickConfigBuilder withSuggestedMaximum(Number suggestedMaximum)
	{
		this.suggestedMaximum = suggestedMaximum;
		return this;
	}

	public SimpleChartJsTickConfigBuilder withForcedMaximum(Number forcedMaximum)
	{
		this.forcedMaximum = forcedMaximum;
		return this;
	}

	public SimpleChartJsTickConfigBuilder withStepSize(Number stepSize)
	{
		this.stepSize = stepSize;
		return this;
	}

	@Override
	public boolean isValid()
	{
		return true;
	}

	@Override
	public SimpleChartJsTickConfig build() throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsTickConfig ret = new SimpleChartJsTickConfig();
		ret.setForcedMaximum(forcedMaximum);
		ret.setForcedMinimum(forcedMinimum);
		ret.setStepSize(stepSize);
		ret.setSuggestedMaximum(suggestedMaximum);
		ret.setSuggestedMinimum(suggestedMinimum);
		return ret;
	}
}
