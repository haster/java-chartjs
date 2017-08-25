package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.simple.SimpleChartJsScalesConfig;

public class SimpleChartJsScalesConfigBuilder
		implements SimpleChartJsBuilder<SimpleChartJsScalesConfig>
{
	private SimpleChartJsAxisConfigBuilder xAxisConfigBuilder;

	private SimpleChartJsAxisConfigBuilder yAxisConfigBuilder;

	@Override
	public boolean isValid()
	{
		return xAxisConfigBuilder.isValid() && yAxisConfigBuilder.isValid();
	}

	public SimpleChartJsAxisConfigBuilder xAxisConfig()
	{
		if (this.xAxisConfigBuilder == null)
			this.xAxisConfigBuilder = new SimpleChartJsAxisConfigBuilder();
		return xAxisConfigBuilder;
	}

	public SimpleChartJsAxisConfigBuilder yAxisConfig()
	{
		if (this.yAxisConfigBuilder == null)
			this.yAxisConfigBuilder = new SimpleChartJsAxisConfigBuilder();
		return yAxisConfigBuilder;
	}

	@Override
	public SimpleChartJsScalesConfig build() throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsScalesConfig ret = new SimpleChartJsScalesConfig();
		ret.setxAxis(xAxisConfigBuilder.build());
		ret.setyAxis(yAxisConfigBuilder.build());
		return ret;
	}

}
