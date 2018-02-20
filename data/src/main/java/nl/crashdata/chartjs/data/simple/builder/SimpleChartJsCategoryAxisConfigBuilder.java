package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.ChartJsCartesianAxisType;

public class SimpleChartJsCategoryAxisConfigBuilder
		extends AbstractSimpleChartJsAxisConfigBuilder<String>
{
	private SimpleChartJsLabelTickConfigBuilder tickConfigBuilder =
		new SimpleChartJsLabelTickConfigBuilder();

	public SimpleChartJsCategoryAxisConfigBuilder()
	{
		super(ChartJsCartesianAxisType.CATEGORY);
	}

	@Override
	public SimpleChartJsLabelTickConfigBuilder tickConfig()
	{
		return tickConfigBuilder;
	}
}
