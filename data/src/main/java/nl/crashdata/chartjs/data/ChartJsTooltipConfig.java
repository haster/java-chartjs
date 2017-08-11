package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the tooltip-configuration for a chart, ie. when to show a tooltip (and what to show in the tooltip) when the user hovers over the chart with their mousepointer.
 * 
 * Corresponds to the {@code config.options.tooltips} property.
 * @author haster
 *
 */
public interface ChartJsTooltipConfig extends Serializable
{
	@JsonProperty("mode")
	ChartJsInteractionMode getMode();

	@JsonProperty("intersect")
	Boolean isIntersect();
}
