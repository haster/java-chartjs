package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.simple.SimpleChartJsOptions;

public class SimpleChartJsOptionsBuilder implements SimpleChartJsBuilder<SimpleChartJsOptions>
{
	private Boolean responsive;

	private SimpleChartJsTooltipConfigBuilder tooltipConfigBuilder =
		new SimpleChartJsTooltipConfigBuilder();

	private SimpleChartJsHoverConfigBuilder hoverConfigBuilder =
		new SimpleChartJsHoverConfigBuilder();

	private SimpleChartJsScalesConfigBuilder scalesConfigBuilder =
		new SimpleChartJsScalesConfigBuilder();

	public SimpleChartJsOptionsBuilder withResponsive(Boolean responsive)
	{
		this.responsive = responsive;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder tooltipConfig()
	{
		return tooltipConfigBuilder;
	}

	public SimpleChartJsHoverConfigBuilder hoverConfig()
	{
		return hoverConfigBuilder;
	}

	public SimpleChartJsScalesConfigBuilder scalesConfig()
	{
		return scalesConfigBuilder;
	}

	@Override
	public boolean isValid()
	{
		return tooltipConfigBuilder.isValid() && hoverConfigBuilder.isValid()
			&& scalesConfigBuilder.isValid();
	}

	@Override
	public SimpleChartJsOptions build()
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsOptions ret = new SimpleChartJsOptions();
		ret.setResponsive(responsive);
		ret.setHoverConfig(hoverConfigBuilder.build());
		ret.setScalesConfig(scalesConfigBuilder.build());
		ret.setTooltipConfig(tooltipConfigBuilder.build());
		return ret;
	}

}
