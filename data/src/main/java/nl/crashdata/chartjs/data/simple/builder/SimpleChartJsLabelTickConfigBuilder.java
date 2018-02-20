package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.simple.SimpleChartJsLabelTickConfig;

public class SimpleChartJsLabelTickConfigBuilder
		extends AbstractSimpleChartJsTickConfigBuilder<String, SimpleChartJsLabelTickConfig>
{
	@Override
	protected SimpleChartJsLabelTickConfig createNewTickConfig()
	{
		return new SimpleChartJsLabelTickConfig();
	}
}
