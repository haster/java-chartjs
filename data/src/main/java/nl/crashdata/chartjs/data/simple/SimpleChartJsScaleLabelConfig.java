package nl.crashdata.chartjs.data.simple;

import nl.crashdata.chartjs.data.ChartJsScaleLabelConfig;

public class SimpleChartJsScaleLabelConfig implements ChartJsScaleLabelConfig
{
	private static final long serialVersionUID = 1L;

	private Boolean display;

	private String labelString;

	@Override
	public Boolean isDisplay()
	{
		return display;
	}

	public void setDisplay(Boolean display)
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
