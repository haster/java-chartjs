package nl.crashdata.chartjs.data.simple.builder;

import java.time.LocalDateTime;

import nl.crashdata.chartjs.data.ChartJsCartesianAxisType;

public class SimpleChartJsLocalDateTimeAxisConfigBuilder
		extends AbstractSimpleChartJsAxisConfigBuilder<LocalDateTime>
{
	private SimpleChartJsTemporalTickConfigBuilder<LocalDateTime> tickConfigBuilder =
		new SimpleChartJsTemporalTickConfigBuilder<>();

	public SimpleChartJsLocalDateTimeAxisConfigBuilder()
	{
		super(ChartJsCartesianAxisType.TIME);
	}

	@Override
	public SimpleChartJsTemporalTickConfigBuilder<LocalDateTime> tickConfig()
	{
		return tickConfigBuilder;
	}
}
