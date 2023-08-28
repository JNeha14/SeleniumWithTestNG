package org.base.setup;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Screenshots
{

    WebDriver driver;
    File src;
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
    String formatedDateTime = currentDateTime.format(format);

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
            FileUtils.copyFile(src, new File("./src/test/screenshots/" + screenshotName + "_" + formatedDateTime + ".jpg"));

            //FileUtils.copyFile(src, new File("./src/test/screenshots/" + screenshotName + currentDateTime.toString() + ".jpg"));
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
            FileUtils.copyFile(src, new File("./src/test/screenshots/" + screenshotName + "_" + formatedDateTime + ".jpg"));
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

}
