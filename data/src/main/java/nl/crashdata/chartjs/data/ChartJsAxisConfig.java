package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the configuration for a specific axis.
 * 
 * Corresponds to the elements of the {@code config.options.scales.xAxes} and {@code config.options.scales.yAxes} properties.
 *   
 * @author haster
 */
public interface ChartJsAxisConfig extends Serializable
{
	@JsonProperty("display")
	Boolean isDisplay();

	@JsonProperty("scaleLabel")
	ChartJsScaleLabelConfig getLabelConfig();

	@JsonProperty("ticks")
	ChartJsTickConfig getTickConfig();

	@JsonProperty("position")
	ChartJsAxisPosition getPosition();

	@JsonProperty("type")
	ChartJsCartesianAxisType getType();
}