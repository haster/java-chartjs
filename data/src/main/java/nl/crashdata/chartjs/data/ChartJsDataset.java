package nl.crashdata.chartjs.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface ChartJsDataset<V extends Serializable> extends Serializable
{
	@JsonProperty("label")
	String getLabel();

	@JsonProperty("backgroundColor")
	String getBackgroundColor();

	@JsonProperty("borderColor")
	String getBorderColor();

	@JsonProperty("data")
	List<V> getData();

	@JsonProperty("fill")
	boolean isFill();
}
