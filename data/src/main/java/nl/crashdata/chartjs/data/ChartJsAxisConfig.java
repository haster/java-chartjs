package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface ChartJsAxisConfig extends Serializable
{
	@JsonProperty("display")
	Boolean isDisplay();

	@JsonProperty("scaleLabel")
	ChartJsScaleLabelConfig getLabelConfig();

	@JsonProperty("ticks")
	ChartJsTickConfig getTickConfig();

	@JsonProperty("position")
	ChartJsAxisPosition getPosition();

	@JsonProperty("type")
	ChartJsCartesianAxisType getType();
}
