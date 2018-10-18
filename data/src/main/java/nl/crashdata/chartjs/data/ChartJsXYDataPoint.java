package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface ChartJsXYDataPoint<X extends Serializable, Y extends Serializable> extends Serializable
{
	@JsonProperty("x")
	X getX();

	@JsonProperty("y")
	Y getY();
}
