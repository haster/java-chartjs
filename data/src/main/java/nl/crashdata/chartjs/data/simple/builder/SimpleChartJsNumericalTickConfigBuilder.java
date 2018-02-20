package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.simple.SimpleChartJsNumericalTickConfig;

public class SimpleChartJsNumericalTickConfigBuilder
		extends AbstractSimpleChartJsTickConfigBuilder<Number, SimpleChartJsNumericalTickConfig>
{
	@Override
	protected SimpleChartJsNumericalTickConfig createNewTickConfig()
	{
		return new SimpleChartJsNumericalTickConfig();
	}
}
