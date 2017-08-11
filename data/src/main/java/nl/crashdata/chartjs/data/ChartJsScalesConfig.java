package nl.crashdata.chartjs.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the scale-configuration for a chart, ie. how to display an axis.
 * 
 * Corresponds to the {@code config.options.scales} property.
 * @author haster
 *
 */
public interface ChartJsScalesConfig extends Serializable
{
	@JsonProperty("xAxes")
	List<ChartJsAxisConfig> getXAxes();

	@JsonProperty("yAxes")
	List<ChartJsAxisConfig> getYAxes();
}
