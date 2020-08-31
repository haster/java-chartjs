package nl.crashdata.chartjs.data.simple.builder;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import nl.crashdata.chartjs.data.ChartJsEventHandler;
import nl.crashdata.chartjs.data.simple.SimpleChartJsExternalEventHandler;
import nl.crashdata.chartjs.data.simple.SimpleChartJsLocalEventHandler;

public class SimpleChartJsEventHandlerBuilder implements SimpleChartJsBuilder<ChartJsEventHandler>
{
	private HandlerType type = HandlerType.LOCAL;

	private Supplier<String> functionReferenceSupplier = UniqueFunctionNameGenerator::next;

	private Supplier<String> bodySupplier;

	private Supplier<String> defaultHandlerReferenceSupplier;

	public SimpleChartJsEventHandlerBuilder
			withFunctionReference(Supplier<String> functionReferenceSupplier)
	{
		this.functionReferenceSupplier = functionReferenceSupplier;
		return this;
	}

	public SimpleChartJsEventHandlerBuilder withFunctionReference(String functionReference)
	{
		return withFunctionReference(() -> functionReference);
	}

	public SimpleChartJsEventHandlerBuilder withBody(Supplier<String> bodySupplier)
	{
		this.bodySupplier = bodySupplier;
		return this;
	}

	public SimpleChartJsEventHandlerBuilder withBody(String body)
	{
		return withBody(() -> body);
	}

	public SimpleChartJsEventHandlerBuilder
			withDefaultHandlerReference(Supplier<String> defaultHandlerReferenceSupplier)
	{
		this.defaultHandlerReferenceSupplier = defaultHandlerReferenceSupplier;
		return this;
	}

	public SimpleChartJsEventHandlerBuilder
			withDefaultHandlerReference(String defaultHandlerReference)
	{
		return withDefaultHandlerReference(() -> defaultHandlerReference);
	}

	public SimpleChartJsEventHandlerBuilder local()
	{
		this.type = HandlerType.LOCAL;
		return this;
	}

	public SimpleChartJsEventHandlerBuilder external()
	{
		this.type = HandlerType.EXTERNAL;
		return this;
	}

	@Override
	public boolean isValid()
	{
		if (functionReferenceSupplier == null)
			return false;
		if (type == HandlerType.LOCAL)
		{
			if (bodySupplier == null)
				return false;
		}
		return true;
	}

	@Deprecated
	@Override
	public ChartJsEventHandler build() throws IllegalStateException
	{
		return build(new BuildContext());
	}

	@Override
	public ChartJsEventHandler build(BuildContext context) throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}

		if (type == HandlerType.EXTERNAL)
		{
			SimpleChartJsExternalEventHandler eventHandler =
				new SimpleChartJsExternalEventHandler();
			eventHandler.setFunctionReference(functionReferenceSupplier.get());
			return eventHandler;
		}
		else
		{
			SimpleChartJsLocalEventHandler eventHandler = new SimpleChartJsLocalEventHandler();
			eventHandler.setFunctionReference(functionReferenceSupplier.get());

			StringBuilder bodyBuilder = new StringBuilder();

			if (defaultHandlerReferenceSupplier != null)
			{
				bodyBuilder.append(defaultHandlerReferenceSupplier.get());
				bodyBuilder.append(".call(")
					.append("this, ")
					.append(eventHandler.getEventParameterName())
					.append(", ")
					.append(eventHandler.getItemParameterName())
					.append("); ");
			}
			bodyBuilder.append(bodySupplier.get());

			eventHandler.setBody(bodyBuilder.toString());

			context.registerEventHandler(eventHandler);
			return eventHandler;
		}
	}

	private enum HandlerType
	{
		LOCAL,
		EXTERNAL;
	}

	private static class UniqueFunctionNameGenerator
	{
		private static final UniqueFunctionNameGenerator INSTANCE =
			new UniqueFunctionNameGenerator();

		private static final AtomicInteger atomicInt = new AtomicInteger();

		public String nextName()
		{
			return String.format("generatedFunction_%03d", atomicInt.incrementAndGet());
		}

		public static final UniqueFunctionNameGenerator instance()
		{
			return INSTANCE;
		}

		public static String next()
		{
			return instance().nextName();
		}
	}
}
