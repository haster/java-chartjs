package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the hover-configuration for a chart, ie. how to determine which element of a chart gets highlighted when the user hovers over the chart with their mousepointer.
 * 
 * Corresponds to the {@code config.options.hover} property.
 * @author haster
 *
 */
public interface ChartJsHoverConfig extends Serializable
{
	@JsonProperty("mode")
	ChartJsInteractionMode getMode();

	@JsonProperty("intersect")
	Boolean isIntersect();
}
