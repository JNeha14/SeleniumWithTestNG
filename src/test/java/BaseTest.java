import org.openqa.selenium.WebDriver;
import org.test.pages.PageCache;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest
{
    public static WebDriver driver;
    public static PageCache pageCache;
    //private static final String url = "https://demo.opencart.com";

    @Parameters({"url"})
    @BeforeTest()
    public static void setUp(String url)
    {
        driver = PageCache.getBrowserSetUp().driverSetUp("chrome", url);
        pageCache = new PageCache(driver);

        //return driver;
    }

    @AfterTest
    public void cleanUpBrowser()
    {
        try {
            System.out.println("Closing all the browsers");
        }
        finally {
            pageCache.getBrowserSetUp().cleanUpBrowser();
        }
    }

}
