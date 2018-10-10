package nl.crashdata.chartjs.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the title-configuration for a chart.
 *
 * Corresponds to the {@code config.options.legend} property.
 *
 * @author papegaaij
 *
 */
public interface ChartJsLegendConfig extends Serializable
{
	@JsonProperty("display")
	Boolean getDisplay();

	@JsonProperty("position")
	ChartJsPosition getPosition();

	@JsonProperty("fullWidth")
	Boolean getFullWidth();

	@JsonProperty("reverse")
	Boolean getReverse();

	@JsonProperty("labels")
	List<String> getLabels();
}
