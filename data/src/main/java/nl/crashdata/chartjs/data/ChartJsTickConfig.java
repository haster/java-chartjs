package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface ChartJsTickConfig extends Serializable
{
	@JsonProperty("suggestedMin")
	Number getSuggestedMinimum();

	@JsonProperty("min")
	Number getForcedMinimum();

	@JsonProperty("suggestedMax")
	Number getSuggestedMaximum();

	@JsonProperty("max")
	Number getForcedMaximum();

	@JsonProperty("stepSize")
	Number getStepSize();
}
