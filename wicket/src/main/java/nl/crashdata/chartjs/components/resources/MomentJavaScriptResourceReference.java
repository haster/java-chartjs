package nl.crashdata.chartjs.components.resources;

import org.apache.wicket.request.resource.JavaScriptResourceReference;

public final class MomentJavaScriptResourceReference extends JavaScriptResourceReference
{
	private static final long serialVersionUID = 1L;

	private static MomentJavaScriptResourceReference INSTANCE =
		new MomentJavaScriptResourceReference();

	private MomentJavaScriptResourceReference()
	{
		super(MomentJavaScriptResourceReference.class, "moment-with-locales.min.js");
	}

	public static MomentJavaScriptResourceReference get()
	{
		return INSTANCE;
	}
}
