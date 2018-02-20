package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.ChartJsCartesianAxisType;

public class SimpleChartJsLinearAxisConfigBuilder
		extends AbstractSimpleChartJsAxisConfigBuilder<Number>
{
	private SimpleChartJsNumericalTickConfigBuilder tickConfigBuilder =
		new SimpleChartJsNumericalTickConfigBuilder();

	public SimpleChartJsLinearAxisConfigBuilder()
	{
		super(ChartJsCartesianAxisType.LINEAR);
	}

	@Override
	public SimpleChartJsNumericalTickConfigBuilder tickConfig()
	{
		return tickConfigBuilder;
	}
}
