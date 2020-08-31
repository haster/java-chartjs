package nl.crashdata.chartjs.data.simple.builder;

import java.util.ArrayList;
import java.util.List;

import nl.crashdata.chartjs.data.ChartJsPosition;
import nl.crashdata.chartjs.data.ChartJsTitleConfig;
import nl.crashdata.chartjs.data.colors.ChartJsRGBAColor;
import nl.crashdata.chartjs.data.simple.SimpleChartJsTitleConfig;

public class SimpleChartJsTitleConfigBuilder
		implements ChartJsBuildContextBuilder<ChartJsTitleConfig>
{
	private boolean display = true;

	private ChartJsPosition position;

	private Integer fontSize;

	private String fontFamily;

	private ChartJsRGBAColor fontColor;

	private String fontStyle;

	private Integer padding;

	private String lineHeight;

	private List<String> text = new ArrayList<>();

	public SimpleChartJsTitleConfigBuilder withDisplay(boolean display)
	{
		this.display = display;
		return this;
	}

	public SimpleChartJsTitleConfigBuilder withPosition(ChartJsPosition position)
	{
		this.position = position;
		return this;
	}

	public SimpleChartJsTitleConfigBuilder withFontSize(Integer fontSize)
	{
		this.fontSize = fontSize;
		return this;
	}

	public SimpleChartJsTitleConfigBuilder withFontFamily(String fontFamily)
	{
		this.fontFamily = fontFamily;
		return this;
	}

	public SimpleChartJsTitleConfigBuilder withFontColor(ChartJsRGBAColor fontColor)
	{
		this.fontColor = fontColor;
		return this;
	}

	public SimpleChartJsTitleConfigBuilder withFontStyle(String fontStyle)
	{
		this.fontStyle = fontStyle;
		return this;
	}

	public SimpleChartJsTitleConfigBuilder withPadding(Integer padding)
	{
		this.padding = padding;
		return this;
	}

	public SimpleChartJsTitleConfigBuilder withLineHeight(String lineHeight)
	{
		this.lineHeight = lineHeight;
		return this;
	}

	public SimpleChartJsTitleConfigBuilder withText(List<String> text)
	{
		this.text = text;
		return this;
	}

	public SimpleChartJsTitleConfigBuilder addText(String line)
	{
		this.text.add(line);
		return this;
	}

	@Override
	public boolean isValid()
	{
		return !display || !text.isEmpty();
	}

	@Override
	public ChartJsTitleConfig build(BuildContext context) throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsTitleConfig ret = new SimpleChartJsTitleConfig();
		ret.setDisplay(display);
		ret.setPosition(position);
		ret.setFontSize(fontSize);
		ret.setFontFamily(fontFamily);
		ret.setFontColor(fontColor);
		ret.setFontStyle(fontStyle);
		ret.setPadding(padding);
		ret.setLineHeight(lineHeight);
		ret.setText(text);
		return ret;
	}
}
