package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.ChartJsInteractionMode;
import nl.crashdata.chartjs.data.ChartJsTooltipPositioning;
import nl.crashdata.chartjs.data.colors.ChartJsRGBAColor;
import nl.crashdata.chartjs.data.simple.SimpleChartJsTooltipConfig;

public class SimpleChartJsTooltipConfigBuilder
		implements ChartJsBuildContextBuilder<SimpleChartJsTooltipConfig>
{
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

	public SimpleChartJsTooltipConfigBuilder withEnabled(Boolean enabled)
	{
		this.enabled = enabled;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withMode(ChartJsInteractionMode mode)
	{
		this.mode = mode;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withIntersect(Boolean intersect)
	{
		this.intersect = intersect;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withPosition(ChartJsTooltipPositioning position)
	{
		this.position = position;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withBackgroundColor(ChartJsRGBAColor backgroundColor)
	{
		this.backgroundColor = backgroundColor;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withTitleFontFamily(String titleFontFamily)
	{
		this.titleFontFamily = titleFontFamily;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withTitleFontSize(Integer titleFontSize)
	{
		this.titleFontSize = titleFontSize;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withTitleFontStyle(String titleFontStyle)
	{
		this.titleFontStyle = titleFontStyle;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withTitleFontColor(ChartJsRGBAColor titleFontColor)
	{
		this.titleFontColor = titleFontColor;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withTitleSpacing(Integer titleSpacing)
	{
		this.titleSpacing = titleSpacing;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withTitleMarginBottom(Integer titleMarginBottom)
	{
		this.titleMarginBottom = titleMarginBottom;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withBodyFontFamily(String bodyFontFamily)
	{
		this.bodyFontFamily = bodyFontFamily;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withBodyFontSize(Integer bodyFontSize)
	{
		this.bodyFontSize = bodyFontSize;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withBodyFontStyle(String bodyFontStyle)
	{
		this.bodyFontStyle = bodyFontStyle;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withBodyFontColor(ChartJsRGBAColor bodyFontColor)
	{
		this.bodyFontColor = bodyFontColor;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withBodySpacing(Integer bodySpacing)
	{
		this.bodySpacing = bodySpacing;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withFooterFontFamily(String footerFontFamily)
	{
		this.footerFontFamily = footerFontFamily;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withFooterFontSize(Integer footerFontSize)
	{
		this.footerFontSize = footerFontSize;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withFooterFontStyle(String footerFontStyle)
	{
		this.footerFontStyle = footerFontStyle;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withFooterFontColor(ChartJsRGBAColor footerFontColor)
	{
		this.footerFontColor = footerFontColor;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withFooterSpacing(Integer footerSpacing)
	{
		this.footerSpacing = footerSpacing;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withFooterMarginTop(Integer footerMarginTop)
	{
		this.footerMarginTop = footerMarginTop;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withXPadding(Integer xPadding)
	{
		this.xPadding = xPadding;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withYPadding(Integer yPadding)
	{
		this.yPadding = yPadding;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withCaretPadding(Integer caretPadding)
	{
		this.caretPadding = caretPadding;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withCaretSize(Integer caretSize)
	{
		this.caretSize = caretSize;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withCornerRadius(Integer cornerRadius)
	{
		this.cornerRadius = cornerRadius;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder
			withMultiKeyBackground(ChartJsRGBAColor multiKeyBackground)
	{
		this.multiKeyBackground = multiKeyBackground;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withDisplayColors(Boolean displayColors)
	{
		this.displayColors = displayColors;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withBorderColor(ChartJsRGBAColor borderColor)
	{
		this.borderColor = borderColor;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder withBorderWidth(Integer borderWidth)
	{
		this.borderWidth = borderWidth;
		return this;
	}

	@Override
	public boolean isValid()
	{
		return true;
	}

	@Override
	public SimpleChartJsTooltipConfig build(BuildContext context) throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsTooltipConfig ret = new SimpleChartJsTooltipConfig();
		ret.setEnabled(enabled);
		ret.setIntersect(intersect);
		ret.setMode(mode);
		ret.setPosition(position);
		ret.setBackgroundColor(backgroundColor);
		ret.setTitleFontFamily(titleFontFamily);
		ret.setTitleFontSize(titleFontSize);
		ret.setTitleFontStyle(titleFontStyle);
		ret.setTitleFontColor(titleFontColor);
		ret.setTitleSpacing(titleSpacing);
		ret.setTitleMarginBottom(titleMarginBottom);
		ret.setBodyFontFamily(bodyFontFamily);
		ret.setBodyFontSize(bodyFontSize);
		ret.setBodyFontStyle(bodyFontStyle);
		ret.setBodyFontColor(bodyFontColor);
		ret.setBodySpacing(bodySpacing);
		ret.setFooterFontFamily(footerFontFamily);
		ret.setFooterFontSize(footerFontSize);
		ret.setFooterFontStyle(footerFontStyle);
		ret.setFooterFontColor(footerFontColor);
		ret.setFooterSpacing(footerSpacing);
		ret.setFooterMarginTop(footerMarginTop);
		ret.setXPadding(xPadding);
		ret.setYPadding(yPadding);
		ret.setCaretPadding(caretPadding);
		ret.setCaretSize(caretSize);
		ret.setCornerRadius(cornerRadius);
		ret.setMultiKeyBackground(multiKeyBackground);
		ret.setDisplayColors(displayColors);
		ret.setBorderColor(borderColor);
		ret.setBorderWidth(borderWidth);
		return ret;
	}
}
