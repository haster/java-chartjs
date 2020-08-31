package nl.crashdata.chartjs.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A <em>locally defined</em> event handler; in other words, a function that has to be declared
 * alongside the chart config. Typically rendered in the head of a webpage.
 *
 * @author haster
 */
public interface ChartJsLocalEventHandler extends ChartJsEventHandler
{
	/**
	 * @return the body of the event handler function. It is advised to use
	 *         {@link #getEventParameterName()} and {@link #getItemParameterName()} to use the
	 *         correct parameter names.
	 */
	@JsonIgnore
	String getBody();

	/**
	 * @return the name of the first parameter (the event) as used in the declaration. Defaults to
	 *         {@code event}.
	 */
	@JsonIgnore
	default String getEventParameterName()
	{
		return "event";
	}

	/**
	 * @return the name of the second parameter (the item) as used in the declaration. Defaults to
	 *         {@code item}.
	 */
	@JsonIgnore
	default String getItemParameterName()
	{
		return "item";
	}

	/**
	 * @return the complete function declaration
	 */
	@JsonIgnore
	default String renderFunctionDeclaration()
	{
		return getFunctionReference() + " = function (" + getEventParameterName() + ", "
			+ getItemParameterName() + ") { " + getBody() + "};";
	}
}
