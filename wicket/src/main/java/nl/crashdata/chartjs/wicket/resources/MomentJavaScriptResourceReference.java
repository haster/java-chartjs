package nl.crashdata.chartjs.wicket.resources;

import org.apache.wicket.request.resource.JavaScriptResourceReference;

public final class MomentJavaScriptResourceReference extends JavaScriptResourceReference
{
	private static final long serialVersionUID = 1L;

	private static final String MOMENTJS_NAME = "moment-with-locales.v2.27.0.js";

	private static final MomentJavaScriptResourceReference INSTANCE =
		new MomentJavaScriptResourceReference();

	private MomentJavaScriptResourceReference()
	{
		super(MomentJavaScriptResourceReference.class, MOMENTJS_NAME);
	}

	public static MomentJavaScriptResourceReference get()
	{
		return INSTANCE;
	}
}
