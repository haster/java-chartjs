package nl.crashdata.chartjs.data.simple;

import java.util.List;

import nl.crashdata.chartjs.data.ChartJsPosition;
import nl.crashdata.chartjs.data.ChartJsTitleConfig;
import nl.crashdata.chartjs.data.colors.ChartJsRGBAColor;

public class SimpleChartJsTitleConfig implements ChartJsTitleConfig
{
	private static final long serialVersionUID = 1L;

	private Boolean display;

	private ChartJsPosition position;

	private Integer fontSize;

	private String fontFamily;

	private ChartJsRGBAColor fontColor;

	private String fontStyle;

	private Integer padding;

	private String lineHeight;

	private List<String> text;

	@Override
	public Boolean getDisplay()
	{
		return display;
	}

	public void setDisplay(Boolean display)
	{
		this.display = display;
	}

	@Override
	public ChartJsPosition getPosition()
	{
		return position;
	}

	public void setPosition(ChartJsPosition position)
	{
		this.position = position;
	}

	@Override
	public Integer getFontSize()
	{
		return fontSize;
	}

	public void setFontSize(Integer fontSize)
	{
		this.fontSize = fontSize;
	}

	@Override
	public String getFontFamily()
	{
		return fontFamily;
	}

	public void setFontFamily(String fontFamily)
	{
		this.fontFamily = fontFamily;
	}

	@Override
	public ChartJsRGBAColor getFontColor()
	{
		return fontColor;
	}

	public void setFontColor(ChartJsRGBAColor fontColor)
	{
		this.fontColor = fontColor;
	}

	@Override
	public String getFontStyle()
	{
		return fontStyle;
	}

	public void setFontStyle(String fontStyle)
	{
		this.fontStyle = fontStyle;
	}

	@Override
	public Integer getPadding()
	{
		return padding;
	}

	public void setPadding(Integer padding)
	{
		this.padding = padding;
	}

	@Override
	public String getLineHeight()
	{
		return lineHeight;
	}

	public void setLineHeight(String lineHeight)
	{
		this.lineHeight = lineHeight;
	}

	@Override
	public List<String> getText()
	{
		return text;
	}

	public void setText(List<String> text)
	{
		this.text = text;
	}
}
