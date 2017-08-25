package nl.crashdata.chartjs.data.simple;

import java.io.Serializable;
import java.util.List;

import nl.crashdata.chartjs.data.ChartJsData;
import nl.crashdata.chartjs.data.ChartJsDataset;

public class SimpleChartJsData<K extends Serializable, V extends Serializable>
		implements ChartJsData<K, V>
{
	private static final long serialVersionUID = 1L;

	private List<ChartJsDataset<K, V>> datasets;

	@Override
	public List<ChartJsDataset<K, V>> getDatasets()
	{
		return datasets;
	}

	public void setDatasets(List<ChartJsDataset<K, V>> datasets)
	{
		this.datasets = datasets;
	}
}
