package nl.crashdata.chartjs.data.simple;

import java.io.Serializable;

import nl.crashdata.chartjs.data.ChartJsDataPoint;

public class SimpleChartJsDataPoint<X extends Serializable, Y extends Serializable>
		implements ChartJsDataPoint<X, Y>
{
	private static final long serialVersionUID = 1L;

	private X x;

	private Y y;

	public SimpleChartJsDataPoint()
	{
	}

	public SimpleChartJsDataPoint(X x, Y y)
	{
		setX(x);
		setY(y);
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
