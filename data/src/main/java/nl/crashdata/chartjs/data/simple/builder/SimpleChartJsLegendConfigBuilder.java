package nl.crashdata.chartjs.data.simple.builder;

import java.util.List;

import nl.crashdata.chartjs.data.ChartJsLegendConfig;
import nl.crashdata.chartjs.data.ChartJsPosition;
import nl.crashdata.chartjs.data.simple.SimpleChartJsLegendConfig;

public class SimpleChartJsLegendConfigBuilder implements SimpleChartJsBuilder<ChartJsLegendConfig>
{
	private boolean display = true;

	private ChartJsPosition position;

	private Boolean fullWidth;

	private Boolean reverse;

	private List<String> labels;

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
		return ret;
	}
}
