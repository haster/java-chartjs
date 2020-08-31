package nl.crashdata.chartjs.data.simple.builder;

import java.util.HashSet;
import java.util.Set;

import nl.crashdata.chartjs.data.simple.SimpleChartJsLocalEventHandler;

public class BuildContext
{
	private Set<SimpleChartJsLocalEventHandler> registeredEventHandlers = new HashSet<>();

	public void registerEventHandler(SimpleChartJsLocalEventHandler eventHandler)
	{
		registeredEventHandlers.add(eventHandler);
	}

	public Set<SimpleChartJsLocalEventHandler> getLocalEventHandlers()
	{
		return registeredEventHandlers;
	}
}
