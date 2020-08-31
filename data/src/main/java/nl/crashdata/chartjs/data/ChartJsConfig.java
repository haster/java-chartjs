package nl.crashdata.chartjs.data;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the main config for a chart.
 *
 * Corresponds to the config object that gets added as a parameter in the constructor of the
 * javascript Chart object: {@code var chart = new Chart(ctx, config)}.
 *
 * @author haster
 *
 * @param <E>
 *            The type of the elements of the data.
 */
public interface ChartJsConfig<E extends Serializable> extends Serializable
{
	@JsonIgnore
	Set<ChartJsLocalEventHandler> getLocalEventHandlers();

	@JsonProperty("type")
	ChartJsChartType getChartType();

	@JsonProperty("data")
	ChartJsData<E> getData();

	@JsonProperty("options")
	ChartJsOptions getOptions();
}
