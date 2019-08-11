package nl.crashdata.chartjs.wicket.seleniumtester;

import java.io.Serializable;

import org.apache.wicket.markup.html.panel.Panel;

public interface IPanelLoader
    extends Serializable
{
    Panel getPanel( String id );
}
