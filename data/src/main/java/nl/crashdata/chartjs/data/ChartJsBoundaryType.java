package nl.crashdata.chartjs.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ChartJsBoundaryType {
	@JsonProperty("start")
	START, 
	
	@JsonProperty("end")
	END, 
	
	@JsonProperty("origin")
	ORIGIN;
}