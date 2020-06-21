package nl.crashdata.chartjs.data.simple.builder;

import java.util.List;
import java.util.function.Supplier;

import nl.crashdata.chartjs.data.colors.ChartJsEventHandler;

public class SimpleChartJsEventHandlerBuilder implements SimpleChartJsBuilder<ChartJsEventHandler>
{
	private List<String> params;

	private String body;

	private Supplier<String> defaultHandlerBodySupplier = () -> "";

	private boolean defaultExecute = true;

	public SimpleChartJsEventHandlerBuilder withParameters(String... params)
	{
		this.params = List.of(params);
		return this;
	}

	public SimpleChartJsEventHandlerBuilder withBody(String body)
	{
		this.body = body;
		return this;
	}

	public SimpleChartJsEventHandlerBuilder
			withDefaultHandlerBodySupplier(Supplier<String> defaultHandlerBodySupplier)
	{
		this.defaultHandlerBodySupplier = defaultHandlerBodySupplier;
		return this;
	}

	public SimpleChartJsEventHandlerBuilder withDefaultExecute(boolean defaultExecute)
	{
		this.defaultExecute = defaultExecute;
		return this;
	}

	@Override
	public boolean isValid()
	{
		if (body == null)
			return false;
		return true;
	}

	@Override
	public ChartJsEventHandler build() throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}

		StringBuilder bodyBuilder = new StringBuilder();

		if (defaultExecute)
		{
			bodyBuilder.append(defaultHandlerBodySupplier.get());
		}
		bodyBuilder.append(body);
		return new ChartJsEventHandler(params, bodyBuilder.toString());
	}
}
