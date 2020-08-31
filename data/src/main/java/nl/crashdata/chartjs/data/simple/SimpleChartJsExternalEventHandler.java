package nl.crashdata.chartjs.data.simple;

import nl.crashdata.chartjs.data.ChartJsEventHandler;

public class SimpleChartJsExternalEventHandler implements ChartJsEventHandler
{
	private static final long serialVersionUID = 1L;

	private String functionReference;

	@Override
	public String getFunctionReference()
	{
		return functionReference;
	}

	public void setFunctionReference(String functionReference)
	{
		this.functionReference = functionReference;
	}
}
