package nl.crashdata.chartjs.data.simple;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import nl.crashdata.chartjs.data.ChartJsChartType;
import nl.crashdata.chartjs.data.ChartJsConfig;
import nl.crashdata.chartjs.data.ChartJsData;
import nl.crashdata.chartjs.data.ChartJsLocalEventHandler;
import nl.crashdata.chartjs.data.ChartJsOptions;

public class SimpleChartJsConfig<E extends Serializable> implements ChartJsConfig<E>
{
	private static final long serialVersionUID = 1L;

	private ChartJsData<E> data;

	private ChartJsOptions options;

	private ChartJsChartType chartType;

	private Set<ChartJsLocalEventHandler> localEventHandlers = new HashSet<>();

	@Override
	public ChartJsChartType getChartType()
	{
		return chartType;
	}

	public void setChartType(ChartJsChartType chartType)
	{
		this.chartType = chartType;
	}

	@Override
	public ChartJsData<E> getData()
	{
		return data;
	}

	public void setData(ChartJsData<E> data)
	{
		this.data = data;
	}

	@Override
	public ChartJsOptions getOptions()
	{
		return options;
	}

	public void setOptions(ChartJsOptions options)
	{
		this.options = options;
	}

	@Override
	public Set<ChartJsLocalEventHandler> getLocalEventHandlers()
	{
		return localEventHandlers;
	}

	public void addLocalEventHandler(ChartJsLocalEventHandler eventHandler)
	{
		this.localEventHandlers.add(eventHandler);
	}

	public void addLocalEventHandlers(Collection<SimpleChartJsLocalEventHandler> localEventHandlers)
	{
		this.localEventHandlers.addAll(localEventHandlers);
	}
}
