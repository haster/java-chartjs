package nl.crashdata.chartjs.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.crashdata.chartjs.colors.ChartJsRGBAColor;

/**
 * Represents the title-configuration for a chart.
 *
 * Corresponds to the {@code config.options.title} property.
 *
 * @author papegaaij
 *
 */
public interface ChartJsTitleConfig extends Serializable
{
	@JsonProperty("display")
	Boolean getDisplay();

	@JsonProperty("position")
	ChartJsPosition getPosition();

	@JsonProperty("fontSize")
	Integer getFontSize();

	@JsonProperty("fontFamily")
	String getFontFamily();

	@JsonProperty("fontColor")
	ChartJsRGBAColor getFontColor();

	@JsonProperty("fontStyle")
	String getFontStyle();

	@JsonProperty("padding")
	Integer getPadding();

	@JsonProperty("lineHeight")
	String getLineHeight();

	@JsonProperty("text")
	List<String> getText();
}
