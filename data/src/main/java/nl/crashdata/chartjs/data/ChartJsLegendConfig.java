package nl.crashdata.chartjs.data;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import nl.crashdata.chartjs.data.colors.ChartJsEventHandler;

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

	@JsonProperty("onClick")
	@JsonRawValue
	ChartJsEventHandler getOnClick();
}
