package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the tick- or step-configuration for an axis of a chart, ie. what values to display on
 * the axis.
 *
 * Corresponds to the {@code config.options.scales.xAxes[].ticks} and
 * {@code config.options.scales.yAxes[].ticks} properties.
 *
 * @author haster
 *
 */
public interface ChartJsTickConfig<T extends Serializable> extends Serializable
{
	@JsonProperty("suggestedMin")
	T getSuggestedMinimum();

	@JsonProperty("min")
	T getForcedMinimum();

	@JsonProperty("suggestedMax")
	T getSuggestedMaximum();

	@JsonProperty("max")
	T getForcedMaximum();

	@JsonProperty("stepSize")
	T getStepSize();
}
