package nl.crashdata.chartjs.data.simple.builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import nl.crashdata.chartjs.data.ChartJsDataPoint;
import nl.crashdata.chartjs.data.simple.SimpleChartJsDataPoint;
import nl.crashdata.chartjs.data.simple.SimpleChartJsDataset;

public class SimpleChartJsDatasetBuilder<K extends Serializable, V extends Serializable>
		implements SimpleChartJsBuilder<SimpleChartJsDataset<K, V>>
{
	private String label;

	private String backgroundColor;

	private String borderColor;

	private String fill = "false";

	private List<ChartJsDataPoint<K, V>> data = new ArrayList<>();

	public SimpleChartJsDatasetBuilder<K, V> withLabel(String label)
	{
		this.label = label;
		return this;
	}

	public SimpleChartJsDatasetBuilder<K, V> withBackgroundColor(String backgroundColor)
	{
		this.backgroundColor = backgroundColor;
		return this;
	}

	public SimpleChartJsDatasetBuilder<K, V> withBorderColor(String borderColor)
	{
		this.borderColor = borderColor;
		return this;
	}

	public SimpleChartJsDatasetBuilder<K, V> withFill(String fill)
	{
		this.fill = fill;
		return this;
	}

	public SimpleChartJsDatasetBuilder<K, V> withDataPoints(List<ChartJsDataPoint<K, V>> dataPoints)
	{
		this.data = dataPoints;
		return this;
	}

	public SimpleChartJsDatasetBuilder<K, V> withDataPoints(Map<K, V> dataPoints)
	{
		this.data = dataPoints.entrySet()
			.stream()
			.map(e -> new SimpleChartJsDataPoint<>(e.getKey(), e.getValue()))
			.collect(Collectors.toList());
		return this;
	}

	public SimpleChartJsDatasetBuilder<K, V> addDataPoint(ChartJsDataPoint<K, V> dataPoint)
	{
		this.data.add(dataPoint);
		return this;
	}

	public SimpleChartJsDatasetBuilder<K, V> addDataPoint(K x, V y)
	{
		this.data.add(new SimpleChartJsDataPoint<>(x, y));
		return this;
	}

	@Override
	public boolean isValid()
	{
		return !data.isEmpty();
	}

	@Override
	public SimpleChartJsDataset<K, V> build() throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsDataset<K, V> ret = new SimpleChartJsDataset<>();
		ret.setBackgroundColor(backgroundColor);
		ret.setBorderColor(borderColor);
		ret.setData(data);
		ret.setLabel(label);
		ret.setFill(fill);
		return ret;
	}
}
