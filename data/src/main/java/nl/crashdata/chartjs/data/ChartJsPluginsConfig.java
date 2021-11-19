package nl.crashdata.chartjs.data;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the 'plugins'-configuration for a chart, ie. custom and built-in plugins. Built-in
 * contains legend, title and tooltip plugins, among others.
 *
 * Corresponds to the {@code config.options.plugins} property.
 *
 * @author haster
 *
 */
public interface ChartJsPluginsConfig extends Serializable
{
	@JsonProperty("tooltip")
	ChartJsTooltipConfig getTooltipConfig();

	@JsonProperty("title")
	ChartJsTitleConfig getTitleConfig();

	@JsonProperty("legend")
	ChartJsLegendConfig getLegendConfig();

	@JsonAnyGetter
	Map<String, Serializable> getPlugins();
}
