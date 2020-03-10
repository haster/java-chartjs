package nl.crashdata.chartjs.wicket.resources;

import java.util.Collections;
import java.util.List;

import nl.crashdata.chartjs.wicket.resources.ChartJSJavaScriptResourceReference;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

public class ChartJSCSSResourceReference extends CssResourceReference
{
	private static final long serialVersionUID = 1L;

	private static ChartJSCSSResourceReference INSTANCE =
		new ChartJSCSSResourceReference(ChartJSCSSResourceReference.class, "Chart.css");

	private ChartJSCSSResourceReference(Class< ? > scope, String name)
	{
		super(scope, name);
	}

	public static ChartJSCSSResourceReference get()
	{
		return INSTANCE;
	}

	@Override
	public List<HeaderItem> getDependencies()
	{
		return Collections.singletonList(
			JavaScriptHeaderItem.forReference(ChartJSJavaScriptResourceReference.get()));
	}
}
