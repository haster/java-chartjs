package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the tick- or step-configuration for an axis of a chart, ie. what values to display on the axis.
 * 
 * Corresponds to the {@code config.options.scales.xAxes[].ticks} and {@code config.options.scales.yAxes[].ticks} properties.
 * @author haster
 *
 */
public interface ChartJsTickConfig extends Serializable
{
	@JsonProperty("suggestedMin")
	Number getSuggestedMinimum();

	@JsonProperty("min")
	Number getForcedMinimum();

	@JsonProperty("suggestedMax")
	Number getSuggestedMaximum();

	@JsonProperty("max")
	Number getForcedMaximum();

	@JsonProperty("stepSize")
	Number getStepSize();
}
