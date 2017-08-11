package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface ChartJsHoverConfig extends Serializable
{
	@JsonProperty("mode")
	ChartJsInteractionMode getMode();

	@JsonProperty("intersect")
	boolean isIntersect();
}
