package nl.crashdata.chartjs.wicket.resources;

import java.util.List;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public final class ChartJSJavaScriptResourceReference extends JavaScriptResourceReference
{
	private static final long serialVersionUID = 1L;

	static final String CHARTJS_VERSIONED_NAME = "chart.v2.9.3";

	private static final String CHARTJS_JS_NAME = CHARTJS_VERSIONED_NAME + ".js";

	private static final ChartJSJavaScriptResourceReference INSTANCE =
		new ChartJSJavaScriptResourceReference();

	private ChartJSJavaScriptResourceReference()
	{
		super(ChartJSJavaScriptResourceReference.class, CHARTJS_JS_NAME);
	}

	public static ChartJSJavaScriptResourceReference get()
	{
		return INSTANCE;
	}

	@Override
	public List<HeaderItem> getDependencies()
	{
		return List.of(JavaScriptHeaderItem.forReference(MomentJavaScriptResourceReference.get()),
			CssHeaderItem.forReference(ChartJsCssResourceReference.get()));
	}
}
