package nl.crashdata.chartjs.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface ChartJsScalesConfig extends Serializable
{
	@JsonProperty("xAxes")
	List<ChartJsAxisConfig> getXAxes();

	@JsonProperty("yAxes")
	List<ChartJsAxisConfig> getYAxes();
}
