package nl.crashdata.chartjs.wicket.seleniumtester;

import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.tester.DummyPanelPage;

public class DummyPanelPageProvider extends PageProvider
{
	private static final long serialVersionUID = 1L;

	public DummyPanelPageProvider(final IPanelLoader loader)
	{
		super(new PanelLoaderPage(loader));
	}

	private static class PanelLoaderPage extends DummyPanelPage
	{
		private static final long serialVersionUID = 1L;

		private IPanelLoader panelLoader;

		private PanelLoaderPage(IPanelLoader loader)
		{
			this.panelLoader = loader;
		}

		@Override
		protected Panel getTestPanel(String id)
		{
			return panelLoader.getPanel(id);
		}
	}

}
