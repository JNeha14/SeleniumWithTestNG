package org.test.pages;

import org.base.setup.BrowserSetup;
import org.base.setup.Screenshots;
import org.base.setup.Utilities;
import org.openqa.selenium.WebDriver;

public class PageCache
{
    public static WebDriver driver;

    private static BrowserSetup browserSetUp;
    private static OpenCartDemoPage openCartDemoPage;
    private static AutomationPracticeSitePage automationPracticeSitePage;
    private static Screenshots screenshots;
    private static Utilities utilities;

    public PageCache(WebDriver driver)
    {
        this.driver = driver;
    }

    public static BrowserSetup getBrowserSetUp()
    {
        if(browserSetUp == null)
        {
            browserSetUp = new BrowserSetup(driver);
        }
        return browserSetUp;
    }

    public static Screenshots getScreenshots()
    {
        if(screenshots == null)
        {
            screenshots = new Screenshots(driver);
        }
        return screenshots;
    }

    public static Utilities getUtilities()
    {
        if(utilities == null)
        {
            utilities = new Utilities(driver);
        }
        return utilities;
    }

    public static OpenCartDemoPage getOpenCartDemoPage()
    {
        if(openCartDemoPage == null)
        {
            openCartDemoPage = new OpenCartDemoPage(driver);
        }
        return openCartDemoPage;
    }

    public static AutomationPracticeSitePage getAutomationPracticeSitePage()
    {
        if(automationPracticeSitePage == null)
        {
            automationPracticeSitePage = new AutomationPracticeSitePage(driver);
        }
        return automationPracticeSitePage;
    }

}
