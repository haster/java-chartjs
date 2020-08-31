package nl.crashdata.chartjs.data.simple;

import nl.crashdata.chartjs.data.ChartJsLocalEventHandler;

public class SimpleChartJsLocalEventHandler implements ChartJsLocalEventHandler
{
	private static final long serialVersionUID = 1L;

	private String functionReference;

	private String body;

	@Override
	public String getFunctionReference()
	{
		return functionReference;
	}

	public void setFunctionReference(String functionReference)
	{
		this.functionReference = functionReference;
	}

	@Override
	public String getBody()
	{
		return body;
	}

	public void setBody(String body)
	{
		this.body = body;
	}
}
