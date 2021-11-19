package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.ChartJsBorderSkipped;
import nl.crashdata.chartjs.data.colors.ChartJsRGBAColor;
import nl.crashdata.chartjs.data.simple.SimpleChartJsBarElementsConfig;

public class SimpleChartJsBarElementsConfigBuilder
		implements SimpleChartJsBuilder<SimpleChartJsBarElementsConfig>
{
	private ChartJsRGBAColor backgroundColor;

	private ChartJsRGBAColor borderColor;

	private Integer borderRadius;

	private ChartJsBorderSkipped borderSkipped;

	private Integer borderWidth;

	private Integer inflateAmount;

	private String pointStyle;

	public SimpleChartJsBarElementsConfigBuilder
			withBackgroundColor(ChartJsRGBAColor backgroundColor)
	{
		this.backgroundColor = backgroundColor;
		return this;
	}

	public SimpleChartJsBarElementsConfigBuilder withBorderColor(ChartJsRGBAColor borderColor)
	{
		this.borderColor = borderColor;
		return this;
	}

	public SimpleChartJsBarElementsConfigBuilder withBorderRadius(Integer borderRadius)
	{
		this.borderRadius = borderRadius;
		return this;
	}

	public SimpleChartJsBarElementsConfigBuilder
			withBorderSkipped(ChartJsBorderSkipped borderSkipped)
	{
		this.borderSkipped = borderSkipped;
		return this;
	}

	public SimpleChartJsBarElementsConfigBuilder withBorderWidth(Integer borderWidth)
	{
		this.borderWidth = borderWidth;
		return this;
	}

	public SimpleChartJsBarElementsConfigBuilder withInflateAmount(Integer inflateAmount)
	{
		this.inflateAmount = inflateAmount;
		return this;
	}

	public SimpleChartJsBarElementsConfigBuilder withPointStyle(String pointStyle)
	{
		this.pointStyle = pointStyle;
		return this;
	}

	@Override
	public boolean isValid()
	{
		return true;
	}

	@Override
	public SimpleChartJsBarElementsConfig build() throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsBarElementsConfig ret = new SimpleChartJsBarElementsConfig();
		ret.setBackgroundColor(backgroundColor);
		ret.setBorderColor(borderColor);
		ret.setBorderRadius(borderRadius);
		ret.setBorderSkipped(borderSkipped);
		ret.setBorderWidth(borderWidth);
		ret.setInflateAmount(inflateAmount);
		ret.setPointStyle(pointStyle);
		return ret;
	}
}
