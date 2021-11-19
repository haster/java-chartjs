package nl.crashdata.chartjs.data.simple;

import nl.crashdata.chartjs.data.ChartJsBarElementsConfig;
import nl.crashdata.chartjs.data.ChartJsBorderSkipped;
import nl.crashdata.chartjs.data.colors.ChartJsRGBAColor;

public class SimpleChartJsBarElementsConfig implements ChartJsBarElementsConfig
{
	private static final long serialVersionUID = 1L;

	private ChartJsRGBAColor backgroundColor;

	private ChartJsRGBAColor borderColor;

	private Integer borderWidth;

	private ChartJsBorderSkipped borderSkipped;

	private Integer borderRadius;

	private Integer inflateAmount;

	private String pointStyle;

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

	@Override
	public ChartJsBorderSkipped getBorderSkipped()
	{
		return borderSkipped;
	}

	public void setBorderSkipped(ChartJsBorderSkipped borderSkipped)
	{
		this.borderSkipped = borderSkipped;
	}

	@Override
	public Integer getBorderRadius()
	{
		return borderRadius;
	}

	public void setBorderRadius(Integer borderRadius)
	{
		this.borderRadius = borderRadius;
	}

	@Override
	public Integer getInflateAmount()
	{
		return inflateAmount;
	}

	public void setInflateAmount(Integer inflateAmount)
	{
		this.inflateAmount = inflateAmount;
	}

	@Override
	public String getPointStyle()
	{
		return pointStyle;
	}

	public void setPointStyle(String pointStyle)
	{
		this.pointStyle = pointStyle;
	}
}
