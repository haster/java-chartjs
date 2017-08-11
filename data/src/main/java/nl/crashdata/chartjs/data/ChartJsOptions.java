package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

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
