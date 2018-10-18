package nl.crashdata.chartjs.data.simple;

import nl.crashdata.chartjs.colors.ChartJsRGBAColor;
import nl.crashdata.chartjs.data.ChartJsInteractionMode;
import nl.crashdata.chartjs.data.ChartJsTooltipConfig;
import nl.crashdata.chartjs.data.ChartJsTooltipPositioning;

public class SimpleChartJsTooltipConfig implements ChartJsTooltipConfig
{
	private static final long serialVersionUID = 1L;

	private Boolean enabled;

	private ChartJsInteractionMode mode;

	private Boolean intersect;

	private ChartJsTooltipPositioning position;

	private ChartJsRGBAColor backgroundColor;

	private String titleFontFamily;

	private Integer titleFontSize;

	private String titleFontStyle;

	private ChartJsRGBAColor titleFontColor;

	private Integer titleSpacing;

	private Integer titleMarginBottom;

	private String bodyFontFamily;

	private Integer bodyFontSize;

	private String bodyFontStyle;

	private ChartJsRGBAColor bodyFontColor;

	private Integer bodySpacing;

	private String footerFontFamily;

	private Integer footerFontSize;

	private String footerFontStyle;

	private ChartJsRGBAColor footerFontColor;

	private Integer footerSpacing;

	private Integer footerMarginTop;

	private Integer xPadding;

	private Integer yPadding;

	private Integer caretPadding;

	private Integer caretSize;

	private Integer cornerRadius;

	private ChartJsRGBAColor multiKeyBackground;

	private Boolean displayColors;

	private ChartJsRGBAColor borderColor;

	private Integer borderWidth;

	@Override
	public Boolean getEnabled()
	{
		return enabled;
	}

	public void setEnabled(Boolean enabled)
	{
		this.enabled = enabled;
	}

	@Override
	public ChartJsInteractionMode getMode()
	{
		return mode;
	}

	public void setMode(ChartJsInteractionMode mode)
	{
		this.mode = mode;
	}

	@Override
	public Boolean getIntersect()
	{
		return intersect;
	}

	public void setIntersect(Boolean intersect)
	{
		this.intersect = intersect;
	}

	@Override
	public ChartJsTooltipPositioning getPosition()
	{
		return position;
	}

	public void setPosition(ChartJsTooltipPositioning position)
	{
		this.position = position;
	}

	@Override
	public ChartJsRGBAColor getBackgroundColor()
	{
		return backgroundColor;
	}

	public void setBackgroundColor(ChartJsRGBAColor backgroundColor)
	{
		this.backgroundColor = backgroundColor;
	}

	@Override
	public String getTitleFontFamily()
	{
		return titleFontFamily;
	}

	public void setTitleFontFamily(String titleFontFamily)
	{
		this.titleFontFamily = titleFontFamily;
	}

	@Override
	public Integer getTitleFontSize()
	{
		return titleFontSize;
	}

	public void setTitleFontSize(Integer titleFontSize)
	{
		this.titleFontSize = titleFontSize;
	}

	@Override
	public String getTitleFontStyle()
	{
		return titleFontStyle;
	}

	public void setTitleFontStyle(String titleFontStyle)
	{
		this.titleFontStyle = titleFontStyle;
	}

	@Override
	public ChartJsRGBAColor getTitleFontColor()
	{
		return titleFontColor;
	}

	public void setTitleFontColor(ChartJsRGBAColor titleFontColor)
	{
		this.titleFontColor = titleFontColor;
	}

	@Override
	public Integer getTitleSpacing()
	{
		return titleSpacing;
	}

	public void setTitleSpacing(Integer titleSpacing)
	{
		this.titleSpacing = titleSpacing;
	}

	@Override
	public Integer getTitleMarginBottom()
	{
		return titleMarginBottom;
	}

	public void setTitleMarginBottom(Integer titleMarginBottom)
	{
		this.titleMarginBottom = titleMarginBottom;
	}

	@Override
	public String getBodyFontFamily()
	{
		return bodyFontFamily;
	}

	public void setBodyFontFamily(String bodyFontFamily)
	{
		this.bodyFontFamily = bodyFontFamily;
	}

	@Override
	public Integer getBodyFontSize()
	{
		return bodyFontSize;
	}

	public void setBodyFontSize(Integer bodyFontSize)
	{
		this.bodyFontSize = bodyFontSize;
	}

	@Override
	public String getBodyFontStyle()
	{
		return bodyFontStyle;
	}

	public void setBodyFontStyle(String bodyFontStyle)
	{
		this.bodyFontStyle = bodyFontStyle;
	}

	@Override
	public ChartJsRGBAColor getBodyFontColor()
	{
		return bodyFontColor;
	}

	public void setBodyFontColor(ChartJsRGBAColor bodyFontColor)
	{
		this.bodyFontColor = bodyFontColor;
	}

	@Override
	public Integer getBodySpacing()
	{
		return bodySpacing;
	}

	public void setBodySpacing(Integer bodySpacing)
	{
		this.bodySpacing = bodySpacing;
	}

	@Override
	public String getFooterFontFamily()
	{
		return footerFontFamily;
	}

	public void setFooterFontFamily(String footerFontFamily)
	{
		this.footerFontFamily = footerFontFamily;
	}

	@Override
	public Integer getFooterFontSize()
	{
		return footerFontSize;
	}

	public void setFooterFontSize(Integer footerFontSize)
	{
		this.footerFontSize = footerFontSize;
	}

	@Override
	public String getFooterFontStyle()
	{
		return footerFontStyle;
	}

	public void setFooterFontStyle(String footerFontStyle)
	{
		this.footerFontStyle = footerFontStyle;
	}

	@Override
	public ChartJsRGBAColor getFooterFontColor()
	{
		return footerFontColor;
	}

	public void setFooterFontColor(ChartJsRGBAColor footerFontColor)
	{
		this.footerFontColor = footerFontColor;
	}

	@Override
	public Integer getFooterSpacing()
	{
		return footerSpacing;
	}

	public void setFooterSpacing(Integer footerSpacing)
	{
		this.footerSpacing = footerSpacing;
	}

	@Override
	public Integer getFooterMarginTop()
	{
		return footerMarginTop;
	}

	public void setFooterMarginTop(Integer footerMarginTop)
	{
		this.footerMarginTop = footerMarginTop;
	}

	@Override
	public Integer getXPadding()
	{
		return xPadding;
	}

	public void setXPadding(Integer xPadding)
	{
		this.xPadding = xPadding;
	}

	@Override
	public Integer getYPadding()
	{
		return yPadding;
	}

	public void setYPadding(Integer yPadding)
	{
		this.yPadding = yPadding;
	}

	@Override
	public Integer getCaretPadding()
	{
		return caretPadding;
	}

	public void setCaretPadding(Integer caretPadding)
	{
		this.caretPadding = caretPadding;
	}

	@Override
	public Integer getCaretSize()
	{
		return caretSize;
	}

	public void setCaretSize(Integer caretSize)
	{
		this.caretSize = caretSize;
	}

	@Override
	public Integer getCornerRadius()
	{
		return cornerRadius;
	}

	public void setCornerRadius(Integer cornerRadius)
	{
		this.cornerRadius = cornerRadius;
	}

	@Override
	public ChartJsRGBAColor getMultiKeyBackground()
	{
		return multiKeyBackground;
	}

	public void setMultiKeyBackground(ChartJsRGBAColor multiKeyBackground)
	{
		this.multiKeyBackground = multiKeyBackground;
	}

	@Override
	public Boolean getDisplayColors()
	{
		return displayColors;
	}

	public void setDisplayColors(Boolean displayColors)
	{
		this.displayColors = displayColors;
	}

	@Override
	public ChartJsRGBAColor getBorderColor()
	{
		return borderColor;
	}

	public void setBorderColor(ChartJsRGBAColor borderColor)
	{
		this.borderColor = borderColor;
	}

	@Override
	public Integer getBorderWidth()
	{
		return borderWidth;
	}

	public void setBorderWidth(Integer borderWidth)
	{
		this.borderWidth = borderWidth;
	}
}
