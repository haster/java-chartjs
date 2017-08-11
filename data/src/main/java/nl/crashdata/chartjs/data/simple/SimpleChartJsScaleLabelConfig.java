package nl.crashdata.chartjs.data.simple;

import nl.crashdata.chartjs.data.ChartJsScaleLabelConfig;

public class SimpleChartJsScaleLabelConfig implements ChartJsScaleLabelConfig
{
	private static final long serialVersionUID = 1L;

	private boolean display;

	private String labelString;

	@Override
	public boolean isDisplay()
	{
		return display;
	}

	public void setDisplay(boolean display)
	{
		this.display = display;
	}

	@Override
	public String getLabelString()
	{
		return labelString;
	}

	public void setLabelString(String labelString)
	{
		this.labelString = labelString;
	}
}
