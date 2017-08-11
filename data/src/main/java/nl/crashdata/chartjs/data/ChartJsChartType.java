package nl.crashdata.chartjs.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ChartJsChartType 
{
	@JsonProperty("line")
	LINE,

	@JsonProperty("bar")
	BAR,

	@JsonProperty("radar")
	RADAR,

	@JsonProperty("pie")
	PIE,

	@JsonProperty("polarArea")
	POLAR_AREA,

	@JsonProperty("bubble")
	BUBBLE,
	
	@JsonProperty("scatter")
	SCATTER;
}
