package nl.crashdata.chartjs.wicket.components.test;

import static org.junit.Assert.*;

import nl.crashdata.chartjs.wicket.TestWicketAppliction;
import nl.crashdata.chartjs.wicket.components.pages.SimpleTestPage;
import nl.crashdata.chartjs.wicket.seleniumtester.WicketSeleniumTester;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumPageTest
{
	@Test
	public void successfulFormSubmissionLeadsToConfirmPage()
	{
		WicketSeleniumTester tester = new WicketSeleniumTester(new TestWicketAppliction());

		WebDriver d = tester.startPage(SimpleTestPage.class);

		// check the rendered page is correct
		assertEquals(SimpleTestPage.class, tester.getLastRenderedPage().getClass());

		System.out.println(d.getPageSource());

		assertTrue(d.findElement(byWicketPath("userGraph")).isDisplayed());
		assertTrue(d.findElement(byWicketPath("pagesGraph")).isDisplayed());
	}

	public static By byWicketPath(String path)
	{
		return By.cssSelector("[" + TestWicketAppliction.WICKET_PATH_ATTRIBUTE + "=" + path + "]");
	}
}
