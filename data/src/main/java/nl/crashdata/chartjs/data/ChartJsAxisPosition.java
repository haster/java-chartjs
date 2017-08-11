package nl.crashdata.chartjs.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ChartJsAxisPosition
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
