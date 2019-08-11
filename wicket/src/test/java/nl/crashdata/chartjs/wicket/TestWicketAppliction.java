package nl.crashdata.chartjs.wicket;

import nl.crashdata.chartjs.wicket.components.pages.SimpleTestPage;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class TestWicketAppliction extends WebApplication
{
	public static final String WICKET_PATH_ATTRIBUTE = "data-wicket-path";

	public TestWicketAppliction()
	{
		super();
	}

	@Override
	protected void init()
	{
		super.init();
		getDebugSettings().setComponentPathAttributeName(WICKET_PATH_ATTRIBUTE);
	}

	@Override
	public Class< ? extends Page> getHomePage()
	{
		return SimpleTestPage.class;
	}

}
