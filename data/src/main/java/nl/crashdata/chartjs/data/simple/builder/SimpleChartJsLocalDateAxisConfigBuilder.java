package nl.crashdata.chartjs.data.simple.builder;

import java.time.LocalDate;

import nl.crashdata.chartjs.data.ChartJsCartesianAxisType;

public class SimpleChartJsLocalDateAxisConfigBuilder
		extends AbstractSimpleChartJsAxisConfigBuilder<LocalDate>
{
	private SimpleChartJsTemporalTickConfigBuilder<LocalDate> tickConfigBuilder =
		new SimpleChartJsTemporalTickConfigBuilder<>();

	public SimpleChartJsLocalDateAxisConfigBuilder()
	{
		super(ChartJsCartesianAxisType.TIME);
	}

	@Override
	public SimpleChartJsTemporalTickConfigBuilder<LocalDate> tickConfig()
	{
		return tickConfigBuilder;
	}
}
