package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.simple.SimpleChartJsScaleLabelConfig;

public class SimpleChartJsScaleLabelConfigBuilder
		implements ChartJsBuildContextBuilder<SimpleChartJsScaleLabelConfig>
{
	private Boolean display;

	private String labelString;

	public SimpleChartJsScaleLabelConfigBuilder withDisplay(Boolean display)
	{
		this.display = display;
		return this;
	}

	public SimpleChartJsScaleLabelConfigBuilder withLabelString(String labelString)
	{
		this.labelString = labelString;
		return this;
	}

	@Override
	public boolean isValid()
	{
		return true;
	}

	@Override
	public SimpleChartJsScaleLabelConfig build(BuildContext context) throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsScaleLabelConfig ret = new SimpleChartJsScaleLabelConfig();
		ret.setDisplay(display);
		ret.setLabelString(labelString);
		return ret;
	}
}
