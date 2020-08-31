package nl.crashdata.chartjs.data.simple.builder;

import java.io.Serializable;

import nl.crashdata.chartjs.data.ChartJsCartesianAxisType;
import nl.crashdata.chartjs.data.ChartJsPosition;
import nl.crashdata.chartjs.data.simple.AbstractSimpleChartJsTickConfig;
import nl.crashdata.chartjs.data.simple.SimpleChartJsAxisConfig;

public abstract class AbstractSimpleChartJsAxisConfigBuilder<T extends Serializable>
		implements ChartJsBuildContextBuilder<SimpleChartJsAxisConfig<T>>
{
	private ChartJsCartesianAxisType type;

	private Boolean display;

	private ChartJsPosition position;

	private SimpleChartJsScaleLabelConfigBuilder labelConfigBuilder =
		new SimpleChartJsScaleLabelConfigBuilder();

	private SimpleChartJsTimeConfigBuilder timeConfigBuilder;

	protected AbstractSimpleChartJsAxisConfigBuilder(ChartJsCartesianAxisType type)
	{
		this.type = type;
	}

	public AbstractSimpleChartJsAxisConfigBuilder<T> withDisplay(Boolean display)
	{
		this.display = display;
		return this;
	}

	public AbstractSimpleChartJsAxisConfigBuilder<T> withPosition(ChartJsPosition position)
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

	protected SimpleChartJsTimeConfigBuilder timeConfig()
	{
		return timeConfigBuilder;
	}

	protected void setTimeConfigBuilder(SimpleChartJsTimeConfigBuilder timeConfigBuilder)
	{
		this.timeConfigBuilder = timeConfigBuilder;
	}

	@Override
	public boolean isValid()
	{
		return position != null && type != null && labelConfigBuilder.isValid()
			&& tickConfig().isValid() && (timeConfigBuilder == null || timeConfigBuilder.isValid());
	}

	@Override
	public SimpleChartJsAxisConfig<T> build(BuildContext context) throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsAxisConfig<T> ret = new SimpleChartJsAxisConfig<>();
		ret.setDisplay(display);
		ret.setPosition(position);
		ret.setType(type);
		ret.setLabelConfig(labelConfigBuilder.build(context));
		ret.setTickConfig(tickConfig().build(context));
		if (timeConfigBuilder != null)
			ret.setTimeConfig(timeConfigBuilder.build(context));
		return ret;
	}
}
