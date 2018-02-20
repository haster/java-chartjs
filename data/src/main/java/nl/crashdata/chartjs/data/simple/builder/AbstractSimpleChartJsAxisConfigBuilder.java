package nl.crashdata.chartjs.data.simple.builder;

import java.io.Serializable;

import nl.crashdata.chartjs.data.ChartJsAxisPosition;
import nl.crashdata.chartjs.data.ChartJsCartesianAxisType;
import nl.crashdata.chartjs.data.simple.AbstractSimpleChartJsTickConfig;
import nl.crashdata.chartjs.data.simple.SimpleChartJsAxisConfig;

public abstract class AbstractSimpleChartJsAxisConfigBuilder<T extends Serializable>
		implements SimpleChartJsBuilder<SimpleChartJsAxisConfig<T>>
{
	private ChartJsCartesianAxisType type;

	private Boolean display;

	private ChartJsAxisPosition position;

	private SimpleChartJsScaleLabelConfigBuilder labelConfigBuilder =
		new SimpleChartJsScaleLabelConfigBuilder();

	protected AbstractSimpleChartJsAxisConfigBuilder(ChartJsCartesianAxisType type)
	{
		this.type = type;
	}

	public AbstractSimpleChartJsAxisConfigBuilder<T> withDisplay(Boolean display)
	{
		this.display = display;
		return this;
	}

	public AbstractSimpleChartJsAxisConfigBuilder<T> withPosition(ChartJsAxisPosition position)
	{
		this.position = position;
		return this;
	}

	public SimpleChartJsScaleLabelConfigBuilder labelConfig()
	{
		return labelConfigBuilder;
	}

	public abstract
			AbstractSimpleChartJsTickConfigBuilder<T, ? extends AbstractSimpleChartJsTickConfig<T>>
			tickConfig();

	@Override
	public boolean isValid()
	{
		return position != null && type != null && labelConfigBuilder.isValid()
			&& tickConfig().isValid();
	}

	@Override
	public SimpleChartJsAxisConfig<T> build() throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsAxisConfig<T> ret = new SimpleChartJsAxisConfig<>();
		ret.setDisplay(display);
		ret.setPosition(position);
		ret.setType(type);
		ret.setLabelConfig(labelConfigBuilder.build());
		ret.setTickConfig(tickConfig().build());
		return ret;
	}
}
