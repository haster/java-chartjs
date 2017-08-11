package nl.crashdata.chartjs.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ChartJsCartesianAxisType
{
	@JsonProperty("linear")
	LINEAR,

	@JsonProperty("logarithmic")
	LOGARITHMIC,

	@JsonProperty("category")
	CATEGORY,

	@JsonProperty("time")
	TIME;
}
