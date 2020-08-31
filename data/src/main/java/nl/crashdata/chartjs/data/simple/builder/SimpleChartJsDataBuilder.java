package nl.crashdata.chartjs.data.simple.builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import nl.crashdata.chartjs.data.simple.SimpleChartJsData;

public class SimpleChartJsDataBuilder<V extends Serializable>
		implements ChartJsBuildContextBuilder<SimpleChartJsData<V>>
{
	private List<SimpleChartJsDatasetBuilder<V>> datasets = new ArrayList<>();

	private List<String> labels = null;

	@Override
	public boolean isValid()
	{
		return datasets.stream().allMatch(SimpleChartJsBuilder::isValid);
	}

	public SimpleChartJsDatasetBuilder<V> addDataset()
	{
		SimpleChartJsDatasetBuilder<V> dataset = new SimpleChartJsDatasetBuilder<>();
		datasets.add(dataset);
		return dataset;
	}

	public SimpleChartJsDataBuilder<V> withDatasets(List<SimpleChartJsDatasetBuilder<V>> datasets)
	{
		this.datasets = datasets;
		return this;
	}

	public SimpleChartJsDataBuilder<V> withLabels(List<String> labels)
	{
		this.labels = labels;
		return this;
	}

	@Override
	public SimpleChartJsData<V> build(BuildContext context) throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsData<V> ret = new SimpleChartJsData<>();
		ret.setDatasets(datasets.stream().map(b -> b.build(context)).collect(Collectors.toList()));
		ret.setLabels(labels);
		return ret;
	}
}
