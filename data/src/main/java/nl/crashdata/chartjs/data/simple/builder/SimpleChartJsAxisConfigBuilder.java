package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.ChartJsAxisPosition;
import nl.crashdata.chartjs.data.ChartJsCartesianAxisType;
import nl.crashdata.chartjs.data.simple.SimpleChartJsAxisConfig;

public class SimpleChartJsAxisConfigBuilder implements SimpleChartJsBuilder<SimpleChartJsAxisConfig>
{
	private Boolean display;

	private ChartJsAxisPosition position;

	private ChartJsCartesianAxisType type;

	private SimpleChartJsScaleLabelConfigBuilder labelConfigBuilder =
		new SimpleChartJsScaleLabelConfigBuilder();;

	private SimpleChartJsTickConfigBuilder tickConfigBuilder =
		new SimpleChartJsTickConfigBuilder();;

	public SimpleChartJsAxisConfigBuilder withDisplay(Boolean display)
	{
		this.display = display;
		return this;
	}

	public SimpleChartJsAxisConfigBuilder withPosition(ChartJsAxisPosition position)
	{
		this.position = position;
		return this;
	}

	public SimpleChartJsAxisConfigBuilder withAxisType(ChartJsCartesianAxisType type)
	{
		this.type = type;
		return this;
	}

	public SimpleChartJsScaleLabelConfigBuilder labelConfig()
	{
		return labelConfigBuilder;
	}

	public SimpleChartJsTickConfigBuilder tickConfig()
	{
		return tickConfigBuilder;
	}

	@Override
	public boolean isValid()
	{
		return position != null && type != null && labelConfigBuilder.isValid()
			&& tickConfigBuilder.isValid();
	}

	@Override
	public SimpleChartJsAxisConfig build() throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsAxisConfig ret = new SimpleChartJsAxisConfig();
		ret.setDisplay(display);
		ret.setPosition(position);
		ret.setType(type);
		ret.setLabelConfig(labelConfigBuilder.build());
		ret.setTickConfig(tickConfigBuilder.build());
		return ret;
	}
}
