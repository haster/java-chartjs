package nl.crashdata.chartjs.wicket.components.resources;

import java.util.Collections;
import java.util.List;

import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public final class ChartJSJavaScriptResourceReference extends JavaScriptResourceReference
{
	private static final long serialVersionUID = 1L;

	private static final String CHARTJS_NAME = "chart.v2.8.0.js";

	private static final ChartJSJavaScriptResourceReference INSTANCE =
		new ChartJSJavaScriptResourceReference();

	private ChartJSJavaScriptResourceReference()
	{
		super(ChartJSJavaScriptResourceReference.class, CHARTJS_NAME);
	}

	public static ChartJSJavaScriptResourceReference get()
	{
		return INSTANCE;
	}

	@Override
	public List<HeaderItem> getDependencies()
	{
		return Collections.singletonList(
			JavaScriptHeaderItem.forReference(MomentJavaScriptResourceReference.get()));
	}
}
