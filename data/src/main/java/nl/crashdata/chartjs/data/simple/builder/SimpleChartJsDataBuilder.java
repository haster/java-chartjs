package nl.crashdata.chartjs.data.simple.builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import nl.crashdata.chartjs.data.simple.SimpleChartJsData;

public class SimpleChartJsDataBuilder<K extends Serializable, V extends Serializable>
		implements SimpleChartJsBuilder<SimpleChartJsData<K, V>>
{
	private List<SimpleChartJsDatasetBuilder<K, V>> datasets = new ArrayList<>();

	@Override
	public boolean isValid()
	{
		return datasets.stream().allMatch(SimpleChartJsBuilder::isValid);
	}

	public SimpleChartJsDatasetBuilder<K, V> addDataset()
	{
		SimpleChartJsDatasetBuilder<K, V> dataset = new SimpleChartJsDatasetBuilder<>();
		datasets.add(dataset);
		return dataset;
	}

	public SimpleChartJsDataBuilder<K, V>
			withDatasets(List<SimpleChartJsDatasetBuilder<K, V>> datasets)
	{
		this.datasets = datasets;
		return this;
	}

	@Override
	public SimpleChartJsData<K, V> build() throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsData<K, V> ret = new SimpleChartJsData<>();
		ret.setDatasets(
			datasets.stream().map(SimpleChartJsBuilder::build).collect(Collectors.toList()));
		return ret;
	}
}
