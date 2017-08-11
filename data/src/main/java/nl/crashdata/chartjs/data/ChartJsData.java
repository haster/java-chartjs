package nl.crashdata.chartjs.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.crashdata.chartjs.data.simple.SimpleChartJsDataset;

/**
 * Represents the data-configuration for a chart.
 * 
 * Corresponds to the {@code config.data} property.
 *   
 * @author haster
 * 
 * @param <K> The type of the x-axis ('keys') of the data
 * @param <V> The type of the y-axis ('values') of the data.
 */
public interface ChartJsData<K extends Serializable, V extends Serializable> extends Serializable
{
	@JsonProperty("labels")
	List<K> getLabels();

	@JsonProperty("datasets")
	List<SimpleChartJsDataset<V>> getDatasets();
}
