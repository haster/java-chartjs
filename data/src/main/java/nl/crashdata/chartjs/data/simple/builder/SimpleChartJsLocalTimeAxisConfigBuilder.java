package nl.crashdata.chartjs.data.simple.builder;

import java.time.LocalTime;

import nl.crashdata.chartjs.data.ChartJsCartesianAxisType;

public class SimpleChartJsLocalTimeAxisConfigBuilder
		extends AbstractSimpleChartJsAxisConfigBuilder<LocalTime>
{
	private SimpleChartJsTemporalTickConfigBuilder<LocalTime> tickConfigBuilder =
		new SimpleChartJsTemporalTickConfigBuilder<>();

	public SimpleChartJsLocalTimeAxisConfigBuilder()
	{
		super(ChartJsCartesianAxisType.TIME);
		setTimeConfigBuilder(new SimpleChartJsTimeConfigBuilder());
	}

	@Override
	public SimpleChartJsTemporalTickConfigBuilder<LocalTime> tickConfig()
	{
		return tickConfigBuilder;
	}

	@Override
	public SimpleChartJsTimeConfigBuilder timeConfig()
	{
		return super.timeConfig();
	}
}
