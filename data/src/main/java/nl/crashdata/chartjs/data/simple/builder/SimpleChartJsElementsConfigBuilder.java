package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.simple.SimpleChartJsElementsConfig;

public class SimpleChartJsElementsConfigBuilder
		implements SimpleChartJsBuilder<SimpleChartJsElementsConfig>
{
	private SimpleChartJsBarElementsConfigBuilder barElementsConfigBuilder;

	public SimpleChartJsBarElementsConfigBuilder barConfig()
	{
		if (barElementsConfigBuilder == null)
			barElementsConfigBuilder = new SimpleChartJsBarElementsConfigBuilder();
		return barElementsConfigBuilder;
	}

	@Override
	public boolean isValid()
	{
		return true;
	}

	@Override
	public SimpleChartJsElementsConfig build() throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsElementsConfig ret = new SimpleChartJsElementsConfig();
		ret.setBarElementsConfig(buildIfNotNull(barElementsConfigBuilder));
		return ret;
	}
}
