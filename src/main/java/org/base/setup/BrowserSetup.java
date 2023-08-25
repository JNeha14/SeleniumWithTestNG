package org.base.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BrowserSetup
{

    public static WebDriver driver;

    public BrowserSetup(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebDriver driverSetUp(String browser, String url)
    {
        switch(browser)
        {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                System.out.println("Incorrect browser name:" + browser);

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public void cleanUpBrowser()
    {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
