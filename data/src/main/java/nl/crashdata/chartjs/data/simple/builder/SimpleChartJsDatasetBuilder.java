package nl.crashdata.chartjs.data.simple.builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import nl.crashdata.chartjs.data.ChartJsFill;
import nl.crashdata.chartjs.data.colors.ChartJsRGBAColor;
import nl.crashdata.chartjs.data.simple.SimpleChartJsDataset;

public class SimpleChartJsDatasetBuilder<E extends Serializable>
		implements SimpleChartJsBuilder<SimpleChartJsDataset<E>>
{
	private List<ChartJsRGBAColor> backgroundColor;

	private List<ChartJsRGBAColor> borderColor;

	private List<Integer> borderWidth;

	private List<ChartJsRGBAColor> hoverBackgroundColor;

	private List<ChartJsRGBAColor> hoverBorderColor;

	private List<Integer> hoverBorderWidth;

	private String label;

	private ChartJsFill fill = ChartJsFill.DISABLED;

	private String stack;

	private List<E> data = new ArrayList<>();

	public SimpleChartJsDatasetBuilder<E>
			withBackgroundColors(List<ChartJsRGBAColor> backgroundColors)
	{
		this.backgroundColor = backgroundColors;
		return this;
	}

	public SimpleChartJsDatasetBuilder<E> withBorderColors(List<ChartJsRGBAColor> borderColors)
	{
		this.borderColor = borderColors;
		return this;
	}

	public SimpleChartJsDatasetBuilder<E> withBorderWidths(List<Integer> borderWidths)
	{
		this.borderWidth = borderWidths;
		return this;
	}

	public SimpleChartJsDatasetBuilder<E>
			withHoverBackgroundColors(List<ChartJsRGBAColor> hoverBackgroundColors)
	{
		this.hoverBackgroundColor = hoverBackgroundColors;
		return this;
	}

	public SimpleChartJsDatasetBuilder<E>
			withHoverBorderColors(List<ChartJsRGBAColor> hoverBorderColors)
	{
		this.hoverBorderColor = hoverBorderColors;
		return this;
	}

	public SimpleChartJsDatasetBuilder<E> withHoverBorderWidths(List<Integer> hoverBorderWidths)
	{
		this.hoverBorderWidth = hoverBorderWidths;
		return this;
	}

	public SimpleChartJsDatasetBuilder<E> withBackgroundColor(ChartJsRGBAColor backgroundColor)
	{
		this.backgroundColor = Collections.singletonList(backgroundColor);
		return this;
	}

	public SimpleChartJsDatasetBuilder<E> withBorderColor(ChartJsRGBAColor borderColor)
	{
		this.borderColor = Collections.singletonList(borderColor);
		return this;
	}

	public SimpleChartJsDatasetBuilder<E> withBorderWidth(Integer borderWidth)
	{
		this.borderWidth = Collections.singletonList(borderWidth);
		return this;
	}

	public SimpleChartJsDatasetBuilder<E>
			withHoverBackgroundColor(ChartJsRGBAColor hoverBackgroundColor)
	{
		this.hoverBackgroundColor = Collections.singletonList(hoverBackgroundColor);
		return this;
	}

	public SimpleChartJsDatasetBuilder<E> withHoverBorderColor(ChartJsRGBAColor hoverBorderColor)
	{
		this.hoverBorderColor = Collections.singletonList(hoverBorderColor);
		return this;
	}

	public SimpleChartJsDatasetBuilder<E> withHoverBorderWidth(Integer hoverBorderWidth)
	{
		this.hoverBorderWidth = Collections.singletonList(hoverBorderWidth);
		return this;
	}

	public SimpleChartJsDatasetBuilder<E> withLabel(String label)
	{
		this.label = label;
		return this;
	}

	public SimpleChartJsDatasetBuilder<E> withFill(ChartJsFill fill)
	{
		this.fill = fill;
		return this;
	}

	public SimpleChartJsDatasetBuilder<E> withStack(String stack)
	{
		this.stack = stack;
		return this;
	}

	public SimpleChartJsDatasetBuilder<E> withDataPoints(List<E> dataPoints)
	{
		this.data = dataPoints;
		return this;
	}

	public <X> SimpleChartJsDatasetBuilder<E> withDataPoints(Collection<X> dataPoints,
			Function<X, E> converter)
	{
		this.data = dataPoints.stream().map(converter).collect(Collectors.toList());
		return this;
	}

	@Override
	public boolean isValid()
	{
		return !data.isEmpty();
	}

	@Override
	public SimpleChartJsDataset<E> build() throws IllegalStateException
	{
		if (!isValid())
		{
			throw new IllegalStateException(getClass().getSimpleName() + " is not ready to build!");
		}
		SimpleChartJsDataset<E> ret = new SimpleChartJsDataset<>();
		ret.setLabel(label);
		ret.setBackgroundColor(backgroundColor);
		ret.setBorderColor(borderColor);
		ret.setBorderWidth(borderWidth);
		ret.setHoverBackgroundColor(hoverBackgroundColor);
		ret.setHoverBorderColor(hoverBorderColor);
		ret.setHoverBorderWidth(hoverBorderWidth);
		ret.setData(data);
		ret.setFill(fill);
		ret.setStack(stack);
		return ret;
	}
}
