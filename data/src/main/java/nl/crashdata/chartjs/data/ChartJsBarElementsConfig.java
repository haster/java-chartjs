package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.crashdata.chartjs.data.colors.ChartJsRGBAColor;

public interface ChartJsBarElementsConfig extends Serializable
{
	@JsonProperty("backgroundColor")
	ChartJsRGBAColor getBackgroundColor();

	@JsonProperty("borderColor")
	ChartJsRGBAColor getBorderColor();

	@JsonProperty("borderWidth")
	Integer getBorderWidth();

	@JsonProperty("borderSkipped")
	ChartJsBorderSkipped getBorderSkipped();

	@JsonProperty("borderRadius")
	Integer getBorderRadius();

	@JsonProperty("inflateAmount")
	Integer getInflateAmount();

	@JsonProperty("pointStyle")
	String getPointStyle();
}
