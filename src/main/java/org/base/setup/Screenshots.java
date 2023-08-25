package org.base.setup;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class Screenshots
{

    WebDriver driver;
    File src;

    public Screenshots(WebDriver driver)
    {
        this.driver = driver;
    }

    public void takePageScreenshot(String screenshotName)
    {
        try
        {
            TakesScreenshot screenshot = (TakesScreenshot)driver;
            src = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("./src/test/screenshots/" + screenshotName + ".jpg"));
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public void takeElementScreenshot(By element, String screenshotName)
    {
        try
        {
            src = driver.findElement(element).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File("./src/test/screenshots/" + screenshotName + ".jpg"));
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

}
