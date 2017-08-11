package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the scale-label-configuration for a chart, ie. the label for an axis.
 * 
 * Corresponds to the {@code config.options.scales.xAxes[].scaleLabel} and {@code config.options.scales.yAxes[].scaleLabel} properties.
 * @author haster
 *
 */
public interface ChartJsScaleLabelConfig extends Serializable
{
	@JsonProperty("display")
	Boolean isDisplay();

	@JsonProperty("labelString")
	String getLabelString();
}
