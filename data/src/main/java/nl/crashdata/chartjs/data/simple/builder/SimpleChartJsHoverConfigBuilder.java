package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.ChartJsInteractionMode;
import nl.crashdata.chartjs.data.simple.SimpleChartJsHoverConfig;

public class SimpleChartJsHoverConfigBuilder
		implements SimpleChartJsBuilder<SimpleChartJsHoverConfig>
{
	private ChartJsInteractionMode mode;

	private Boolean intersect;

	public SimpleChartJsHoverConfigBuilder withMode(ChartJsInteractionMode mode)
	{
		this.mode = mode;
		return this;
	}

	public SimpleChartJsHoverConfigBuilder withIntersect(Boolean intersect)
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
	public SimpleChartJsHoverConfig build() throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsHoverConfig ret = new SimpleChartJsHoverConfig();
		ret.setIntersect(intersect);
		ret.setMode(mode);
		return ret;
	}
}
