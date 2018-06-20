package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the time-specific configuration for a specific axis of the type 'time'.
 *
 * Corresponds to the elements of the {@code config.options.scales.xAxes[].time} and
 * {@code config.options.scales.yAxes[].time} properties.
 *
 * @see "http://www.chartjs.org/docs/latest/axes/cartesian/time.html"
 * @author haster
 */
public interface ChartJsTimeConfig extends Serializable
{
	/**
	 * if {@code true}, Monday will be considered the first day of the week, otherwise it will be
	 * Sunday. Only relevant if the unit is set to {@link ChartJsTimeUnit#WEEK}
	 */
	@JsonProperty("isoWeekday")
	Boolean getIsoWeekday();

	@JsonProperty("unit")
	ChartJsTimeUnit getTimeUnit();

	@JsonProperty("minUnit")
	ChartJsTimeUnit getMinimumDisplayUnit();

	@JsonProperty("stepSize")
	Number getStepSize();
}
