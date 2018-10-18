package nl.crashdata.chartjs.data.simple;

import java.io.Serializable;
import java.util.Map;

import nl.crashdata.chartjs.data.ChartJsXYDataPoint;

public class SimpleChartJsXYDataPoint<X extends Serializable, Y extends Serializable>
		implements ChartJsXYDataPoint<X, Y>
{
	private static final long serialVersionUID = 1L;

	private X x;

	private Y y;

	public SimpleChartJsXYDataPoint()
	{
	}

	public SimpleChartJsXYDataPoint(X x, Y y)
	{
		setX(x);
		setY(y);
	}

	public SimpleChartJsXYDataPoint(Map.Entry<X, Y> entry)
	{
		this(entry.getKey(), entry.getValue());
	}

	@Override
	public X getX()
	{
		return x;
	}

	public void setX(X x)
	{
		this.x = x;
	}

	@Override
	public Y getY()
	{
		return y;
	}

	public void setY(Y y)
	{
		this.y = y;
	}
}
