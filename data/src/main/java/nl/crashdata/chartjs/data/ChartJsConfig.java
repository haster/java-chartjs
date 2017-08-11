package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the main config for a chart.
 * 
 * Corresponds to the config object that gets added as a parameter in the constructor of the javascript Chart object: {@code var chart = new Chart(ctx, config)}.  
 * @author haster
 *
 * @param <K> The type of the x-axis ('keys') of the data
 * @param <V> The type of the y-axis ('values') of the data.
 */
public interface ChartJsConfig<K extends Serializable, V extends Serializable> extends Serializable
{
	@JsonProperty("type")
	ChartJsChartType getChartType();

	@JsonProperty("data")
	ChartJsData<K, V> getData();

	@JsonProperty("options")
	ChartJsOptions getOptions();
}
