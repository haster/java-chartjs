package nl.crashdata.chartjs.data.simple.builder;

import java.util.function.Supplier;

import nl.crashdata.chartjs.data.ChartJsChartType;
import nl.crashdata.chartjs.data.simple.SimpleChartJsOptions;

public class SimpleChartJsOptionsBuilder implements SimpleChartJsBuilder<SimpleChartJsOptions>
{
	private Supplier<ChartJsChartType> chartTypeSupplier;

	private Boolean responsive;

	private Boolean maintainAspectRatio;

	private Integer cutoutPercentage;

	private Integer rotation;

	private Integer circumference;

	private SimpleChartJsHoverConfigBuilder hoverConfigBuilder;

	private SimpleChartJsScalesConfigBuilder< ? , ? > scalesConfigBuilder;

	private SimpleChartJsPluginsConfigBuilder pluginsConfigBuilder;

	public SimpleChartJsOptionsBuilder(Supplier<ChartJsChartType> chartTypeSupplier)
	{
		this.chartTypeSupplier = chartTypeSupplier;
	}

	public SimpleChartJsBuilder<SimpleChartJsOptions> withResponsive(Boolean responsive)
	{
		this.responsive = responsive;
		return this;
	}

	public SimpleChartJsBuilder<SimpleChartJsOptions>
			withMaintainAspectRatio(Boolean maintainAspectRatio)
	{
		this.maintainAspectRatio = maintainAspectRatio;
		return this;
	}

	public SimpleChartJsBuilder<SimpleChartJsOptions> withCutoutPercentage(Integer cutoutPercentage)
	{
		this.cutoutPercentage = cutoutPercentage;
		return this;
	}

	public SimpleChartJsBuilder<SimpleChartJsOptions> withRotation(Integer rotation)
	{
		this.rotation = rotation;
		return this;
	}

	public SimpleChartJsBuilder<SimpleChartJsOptions> withCircumference(Integer circumference)
	{
		this.circumference = circumference;
		return this;
	}

	public SimpleChartJsHoverConfigBuilder hoverConfig()
	{
		if (hoverConfigBuilder == null)
			hoverConfigBuilder = new SimpleChartJsHoverConfigBuilder();
		return hoverConfigBuilder;
	}

	public SimpleChartJsScalesConfigBuilder< ? , ? > scalesConfig()
	{
		if (scalesConfigBuilder == null)
			scalesConfigBuilder = new SimpleChartJsScalesConfigBuilder<>();
		return scalesConfigBuilder;
	}

	public SimpleChartJsPluginsConfigBuilder pluginsConfig()
	{
		if (pluginsConfigBuilder == null)
			pluginsConfigBuilder = new SimpleChartJsPluginsConfigBuilder(chartTypeSupplier);
		return pluginsConfigBuilder;
	}

	@Override
	public boolean isValid()
	{
		return allNullOrValid(hoverConfigBuilder, scalesConfigBuilder);
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
		ret.setMaintainAspectRatio(maintainAspectRatio);
		ret.setCutoutPercentage(cutoutPercentage);
		ret.setRotation(rotation);
		ret.setCircumference(circumference);
		ret.setHoverConfig(buildIfNotNull(hoverConfigBuilder));
		ret.setScalesConfig(buildIfNotNull(scalesConfigBuilder));
		ret.setPluginsConfig(buildIfNotNull(pluginsConfigBuilder));
		return ret;
	}
}
