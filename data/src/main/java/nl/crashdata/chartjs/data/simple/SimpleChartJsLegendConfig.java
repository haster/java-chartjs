package nl.crashdata.chartjs.data.simple;

import java.util.List;

import nl.crashdata.chartjs.data.ChartJsEventHandler;
import nl.crashdata.chartjs.data.ChartJsLegendConfig;
import nl.crashdata.chartjs.data.ChartJsPosition;

public class SimpleChartJsLegendConfig implements ChartJsLegendConfig
{
	private static final long serialVersionUID = 1L;

	private Boolean display;

	private ChartJsPosition position;

	private Boolean fullWidth;

	private Boolean reverse;

	private List<String> labels;

	private ChartJsEventHandler onClickHandler;

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
	public Boolean getFullWidth()
	{
		return fullWidth;
	}

	public void setFullWidth(Boolean fullWidth)
	{
		this.fullWidth = fullWidth;
	}

	@Override
	public Boolean getReverse()
	{
		return reverse;
	}

	public void setReverse(Boolean reverse)
	{
		this.reverse = reverse;
	}

	@Override
	public List<String> getLabels()
	{
		return labels;
	}

	public void setLabels(List<String> labels)
	{
		this.labels = labels;
	}

	@Override
	public ChartJsEventHandler getOnClickHandler()
	{
		return onClickHandler;
	}

	public void setOnClick(ChartJsEventHandler onClick)
	{
		this.onClickHandler = onClick;
	}
}
