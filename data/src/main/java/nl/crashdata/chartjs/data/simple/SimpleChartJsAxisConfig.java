package nl.crashdata.chartjs.data.simple;

import java.io.Serializable;

import nl.crashdata.chartjs.data.ChartJsAxisConfig;
import nl.crashdata.chartjs.data.ChartJsPosition;
import nl.crashdata.chartjs.data.ChartJsCartesianAxisType;
import nl.crashdata.chartjs.data.ChartJsScaleLabelConfig;
import nl.crashdata.chartjs.data.ChartJsTickConfig;
import nl.crashdata.chartjs.data.ChartJsTimeConfig;

public class SimpleChartJsAxisConfig<T extends Serializable> implements ChartJsAxisConfig<T>
{
	private static final long serialVersionUID = 1L;

	private Boolean display;

	private ChartJsScaleLabelConfig labelConfig;

	private ChartJsTickConfig<T> tickConfig;

	private ChartJsPosition position;

	private ChartJsCartesianAxisType type;

	private ChartJsTimeConfig timeConfig;

	private Boolean stacked;

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
	public ChartJsPosition getPosition()
	{
		return position;
	}

	public void setPosition(ChartJsPosition position)
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

	@Override
	public ChartJsTimeConfig getTimeConfig()
	{
		return timeConfig;
	}

    public void setTimeConfig(ChartJsTimeConfig timeConfig)
	{
		this.timeConfig = timeConfig;
	}

	@Override
	public Boolean isStacked() {
		return stacked;
	}

	public void setStacked(Boolean stacked) {
		this.stacked = stacked;
	}
}
