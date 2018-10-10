package nl.crashdata.chartjs.data.simple;

import java.io.Serializable;
import java.util.List;

import nl.crashdata.chartjs.data.ChartJsData;
import nl.crashdata.chartjs.data.ChartJsDataset;

public class SimpleChartJsData<V extends Serializable> implements ChartJsData<V>
{
	private static final long serialVersionUID = 1L;

	private List<ChartJsDataset<V>> datasets;

	private List<String> labels;

	@Override
	public List<ChartJsDataset<V>> getDatasets()
	{
		return datasets;
	}

	public void setDatasets(List<ChartJsDataset<V>> datasets)
	{
		this.datasets = datasets;
	}

	@Override
	public List<String> getLabels()
	{
		return labels;
	}

	public void setLabels(List<String> labels)
	{
		this.labels = labels;
	}
}
