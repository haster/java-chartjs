package nl.crashdata.chartjs.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.crashdata.chartjs.data.simple.SimpleChartJsDataset;

public interface ChartJsData<K extends Serializable, V extends Serializable> extends Serializable
{
	@JsonProperty("labels")
	List<K> getLabels();

	@JsonProperty("datasets")
	List<SimpleChartJsDataset<V>> getDatasets();
}
