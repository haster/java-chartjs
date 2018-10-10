package nl.crashdata.chartjs.data.simple.builder;

import java.io.Serializable;

import nl.crashdata.chartjs.data.ChartJsChartType;
import nl.crashdata.chartjs.data.simple.SimpleChartJsConfig;

public class SimpleChartJsConfigBuilder<E extends Serializable>
		implements SimpleChartJsBuilder<SimpleChartJsConfig<E>>
{
	public static <E extends Serializable> SimpleChartJsConfigBuilder<E> lineChart()
	{
		return new SimpleChartJsConfigBuilder<E>().withType(ChartJsChartType.LINE);
	}

	public static <E extends Serializable> SimpleChartJsConfigBuilder<E> barChart()
	{
		return new SimpleChartJsConfigBuilder<E>().withType(ChartJsChartType.BAR);
	}

	public static <E extends Serializable> SimpleChartJsConfigBuilder<E> pieChart()
	{
		return new SimpleChartJsConfigBuilder<E>().withType(ChartJsChartType.PIE);
	}

	public static <E extends Serializable> SimpleChartJsConfigBuilder<E> radarChart()
	{
		return new SimpleChartJsConfigBuilder<E>().withType(ChartJsChartType.RADAR);
	}

	public static <E extends Serializable> SimpleChartJsConfigBuilder<E> scatterPlot()
	{
		return new SimpleChartJsConfigBuilder<E>().withType(ChartJsChartType.SCATTER);
	}

	public static <E extends Serializable> SimpleChartJsConfigBuilder<E> bubbleChart()
	{
		return new SimpleChartJsConfigBuilder<E>().withType(ChartJsChartType.BUBBLE);
	}

	public static <E extends Serializable> SimpleChartJsConfigBuilder<E> polarAreaChart()
	{
		return new SimpleChartJsConfigBuilder<E>().withType(ChartJsChartType.POLAR_AREA);
	}

	public static <E extends Serializable> SimpleChartJsConfigBuilder<E> doughnut()
	{
		return new SimpleChartJsConfigBuilder<E>().withType(ChartJsChartType.DOUGHNUT);
	}

	private ChartJsChartType type;

	private SimpleChartJsOptionsBuilder optionsBuilder = new SimpleChartJsOptionsBuilder();

	private SimpleChartJsDataBuilder<E> dataBuilder = new SimpleChartJsDataBuilder<>();

	SimpleChartJsConfigBuilder()
	{
	}

	public SimpleChartJsConfigBuilder<E> withType(ChartJsChartType type)
	{
		this.type = type;
		return this;
	}

	public SimpleChartJsDataBuilder<E> data()
	{
		return dataBuilder;
	}

	public SimpleChartJsOptionsBuilder options()
	{
		return optionsBuilder;
	}

	@Override
	public boolean isValid()
	{
		return type != null && data().isValid() && optionsBuilder.isValid();
	}

	@Override
	public SimpleChartJsConfig<E> build()
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsConfig<E> ret = new SimpleChartJsConfig<>();
		ret.setChartType(type);
		ret.setData(data().build());
		ret.setOptions(optionsBuilder.build());
		return ret;
	}
}
