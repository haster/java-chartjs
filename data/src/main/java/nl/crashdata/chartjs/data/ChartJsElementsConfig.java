package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the 'elements'-configuration for a chart, ie. options specific to elementtypes.
 * Certain options overlap with the dataset-specific options, such as {@code borderColor} and
 * {@code backgroundColor}. If you want to have two bar charts, one red and one blue, both with a
 * border width of 2, you could set {@code options.elements.bar.borderWidth} property, and then set
 * the colors in the {@code options.data.datasets.[].backgroundColor} options.
 *
 * Corresponds to the {@code config.options.elements} property.
 *
 * @author haster
 *
 */
public interface ChartJsElementsConfig extends Serializable
{
	@JsonProperty("bar")
	ChartJsBarElementsConfig getBarElementsConfig();
}
