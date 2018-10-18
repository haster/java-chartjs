package nl.crashdata.chartjs.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ChartJsTooltipPositioning
{
	@JsonProperty("average")
	AVERAGE,

	@JsonProperty("nearest")
	NEAREST
}
