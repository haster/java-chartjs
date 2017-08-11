package nl.crashdata.chartjs.data.simple;

import java.io.Serializable;
import java.util.List;

import nl.crashdata.chartjs.data.ChartJsDataset;

public class SimpleChartJsDataset<V extends Serializable> implements ChartJsDataset<V>
{
	private static final long serialVersionUID = 1L;

	private String label;

	private String backgroundColor;

	private String borderColor;

	private List<V> data;

	private Boolean fill;

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
	public String getBackgroundColor()
	{
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor)
	{
		this.backgroundColor = backgroundColor;
	}

	@Override
	public String getBorderColor()
	{
		return borderColor;
	}

	public void setBorderColor(String borderColor)
	{
		this.borderColor = borderColor;
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

	@Override
	public Boolean isFill()
	{
		return fill;
	}

	public void setFill(Boolean fill)
	{
		this.fill = fill;
	}
}
