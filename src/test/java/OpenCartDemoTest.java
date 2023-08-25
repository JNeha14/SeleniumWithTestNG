import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.test.pages.PageCache;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class OpenCartDemoTest extends BaseTest
{
    @Test(priority = 1)
    public void clickDesktopShowAll() throws IOException
    {
        pageCache.getOpenCartDemoPage().clickDesktopAllShow();

        //test assertion
        Assert.assertEquals(driver.getTitle(), "Desktops");

        //take screenshot after page load
        TakesScreenshot scrnshot = (TakesScreenshot)driver;
        File src = scrnshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("./src/test/screenshots/all_desktops.jpg"));

    }

}
