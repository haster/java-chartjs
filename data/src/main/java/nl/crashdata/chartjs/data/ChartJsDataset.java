package nl.crashdata.chartjs.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import nl.crashdata.chartjs.data.colors.ChartJsRGBAColor;

/**
 * Represents the configuration of one dataset for a chart. In other words, this represents the data
 * for one line in a line chart. If there are moultiple lines, there will be multiple datasets.
 *
 * Corresponds to the elements of the {@code config.data.datasets} property.
 *
 * @author haster
 *
 * @param <E>
 *            The type of the elements of the data.
 */
public interface ChartJsDataset<E extends Serializable> extends Serializable
{
	@JsonProperty("data")
	List<E> getData();

	@JsonProperty("label")
	String getLabel();

	@JsonProperty("backgroundColor")
	List<ChartJsRGBAColor> getBackgroundColor();

	@JsonProperty("borderColor")
	List<ChartJsRGBAColor> getBorderColor();

	@JsonProperty("borderWidth")
	List<Integer> getBorderWidth();

	@JsonProperty("hoverBackgroundColor")
	List<ChartJsRGBAColor> getHoverBackgroundColor();

	@JsonProperty("hoverBorderColor")
	List<ChartJsRGBAColor> getHoverBorderColor();

	@JsonProperty("hoverBorderWidth")
	List<Integer> getHoverBorderWidth();

	@JsonProperty("fill")
	ChartJsFill getFill();

	@JsonProperty("stack")
	String getStack();
}
