package nl.crashdata.chartjs.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ChartJsPosition
{
	@JsonProperty("top")
	TOP,

	@JsonProperty("left")
	LEFT,

	@JsonProperty("bottom")
	BOTTOM,

	@JsonProperty("right")
	RIGHT;
}
