package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.ChartJsInteractionMode;
import nl.crashdata.chartjs.data.simple.SimpleChartJsTooltipConfig;

public class SimpleChartJsTooltipConfigBuilder
		implements SimpleChartJsBuilder<SimpleChartJsTooltipConfig>
{
	private ChartJsInteractionMode mode;

	private Boolean intersect;

	public SimpleChartJsTooltipConfigBuilder withMode(ChartJsInteractionMode mode)
	{
		this.mode = mode;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withIntersect(Boolean intersect)
	{
		this.intersect = intersect;
		return this;
	}

	@Override
	public boolean isValid()
	{
		return true;
	}

	@Override
	public SimpleChartJsTooltipConfig build() throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsTooltipConfig ret = new SimpleChartJsTooltipConfig();
		ret.setIntersect(intersect);
		ret.setMode(mode);
		return ret;
	}

}
