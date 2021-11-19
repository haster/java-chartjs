package nl.crashdata.chartjs.data.simple;

import nl.crashdata.chartjs.data.ChartJsBarElementsConfig;
import nl.crashdata.chartjs.data.ChartJsElementsConfig;

public class SimpleChartJsElementsConfig implements ChartJsElementsConfig
{
	private static final long serialVersionUID = 1L;

	private ChartJsBarElementsConfig barElementsConfig;

	@Override
	public ChartJsBarElementsConfig getBarElementsConfig()
	{
		return barElementsConfig;
	}

	public void setBarElementsConfig(ChartJsBarElementsConfig barElementsConfig)
	{
		this.barElementsConfig = barElementsConfig;
	}
}
