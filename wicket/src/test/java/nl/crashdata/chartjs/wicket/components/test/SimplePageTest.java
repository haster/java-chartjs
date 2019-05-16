package nl.crashdata.chartjs.wicket.components.test;

import nl.crashdata.chartjs.wicket.components.pages.SimpleTestPage;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SimplePageTest 
{
	private WicketTester tester;

    @BeforeEach
    public void setUp()
    {
            tester = new WicketTester();
    }
    
    @Test
    public void homepageRendersSuccessfully()
    {
            //start and render the test page
            tester.startPage(SimpleTestPage.class);
            //assert rendered page class
            tester.assertRenderedPage(SimpleTestPage.class);
            
            // dump for manual inspection
            tester.dumpPage();
    }
}
