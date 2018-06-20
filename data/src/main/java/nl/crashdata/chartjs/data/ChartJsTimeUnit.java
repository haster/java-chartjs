package nl.crashdata.chartjs.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ChartJsTimeUnit
{
	@JsonProperty("millisecond")
	MILLISECOND,

	@JsonProperty("second")
	SECOND,

	@JsonProperty("minute")
	MINUTE,

	@JsonProperty("hour")
	HOUR,

	@JsonProperty("day")
	DAY,

	@JsonProperty("week")
	WEEK,

	@JsonProperty("month")
	MONTH,

	@JsonProperty("quarter")
	QUARTER,

	@JsonProperty("year")
	YEAR;
}
