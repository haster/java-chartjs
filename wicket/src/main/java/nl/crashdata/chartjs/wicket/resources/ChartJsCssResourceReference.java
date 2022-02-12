package nl.crashdata.chartjs.wicket.resources;

import static nl.crashdata.chartjs.wicket.resources.ChartJsJavaScriptResourceReference.*;

import java.util.Collections;
import java.util.List;

import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

public class ChartJsCssResourceReference extends CssResourceReference
{
	private static final long serialVersionUID = 1L;

	private static final String CHARTJS_CSS_NAME = CHARTJS_VERSIONED_NAME + ".css";

	private static final ChartJsCssResourceReference INSTANCE = new ChartJsCssResourceReference();

	private ChartJsCssResourceReference()
	{
		super(ChartJsCssResourceReference.class, CHARTJS_CSS_NAME);
	}

	public static ChartJsCssResourceReference get()
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
