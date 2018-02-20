package nl.crashdata.chartjs.data.simple.builder;

import java.time.Instant;

import nl.crashdata.chartjs.data.ChartJsCartesianAxisType;

public class SimpleChartJsInstantAxisConfigBuilder
		extends AbstractSimpleChartJsAxisConfigBuilder<Instant>
{
	private SimpleChartJsTemporalTickConfigBuilder<Instant> tickConfigBuilder =
		new SimpleChartJsTemporalTickConfigBuilder<>();

	public SimpleChartJsInstantAxisConfigBuilder()
	{
		super(ChartJsCartesianAxisType.TIME);
	}

	@Override
	public SimpleChartJsTemporalTickConfigBuilder<Instant> tickConfig()
	{
		return tickConfigBuilder;
	}
}
