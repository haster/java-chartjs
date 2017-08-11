package nl.crashdata.chartjs.data.simple;

import nl.crashdata.chartjs.data.ChartJsAxisConfig;
import nl.crashdata.chartjs.data.ChartJsAxisPosition;
import nl.crashdata.chartjs.data.ChartJsCartesianAxisType;
import nl.crashdata.chartjs.data.ChartJsScaleLabelConfig;
import nl.crashdata.chartjs.data.ChartJsTickConfig;

public class SimpleChartJsAxisConfig implements ChartJsAxisConfig
{
	private static final long serialVersionUID = 1L;

	private Boolean display;

	private ChartJsScaleLabelConfig labelConfig;

	private ChartJsTickConfig tickConfig;

	private ChartJsAxisPosition position;

	private ChartJsCartesianAxisType type;

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
	public ChartJsScaleLabelConfig getLabelConfig()
	{
		return labelConfig;
	}

	public void setLabelConfig(ChartJsScaleLabelConfig labelConfig)
	{
		this.labelConfig = labelConfig;
	}

	@Override
	public ChartJsTickConfig getTickConfig()
	{
		return tickConfig;
	}

	public void setTickConfig(ChartJsTickConfig tickConfig)
	{
		this.tickConfig = tickConfig;
	}

	@Override
	public ChartJsAxisPosition getPosition()
	{
		return position;
	}

	public void setPosition(ChartJsAxisPosition position)
	{
		this.position = position;
	}

	@Override
	public ChartJsCartesianAxisType getType()
	{
		return type;
	}

	public void setType(ChartJsCartesianAxisType type)
	{
		this.type = type;
	}
}
