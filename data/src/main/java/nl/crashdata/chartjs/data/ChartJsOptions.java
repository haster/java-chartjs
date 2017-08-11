package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the 'options'-configuration for a chart, ie. options that don't correspond directly to a dataset.
 * 
 * Corresponds to the {@code config.options} property.
 * @author haster
 *
 */
public interface ChartJsOptions extends Serializable
{
	@JsonProperty("responsive")
	Boolean isResponsive();

	@JsonProperty("tooltips")
	ChartJsTooltipConfig getTooltipConfig();

	@JsonProperty("hover")
	ChartJsHoverConfig getHoverConfig();

	@JsonProperty("scales")
	ChartJsScalesConfig getScalesConfig();
}
