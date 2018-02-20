package nl.crashdata.chartjs.data.simple;

import java.io.Serializable;

import nl.crashdata.chartjs.data.ChartJsAxisConfig;
import nl.crashdata.chartjs.data.ChartJsAxisPosition;
import nl.crashdata.chartjs.data.ChartJsCartesianAxisType;
import nl.crashdata.chartjs.data.ChartJsScaleLabelConfig;
import nl.crashdata.chartjs.data.ChartJsTickConfig;

public class SimpleChartJsAxisConfig<T extends Serializable> implements ChartJsAxisConfig<T>
{
	private static final long serialVersionUID = 1L;

	private Boolean display;

	private ChartJsScaleLabelConfig labelConfig;

	private ChartJsTickConfig<T> tickConfig;

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
	public ChartJsTickConfig<T> getTickConfig()
	{
		return tickConfig;
	}

	public void setTickConfig(ChartJsTickConfig<T> tickConfig)
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
