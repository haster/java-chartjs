package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface ChartJsConfig<K extends Serializable, V extends Serializable> extends Serializable
{
	@JsonProperty("type")
	String getType();

	@JsonProperty("data")
	ChartJsData<K, V> getData();

	@JsonProperty("options")
	ChartJsOptions getOptions();
}
