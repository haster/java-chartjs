package nl.crashdata.chartjs.data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * An object representing a reference to an event handler.
 *
 * ChartJs event handlers are javascript functions of the signature:
 * {@code new function(event, item)}. Since it's a function, it can't be rendered inline in the JSON
 * config so we only render the name of the function to call as a reference. The function definition
 * has to be rendered separately, for example in a static .js file or in the head of a webpage.
 *
 * @author haster
 */
public interface ChartJsEventHandler extends Serializable
{
	@JsonValue
	String getFunctionReference();
}
