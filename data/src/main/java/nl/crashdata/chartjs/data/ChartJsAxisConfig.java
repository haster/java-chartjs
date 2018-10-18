package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the configuration for a specific axis.
 *
 * Corresponds to the elements of the {@code config.options.scales.xAxes} and
 * {@code config.options.scales.yAxes} properties.
 *
 * @author haster
 */
public interface ChartJsAxisConfig<T extends Serializable> extends Serializable
{
	@JsonProperty("display")
	Boolean isDisplay();

	@JsonProperty("scaleLabel")
	ChartJsScaleLabelConfig getLabelConfig();

	@JsonProperty("ticks")
	ChartJsTickConfig<T> getTickConfig();

	@JsonProperty("position")
	ChartJsPosition getPosition();

	@JsonProperty("type")
	ChartJsCartesianAxisType getType();

	@JsonProperty("time")
	ChartJsTimeConfig getTimeConfig();
}
