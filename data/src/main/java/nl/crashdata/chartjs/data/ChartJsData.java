package nl.crashdata.chartjs.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the data-configuration for a chart.
 *
 * Corresponds to the {@code config.data} property.
 *
 * @author haster
 *
 * @param <E>
 *            The type of the elements of the data.
 */
public interface ChartJsData<E extends Serializable> extends Serializable
{
	@JsonProperty("datasets")
	List< ? extends ChartJsDataset<E>> getDatasets();

	@JsonProperty("labels")
	List<String> getLabels();
}
