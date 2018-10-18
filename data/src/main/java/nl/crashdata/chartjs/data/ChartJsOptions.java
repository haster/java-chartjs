package nl.crashdata.chartjs.data;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the 'options'-configuration for a chart, ie. options that don't correspond directly to
 * a dataset.
 *
 * Corresponds to the {@code config.options} property.
 *
 * @author haster
 *
 */
public interface ChartJsOptions extends Serializable
{
	@JsonProperty("responsive")
	Boolean getResponsive();

	@JsonProperty("maintainAspectRatio")
	Boolean getMaintainAspectRatio();

	@JsonProperty("cutoutPercentage")
	Integer getCutoutPercentage();

	@JsonProperty("rotation")
	Integer getRotation();

	@JsonProperty("circumference")
	Integer getCircumference();

	@JsonProperty("tooltips")
	ChartJsTooltipConfig getTooltipConfig();

	@JsonProperty("hover")
	ChartJsHoverConfig getHoverConfig();

	@JsonProperty("scales")
	ChartJsScalesConfig getScalesConfig();

	@JsonProperty("title")
	ChartJsTitleConfig getTitleConfig();

	@JsonProperty("legend")
	ChartJsLegendConfig getLegendConfig();

	@JsonProperty("plugins")
	Map<String, Serializable> getPlugins();
}
