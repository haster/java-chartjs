package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.ChartJsCartesianAxisType;

public class SimpleChartJsLogarithmicAxisConfigBuilder
		extends AbstractSimpleChartJsAxisConfigBuilder<Number>
{
	private SimpleChartJsNumericalTickConfigBuilder tickConfigBuilder =
		new SimpleChartJsNumericalTickConfigBuilder();

	public SimpleChartJsLogarithmicAxisConfigBuilder()
	{
		super(ChartJsCartesianAxisType.LOGARITHMIC);
	}

	@Override
	public SimpleChartJsNumericalTickConfigBuilder tickConfig()
	{
		return tickConfigBuilder;
	}
}
