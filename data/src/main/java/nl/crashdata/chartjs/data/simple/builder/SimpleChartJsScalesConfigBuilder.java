package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.ChartJsAxisPosition;
import nl.crashdata.chartjs.data.simple.SimpleChartJsScalesConfig;

public class SimpleChartJsScalesConfigBuilder
		implements SimpleChartJsBuilder<SimpleChartJsScalesConfig>
{
	private SimpleChartJsAxisConfigBuilder xAxisConfigBuilder =
		new SimpleChartJsAxisConfigBuilder().withPosition(ChartJsAxisPosition.BOTTOM);

	private SimpleChartJsAxisConfigBuilder yAxisConfigBuilder =
		new SimpleChartJsAxisConfigBuilder().withPosition(ChartJsAxisPosition.LEFT);

	@Override
	public boolean isValid()
	{
		return xAxisConfigBuilder.isValid() && yAxisConfigBuilder.isValid();
	}

	public SimpleChartJsAxisConfigBuilder xAxisConfig()
	{
		return xAxisConfigBuilder;
	}

	public SimpleChartJsAxisConfigBuilder yAxisConfig()
	{
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
