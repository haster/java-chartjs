package nl.crashdata.chartjs.data.colors;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An immutable value object to represent an event handler for chartjs.
 */
public final class ChartJsEventHandler implements Serializable
{
	private static final long serialVersionUID = 1L;

	private final List<String> params;

	private final String body;

	public ChartJsEventHandler(List<String> params, String body)
	{
		this.params = params;
		this.body = body;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("function(" + params.stream().collect(Collectors.joining(",")) + "){");
		sb.append(body);
		sb.append("}");
		return sb.toString();
	}
}
