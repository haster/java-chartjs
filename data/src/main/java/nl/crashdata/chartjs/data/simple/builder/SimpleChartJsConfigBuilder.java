package nl.crashdata.chartjs.data.simple.builder;

import java.io.Serializable;

import nl.crashdata.chartjs.data.ChartJsChartType;
import nl.crashdata.chartjs.data.simple.SimpleChartJsConfig;

public class SimpleChartJsConfigBuilder<K extends Serializable, V extends Serializable>
		implements SimpleChartJsBuilder<SimpleChartJsConfig<K, V>>
{
	public static <K extends Serializable, V extends Serializable> SimpleChartJsConfigBuilder<K, V>
			lineChart()
	{
		return new SimpleChartJsConfigBuilder<K, V>().withType(ChartJsChartType.LINE);
	}

	private ChartJsChartType type;

	private SimpleChartJsDataBuilder<K, V> dataBuilder = new SimpleChartJsDataBuilder<>();

	private SimpleChartJsOptionsBuilder optionsBuilder = new SimpleChartJsOptionsBuilder();

	private SimpleChartJsConfigBuilder()
	{
	}

	private SimpleChartJsConfigBuilder<K, V> withType(ChartJsChartType type)
	{
		this.type = type;
		return this;
	}

	public SimpleChartJsDataBuilder<K, V> data()
	{
		if (this.dataBuilder == null)
			this.dataBuilder = new SimpleChartJsDataBuilder<>();
		return dataBuilder;
	}

	public SimpleChartJsOptionsBuilder options()
	{
		if (this.optionsBuilder == null)
			this.optionsBuilder = new SimpleChartJsOptionsBuilder();
		return optionsBuilder;
	}

	@Override
	public boolean isValid()
	{
		return type != null && dataBuilder.isValid() && optionsBuilder.isValid();
	}

	@Override
	public SimpleChartJsConfig<K, V> build()
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsConfig<K, V> ret = new SimpleChartJsConfig<>();
		ret.setChartType(type);
		ret.setData(dataBuilder.build());
		ret.setOptions(optionsBuilder.build());
		return ret;
	}
}
