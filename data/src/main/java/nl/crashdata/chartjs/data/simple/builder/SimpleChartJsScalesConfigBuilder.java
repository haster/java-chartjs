package nl.crashdata.chartjs.data.simple.builder;

import java.io.Serializable;

import nl.crashdata.chartjs.data.ChartJsAxisPosition;
import nl.crashdata.chartjs.data.simple.SimpleChartJsScalesConfig;

public class SimpleChartJsScalesConfigBuilder<X extends Serializable, Y extends Serializable>
		implements SimpleChartJsBuilder<SimpleChartJsScalesConfig<X, Y>>
{
	private AbstractSimpleChartJsAxisConfigBuilder<X> xAxisConfigBuilder;

	private AbstractSimpleChartJsAxisConfigBuilder<Y> yAxisConfigBuilder;

	@Override
	public boolean isValid()
	{
		return xAxisConfigBuilder.isValid() && yAxisConfigBuilder.isValid();
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLocalDateAxisConfigBuilder withLocalDateXAxisConfig()
	{
		SimpleChartJsLocalDateAxisConfigBuilder ret = new SimpleChartJsLocalDateAxisConfigBuilder();
		ret.withPosition(ChartJsAxisPosition.BOTTOM);
		xAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<X>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLocalDateTimeAxisConfigBuilder withLocalDateTimeXAxisConfig()
	{
		SimpleChartJsLocalDateTimeAxisConfigBuilder ret =
			new SimpleChartJsLocalDateTimeAxisConfigBuilder();
		ret.withPosition(ChartJsAxisPosition.BOTTOM);
		xAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<X>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLocalTimeAxisConfigBuilder withLocalTimeXAxisConfig()
	{
		SimpleChartJsLocalTimeAxisConfigBuilder ret = new SimpleChartJsLocalTimeAxisConfigBuilder();
		ret.withPosition(ChartJsAxisPosition.BOTTOM);
		xAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<X>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsInstantAxisConfigBuilder withInstantXAxisConfig()
	{
		SimpleChartJsInstantAxisConfigBuilder ret = new SimpleChartJsInstantAxisConfigBuilder();
		ret.withPosition(ChartJsAxisPosition.BOTTOM);
		xAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<X>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLinearAxisConfigBuilder withLinearXAxisConfig()
	{
		SimpleChartJsLinearAxisConfigBuilder ret = new SimpleChartJsLinearAxisConfigBuilder();
		ret.withPosition(ChartJsAxisPosition.BOTTOM);
		xAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<X>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLogarithmicAxisConfigBuilder withLogarithmicXAxisConfig()
	{
		SimpleChartJsLogarithmicAxisConfigBuilder ret =
			new SimpleChartJsLogarithmicAxisConfigBuilder();
		ret.withPosition(ChartJsAxisPosition.BOTTOM);
		xAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<X>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsCategoryAxisConfigBuilder withCategoryXAxisConfig()
	{
		SimpleChartJsCategoryAxisConfigBuilder ret = new SimpleChartJsCategoryAxisConfigBuilder();
		ret.withPosition(ChartJsAxisPosition.BOTTOM);
		xAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<X>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLocalDateAxisConfigBuilder withLocalDateYAxisConfig()
	{
		SimpleChartJsLocalDateAxisConfigBuilder ret = new SimpleChartJsLocalDateAxisConfigBuilder();
		ret.withPosition(ChartJsAxisPosition.BOTTOM);
		yAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<Y>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLocalDateTimeAxisConfigBuilder withLocalDateTimeYAxisConfig()
	{
		SimpleChartJsLocalDateTimeAxisConfigBuilder ret =
			new SimpleChartJsLocalDateTimeAxisConfigBuilder();
		ret.withPosition(ChartJsAxisPosition.BOTTOM);
		yAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<Y>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLocalTimeAxisConfigBuilder withLocalTimeYAxisConfig()
	{
		SimpleChartJsLocalTimeAxisConfigBuilder ret = new SimpleChartJsLocalTimeAxisConfigBuilder();
		ret.withPosition(ChartJsAxisPosition.BOTTOM);
		yAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<Y>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsInstantAxisConfigBuilder withInstantYAxisConfig()
	{
		SimpleChartJsInstantAxisConfigBuilder ret = new SimpleChartJsInstantAxisConfigBuilder();
		ret.withPosition(ChartJsAxisPosition.BOTTOM);
		yAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<Y>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLinearAxisConfigBuilder withLinearYAxisConfig()
	{
		SimpleChartJsLinearAxisConfigBuilder ret = new SimpleChartJsLinearAxisConfigBuilder();
		ret.withPosition(ChartJsAxisPosition.BOTTOM);
		yAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<Y>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsLogarithmicAxisConfigBuilder withLogarithmicYAxisConfig()
	{
		SimpleChartJsLogarithmicAxisConfigBuilder ret =
			new SimpleChartJsLogarithmicAxisConfigBuilder();
		ret.withPosition(ChartJsAxisPosition.BOTTOM);
		yAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<Y>) ret;
		return ret;
	}

	@SuppressWarnings("unchecked")
	public SimpleChartJsCategoryAxisConfigBuilder withCategoryYAxisConfig()
	{
		SimpleChartJsCategoryAxisConfigBuilder ret = new SimpleChartJsCategoryAxisConfigBuilder();
		ret.withPosition(ChartJsAxisPosition.BOTTOM);
		yAxisConfigBuilder = (AbstractSimpleChartJsAxisConfigBuilder<Y>) ret;
		return ret;
	}

	@Override
	public SimpleChartJsScalesConfig<X, Y> build() throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsScalesConfig<X, Y> ret = new SimpleChartJsScalesConfig<>();
		ret.setxAxis(xAxisConfigBuilder.build());
		ret.setyAxis(yAxisConfigBuilder.build());
		return ret;
	}
}
