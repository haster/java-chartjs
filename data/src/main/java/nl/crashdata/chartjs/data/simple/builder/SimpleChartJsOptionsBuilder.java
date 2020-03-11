package nl.crashdata.chartjs.data.simple.builder;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
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

	private SimpleChartJsTooltipConfigBuilder tooltipConfigBuilder =
		new SimpleChartJsTooltipConfigBuilder();

	private SimpleChartJsHoverConfigBuilder hoverConfigBuilder =
		new SimpleChartJsHoverConfigBuilder();

	private SimpleChartJsScalesConfigBuilder< ? , ? > scalesConfigBuilder =
		new SimpleChartJsScalesConfigBuilder<>();

	private SimpleChartJsTitleConfigBuilder titleConfigBuilder;

	private SimpleChartJsLegendConfigBuilder legendConfigBuilder;

	private Map<String, Serializable> plugins;

	public SimpleChartJsOptionsBuilder(Supplier<ChartJsChartType> chartTypeSupplier)
	{
		this.chartTypeSupplier = chartTypeSupplier;
	}

	public SimpleChartJsOptionsBuilder withResponsive(Boolean responsive)
	{
		this.responsive = responsive;
		return this;
	}

	public SimpleChartJsOptionsBuilder withMaintainAspectRatio(Boolean maintainAspectRatio)
	{
		this.maintainAspectRatio = maintainAspectRatio;
		return this;
	}

	public SimpleChartJsOptionsBuilder withCutoutPercentage(Integer cutoutPercentage)
	{
		this.cutoutPercentage = cutoutPercentage;
		return this;
	}

	public SimpleChartJsOptionsBuilder withRotation(Integer rotation)
	{
		this.rotation = rotation;
		return this;
	}

	public SimpleChartJsOptionsBuilder withCircumference(Integer circumference)
	{
		this.circumference = circumference;
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

	public SimpleChartJsScalesConfigBuilder< ? , ? > scalesConfig()
	{
		return scalesConfigBuilder;
	}

	public SimpleChartJsTitleConfigBuilder titleConfig()
	{
		if (titleConfigBuilder == null)
			titleConfigBuilder = new SimpleChartJsTitleConfigBuilder();
		return titleConfigBuilder;
	}

	public SimpleChartJsLegendConfigBuilder legendConfig()
	{
		if (legendConfigBuilder == null)
			legendConfigBuilder = new SimpleChartJsLegendConfigBuilder(chartTypeSupplier);
		return legendConfigBuilder;
	}

	public SimpleChartJsOptionsBuilder withPlugin(String name, Serializable configuration)
	{
		if (plugins == null)
			plugins = new LinkedHashMap<>();
		plugins.put(name, configuration);
		return this;
	}

	@Override
	public boolean isValid()
	{
		return tooltipConfigBuilder.isValid() && hoverConfigBuilder.isValid()
			&& scalesConfigBuilder.isValid()
			&& (titleConfigBuilder == null || titleConfigBuilder.isValid())
			&& (legendConfigBuilder == null || legendConfigBuilder.isValid());
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
		ret.setHoverConfig(hoverConfigBuilder.build());
		ret.setScalesConfig(scalesConfigBuilder.build());
		ret.setTooltipConfig(tooltipConfigBuilder.build());
		ret.setTitleConfig(titleConfigBuilder == null ? null : titleConfigBuilder.build());
		ret.setLegendConfig(legendConfigBuilder == null ? null : legendConfigBuilder.build());
		ret.setPlugins(plugins);
		return ret;
	}

}
