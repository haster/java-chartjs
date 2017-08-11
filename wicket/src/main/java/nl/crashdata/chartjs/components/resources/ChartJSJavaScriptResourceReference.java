package nl.crashdata.chartjs.components.resources;

import java.util.Collections;
import java.util.List;

import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public final class ChartJSJavaScriptResourceReference extends JavaScriptResourceReference
{
	private static final long serialVersionUID = 1L;

	private static ChartJSJavaScriptResourceReference INSTANCE =
		new ChartJSJavaScriptResourceReference();

	private ChartJSJavaScriptResourceReference()
	{
		super(ChartJSJavaScriptResourceReference.class, "chart.min.js");
	}

	public static ChartJSJavaScriptResourceReference get()
	{
		return INSTANCE;
	}

	@Override
	public List<HeaderItem> getDependencies()
	{
		return Collections.singletonList(JavaScriptHeaderItem.forReference(MomentJavaScriptResourceReference.get()));
	}
}
