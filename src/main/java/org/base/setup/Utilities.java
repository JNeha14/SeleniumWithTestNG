package org.base.setup;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utilities
{
    WebDriver driver;
    static Actions actions;

    public Utilities(WebDriver driver)
    {
        this.driver = driver;
    }

    public void scrollToElement(By element)
    {
        WebElement we = driver.findElement(element);
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("arguments[0].scrollIntoView();", we);
    }

    public void resizeElement(By element)
    {
        //actions.clickAndHold(resizeElement).moveByOffset(50, 50).release().perform();
        actions.dragAndDropBy(driver.findElement(element), 50, 50).perform();
    }

    public void dragAndDropElement(By sourceElement, By targetElement)
    {
        actions.dragAndDrop(driver.findElement(sourceElement), driver.findElement(targetElement)).perform();
    }

}
