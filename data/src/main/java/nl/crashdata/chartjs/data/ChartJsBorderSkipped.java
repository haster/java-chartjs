package nl.crashdata.chartjs.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ChartJsBorderSkipped
{
	@JsonProperty("start")
	START,

	@JsonProperty("end")
	END,

	@JsonProperty("top")
	TOP,

	@JsonProperty("middle")
	MIDDLE,

	@JsonProperty("bottom")
	BOTTOM,

	@JsonProperty("left")
	LEFT,

	@JsonProperty("right")
	RIGHT,

	@JsonProperty("false")
	DISABLE,
}
