package nl.crashdata.chartjs.data.simple.builder;

import java.util.List;
import java.util.function.Supplier;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.crashdata.chartjs.data.ChartJsChartType;
import nl.crashdata.chartjs.data.ChartJsLegendConfig;
import nl.crashdata.chartjs.data.ChartJsPosition;
import nl.crashdata.chartjs.data.simple.SimpleChartJsLegendConfig;

public class SimpleChartJsLegendConfigBuilder implements SimpleChartJsBuilder<ChartJsLegendConfig>
{
	private Supplier<ChartJsChartType> chartTypeSupplier;

	private boolean display = true;

	private ChartJsPosition position;

	private Boolean fullWidth;

	private Boolean reverse;

	private List<String> labels;

	private SimpleChartJsEventHandlerBuilder onClickBuilder;

	public SimpleChartJsLegendConfigBuilder(Supplier<ChartJsChartType> chartTypeSupplier)
	{
		this.chartTypeSupplier = chartTypeSupplier;
	}

	public SimpleChartJsLegendConfigBuilder withDisplay(boolean display)
	{
		this.display = display;
		return this;
	}

	public SimpleChartJsLegendConfigBuilder withFullWidth(boolean fullWidth)
	{
		this.fullWidth = fullWidth;
		return this;
	}

	public SimpleChartJsLegendConfigBuilder withFontSize(boolean reverse)
	{
		this.reverse = reverse;
		return this;
	}

	public SimpleChartJsLegendConfigBuilder withText(List<String> labels)
	{
		this.labels = labels;
		return this;
	}

	public SimpleChartJsLegendConfigBuilder withPosition(ChartJsPosition position)
	{
		this.position = position;
		return this;
	}

	public SimpleChartJsEventHandlerBuilder onClick()
	{
		if (onClickBuilder == null)
		{
			onClickBuilder = new SimpleChartJsEventHandlerBuilder();
			onClickBuilder.withParameters("event", "item");
			onClickBuilder.withDefaultHandlerBodySupplier(() -> {
				return createDefaultLegendHandlerBody(chartTypeSupplier.get(), "onClick");
			});
		}
		return onClickBuilder;
	}

	@Override
	public boolean isValid()
	{
		return true;
	}

	@Override
	public ChartJsLegendConfig build() throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsLegendConfig ret = new SimpleChartJsLegendConfig();
		ret.setDisplay(display);
		ret.setPosition(position);
		ret.setFullWidth(fullWidth);
		ret.setReverse(reverse);
		ret.setLabels(labels);
		ret.setOnClick(onClickBuilder == null ? null : onClickBuilder.build());
		return ret;
	}

	private String createDefaultLegendHandlerBody(ChartJsChartType type, String eventType)
	{
		try
		{
			JsonProperty jsonProperty =
				type.getClass().getField(type.name()).getAnnotation(JsonProperty.class);
			return "Chart.defaults." + jsonProperty.value() + ".legend." + eventType
				+ ".call(this, event, item);";
		}
		catch (Exception e)
		{
			return null;
		}
	}
}
