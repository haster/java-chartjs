package nl.crashdata.chartjs.data.simple;

import java.io.Serializable;
import java.util.List;

import nl.crashdata.chartjs.data.ChartJsData;

public class SimpleChartJsData<K extends Serializable, V extends Serializable>
		implements ChartJsData<K, V>
{
	private static final long serialVersionUID = 1L;

	private List<K> labels;

	private List<SimpleChartJsDataset<V>> datasets;

	@Override
	public List<K> getLabels()
	{
		return labels;
	}

	@Override
	public List<SimpleChartJsDataset<V>> getDatasets()
	{
		return datasets;
	}

	public void setDatasets(List<SimpleChartJsDataset<V>> datasets)
	{
		this.datasets = datasets;
	}

	public void setLabels(List<K> labels)
	{
		this.labels = labels;
	}
}
