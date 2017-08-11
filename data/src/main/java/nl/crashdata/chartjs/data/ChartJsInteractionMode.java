package nl.crashdata.chartjs.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ChartJsInteractionMode
{
	@JsonProperty("point")
	POINT,

	@JsonProperty("nearest")
	NEAREST,

	@JsonProperty("index")
	INDEX,

	@JsonProperty("dataset")
	DATASET,

	@JsonProperty("x")
	X,

	@JsonProperty("y")
	Y;
}
