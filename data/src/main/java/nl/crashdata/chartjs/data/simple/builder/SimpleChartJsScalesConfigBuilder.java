package nl.crashdata.chartjs.data.simple.builder;

import java.io.Serializable;

import nl.crashdata.chartjs.data.ChartJsPosition;
import nl.crashdata.chartjs.data.simple.SimpleChartJsScalesConfig;

public class SimpleChartJsScalesConfigBuilder<X extends Serializable, Y extends Serializable>
		implements ChartJsBuildContextBuilder<SimpleChartJsScalesConfig<X, Y>>
{
	private AbstractSimpleChartJsAxisConfigBuilder<X> xAxisConfigBuilder;

	private AbstractSimpleChartJsAxisConfigBuilder<Y> yAxisConfigBuilder;

	@Override
	public boolean isValid()
	{
		return (xAxisConfigBuilder == null || xAxisConfigBuilder.isValid())
			&& (yAxisConfigBuilder == null || yAxisConfigBuilder.isValid());
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLocalDateAxisConfigBuilder withLocalDateXAxisConfig()
	{
		SimpleChartJsLocalDateAxisConfigBuilder ret = new SimpleChartJsLocalDateAxisConfigBuilder();
		ret.withPosition(ChartJsPosition.BOTTOM);
		xAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<X>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLocalDateTimeAxisConfigBuilder withLocalDateTimeXAxisConfig()
	{
		SimpleChartJsLocalDateTimeAxisConfigBuilder ret =
			new SimpleChartJsLocalDateTimeAxisConfigBuilder();
		ret.withPosition(ChartJsPosition.BOTTOM);
		xAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<X>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLocalTimeAxisConfigBuilder withLocalTimeXAxisConfig()
	{
		SimpleChartJsLocalTimeAxisConfigBuilder ret = new SimpleChartJsLocalTimeAxisConfigBuilder();
		ret.withPosition(ChartJsPosition.BOTTOM);
		xAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<X>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsInstantAxisConfigBuilder withInstantXAxisConfig()
	{
		SimpleChartJsInstantAxisConfigBuilder ret = new SimpleChartJsInstantAxisConfigBuilder();
		ret.withPosition(ChartJsPosition.BOTTOM);
		xAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<X>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLinearAxisConfigBuilder withLinearXAxisConfig()
	{
		SimpleChartJsLinearAxisConfigBuilder ret = new SimpleChartJsLinearAxisConfigBuilder();
		ret.withPosition(ChartJsPosition.BOTTOM);
		xAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<X>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLogarithmicAxisConfigBuilder withLogarithmicXAxisConfig()
	{
		SimpleChartJsLogarithmicAxisConfigBuilder ret =
			new SimpleChartJsLogarithmicAxisConfigBuilder();
		ret.withPosition(ChartJsPosition.BOTTOM);
		xAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<X>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsCategoryAxisConfigBuilder withCategoryXAxisConfig()
	{
		SimpleChartJsCategoryAxisConfigBuilder ret = new SimpleChartJsCategoryAxisConfigBuilder();
		ret.withPosition(ChartJsPosition.BOTTOM);
		xAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<X>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLocalDateAxisConfigBuilder withLocalDateYAxisConfig()
	{
		SimpleChartJsLocalDateAxisConfigBuilder ret = new SimpleChartJsLocalDateAxisConfigBuilder();
		ret.withPosition(ChartJsPosition.LEFT);
		yAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<Y>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLocalDateTimeAxisConfigBuilder withLocalDateTimeYAxisConfig()
	{
		SimpleChartJsLocalDateTimeAxisConfigBuilder ret =
			new SimpleChartJsLocalDateTimeAxisConfigBuilder();
		ret.withPosition(ChartJsPosition.LEFT);
		yAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<Y>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLocalTimeAxisConfigBuilder withLocalTimeYAxisConfig()
	{
		SimpleChartJsLocalTimeAxisConfigBuilder ret = new SimpleChartJsLocalTimeAxisConfigBuilder();
		ret.withPosition(ChartJsPosition.LEFT);
		yAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<Y>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsInstantAxisConfigBuilder withInstantYAxisConfig()
	{
		SimpleChartJsInstantAxisConfigBuilder ret = new SimpleChartJsInstantAxisConfigBuilder();
		ret.withPosition(ChartJsPosition.LEFT);
		yAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<Y>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLinearAxisConfigBuilder withLinearYAxisConfig()
	{
		SimpleChartJsLinearAxisConfigBuilder ret = new SimpleChartJsLinearAxisConfigBuilder();
		ret.withPosition(ChartJsPosition.LEFT);
		yAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<Y>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLogarithmicAxisConfigBuilder withLogarithmicYAxisConfig()
	{
		SimpleChartJsLogarithmicAxisConfigBuilder ret =
			new SimpleChartJsLogarithmicAxisConfigBuilder();
		ret.withPosition(ChartJsPosition.LEFT);
		yAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<Y>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsCategoryAxisConfigBuilder withCategoryYAxisConfig()
	{
		SimpleChartJsCategoryAxisConfigBuilder ret = new SimpleChartJsCategoryAxisConfigBuilder();
		ret.withPosition(ChartJsPosition.LEFT);
		yAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<Y>) ret;
		return ret;
	}

	@Override
	public SimpleChartJsScalesConfig<X, Y> build(BuildContext context) throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsScalesConfig<X, Y> ret = new SimpleChartJsScalesConfig<>();
		if (xAxisConfigBuilder == null && yAxisConfigBuilder == null)
			return null;
		if (xAxisConfigBuilder != null)
			ret.setxAxis(xAxisConfigBuilder.build(context));
		if (yAxisConfigBuilder != null)
			ret.setyAxis(yAxisConfigBuilder.build(context));
		return ret;
	}
}
