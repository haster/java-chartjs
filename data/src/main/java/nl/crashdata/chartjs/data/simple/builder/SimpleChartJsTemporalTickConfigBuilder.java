package nl.crashdata.chartjs.data.simple.builder;

import java.io.Serializable;
import java.time.temporal.Temporal;

import nl.crashdata.chartjs.data.simple.SimpleChartJsTemporalTickConfig;

public class SimpleChartJsTemporalTickConfigBuilder<T extends Temporal & Serializable>
		extends AbstractSimpleChartJsTickConfigBuilder<T, SimpleChartJsTemporalTickConfig<T>>
{
	@Override
	protected SimpleChartJsTemporalTickConfig<T> createNewTickConfig()
	{
		return new SimpleChartJsTemporalTickConfig<>();
	}
}
