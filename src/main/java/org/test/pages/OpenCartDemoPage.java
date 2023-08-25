package org.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenCartDemoPage
{

    WebDriver driver;
    Actions actions;

    //elements
    private static final By desktopsLink = By.xpath("//a[text()='Desktops']");
    private static final By showAllDesktops = By.xpath("//a[text()='Desktops']//following::a[text()='Show All Desktops']");

    public OpenCartDemoPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickDesktopAllShow()
    {
        //perform multiple actions
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(desktopsLink)).click(driver.findElement(showAllDesktops)).perform();

        //wait until page is loaded
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(bool -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
    }

}
