package org.base.setup;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.Optional;

public class Utilities
{
    WebDriver driver;
    static Actions actions;

    public Utilities(WebDriver driver)
    {
        this.driver = driver;
        actions = new Actions(this.driver);
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

    public void handleAlerts(String option)
    {
        Optional<String> opt = Optional.ofNullable(option);
        String a = opt.isPresent() ? opt.get() : "accept";

        Alert alert = driver.switchTo().alert();

        if(a.equalsIgnoreCase("accept"))
        {
            alert.accept();
        }
        else if (a.equalsIgnoreCase("dismiss"))
        {
            alert.dismiss();
        }

    }

    public void handlePrompts(String name, String option)
    {
        Optional<String> opt = Optional.ofNullable(option);
        String a = opt.isPresent() ? opt.get() : "accept";

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(name);

        if(a.equalsIgnoreCase("accept"))
        {
            alert.accept();
        }
        else if (a.equalsIgnoreCase("dismiss"))
        {
            alert.dismiss();
        }
    }

}
