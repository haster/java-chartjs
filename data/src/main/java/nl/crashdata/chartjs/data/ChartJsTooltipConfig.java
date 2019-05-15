package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.crashdata.chartjs.data.colors.ChartJsRGBAColor;

/**
 * Represents the tooltip-configuration for a chart, ie. when to show a tooltip (and what to show in
 * the tooltip) when the user hovers over the chart with their mousepointer.
 *
 * Corresponds to the {@code config.options.tooltips} property.
 *
 * @author haster
 *
 */
public interface ChartJsTooltipConfig extends Serializable
{
	@JsonProperty("enabled")
	Boolean getEnabled();

	@JsonProperty("mode")
	ChartJsInteractionMode getMode();

	@JsonProperty("intersect")
	Boolean getIntersect();

	@JsonProperty("position")
	ChartJsTooltipPositioning getPosition();

	@JsonProperty("backgroundColor")
	ChartJsRGBAColor getBackgroundColor();

	@JsonProperty("titleFontFamily")
	String getTitleFontFamily();

	@JsonProperty("titleFontSize")
	Integer getTitleFontSize();

	@JsonProperty("titleFontStyle")
	String getTitleFontStyle();

	@JsonProperty("titleFontColor")
	ChartJsRGBAColor getTitleFontColor();

	@JsonProperty("titleSpacing")
	Integer getTitleSpacing();

	@JsonProperty("titleMarginBottom")
	Integer getTitleMarginBottom();

	@JsonProperty("bodyFontFamily")
	String getBodyFontFamily();

	@JsonProperty("bodyFontSize")
	Integer getBodyFontSize();

	@JsonProperty("bodyFontStyle")
	String getBodyFontStyle();

	@JsonProperty("bodyFontColor")
	ChartJsRGBAColor getBodyFontColor();

	@JsonProperty("bodySpacing")
	Integer getBodySpacing();

	@JsonProperty("footerFontFamily")
	String getFooterFontFamily();

	@JsonProperty("footerFontSize")
	Integer getFooterFontSize();

	@JsonProperty("footerFontStyle")
	String getFooterFontStyle();

	@JsonProperty("footerFontColor")
	ChartJsRGBAColor getFooterFontColor();

	@JsonProperty("footerSpacing")
	Integer getFooterSpacing();

	@JsonProperty("footerMarginTop")
	Integer getFooterMarginTop();

	@JsonProperty("xPadding")
	Integer getXPadding();

	@JsonProperty("yPadding")
	Integer getYPadding();

	@JsonProperty("caretPadding")
	Integer getCaretPadding();

	@JsonProperty("caretSize")
	Integer getCaretSize();

	@JsonProperty("cornerRadius")
	Integer getCornerRadius();

	@JsonProperty("multiKeyBackground")
	ChartJsRGBAColor getMultiKeyBackground();

	@JsonProperty("displayColors")
	Boolean getDisplayColors();

	@JsonProperty("borderColor")
	ChartJsRGBAColor getBorderColor();

	@JsonProperty("borderWidth")
	Integer getBorderWidth();
}
