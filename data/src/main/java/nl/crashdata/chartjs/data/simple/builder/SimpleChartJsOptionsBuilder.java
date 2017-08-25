package nl.crashdata.chartjs.data.simple.builder;

import nl.crashdata.chartjs.data.simple.SimpleChartJsOptions;

public class SimpleChartJsOptionsBuilder implements SimpleChartJsBuilder<SimpleChartJsOptions>
{
	private Boolean responsive;

	private SimpleChartJsTooltipConfigBuilder tooltipConfigBuilder;

	private SimpleChartJsHoverConfigBuilder hoverConfigBuilder;

	private SimpleChartJsScalesConfigBuilder scalesConfigBuilder;

	public SimpleChartJsOptionsBuilder withResponsive(Boolean responsive)
	{
		this.responsive = responsive;
		return this;
	}

	public SimpleChartJsTooltipConfigBuilder tooltipConfig()
	{
		if (this.tooltipConfigBuilder == null)
			this.tooltipConfigBuilder = new SimpleChartJsTooltipConfigBuilder();
		return tooltipConfigBuilder;
	}

	public SimpleChartJsHoverConfigBuilder hoverConfig()
	{
		if (this.hoverConfigBuilder == null)
			this.hoverConfigBuilder = new SimpleChartJsHoverConfigBuilder();
		return hoverConfigBuilder;
	}

	public SimpleChartJsScalesConfigBuilder scalesConfig()
	{
		if (this.scalesConfigBuilder == null)
			this.scalesConfigBuilder = new SimpleChartJsScalesConfigBuilder();
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
