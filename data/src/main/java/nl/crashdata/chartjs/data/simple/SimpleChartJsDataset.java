package nl.crashdata.chartjs.data.simple;

import java.io.Serializable;
import java.util.List;

import nl.crashdata.chartjs.data.ChartJsDataset;
import nl.crashdata.chartjs.data.ChartJsFill;
import nl.crashdata.chartjs.data.colors.ChartJsRGBAColor;

public class SimpleChartJsDataset<V extends Serializable> implements ChartJsDataset<V>
{
	private static final long serialVersionUID = 1L;

	private String label;

	private List<ChartJsRGBAColor> backgroundColor;

	private List<ChartJsRGBAColor> borderColor;

	private List<Integer> borderWidth;

	private List<ChartJsRGBAColor> hoverBackgroundColor;

	private List<ChartJsRGBAColor> hoverBorderColor;

	private List<Integer> hoverBorderWidth;

	private ChartJsFill fill;

	private String stack;

	private List<V> data;

	@Override
	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	@Override
	public List<ChartJsRGBAColor> getBackgroundColor()
	{
		return backgroundColor;
	}

	public void setBackgroundColor(List<ChartJsRGBAColor> backgroundColor)
	{
		this.backgroundColor = backgroundColor;
	}

	@Override
	public List<ChartJsRGBAColor> getBorderColor()
	{
		return borderColor;
	}

	public void setBorderColor(List<ChartJsRGBAColor> borderColor)
	{
		this.borderColor = borderColor;
	}

	@Override
	public List<Integer> getBorderWidth()
	{
		return borderWidth;
	}

	public void setBorderWidth(List<Integer> borderWidth)
	{
		this.borderWidth = borderWidth;
	}

	@Override
	public List<ChartJsRGBAColor> getHoverBackgroundColor()
	{
		return hoverBackgroundColor;
	}

	public void setHoverBackgroundColor(List<ChartJsRGBAColor> hoverBackgroundColor)
	{
		this.hoverBackgroundColor = hoverBackgroundColor;
	}

	@Override
	public List<ChartJsRGBAColor> getHoverBorderColor()
	{
		return hoverBorderColor;
	}

	public void setHoverBorderColor(List<ChartJsRGBAColor> hoverBorderColor)
	{
		this.hoverBorderColor = hoverBorderColor;
	}

	@Override
	public List<Integer> getHoverBorderWidth()
	{
		return hoverBorderWidth;
	}

	public void setHoverBorderWidth(List<Integer> hoverBorderWidth)
	{
		this.hoverBorderWidth = hoverBorderWidth;
	}

	@Override
	public ChartJsFill getFill()
	{
		return fill;
	}

    public void setFill(ChartJsFill fill)
	{
		this.fill = fill;
	}

	@Override
	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	@Override
	public List<V> getData()
	{
		return data;
	}

	public void setData(List<V> data)
	{
		this.data = data;
	}
}
