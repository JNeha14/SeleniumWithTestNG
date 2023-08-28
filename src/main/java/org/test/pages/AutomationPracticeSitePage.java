package org.test.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

public class AutomationPracticeSitePage
{
    private static WebDriver driver;
    static Actions actions;
    static PageCache pageCache;
    static int date = LocalDate.now().getDayOfMonth();

    //elements
    //id
    private static final By txtName = By.id("name");
    private static final By txtEmail = By.id("email");
    private static final By txtPhone = By.id("phone");
    private static final By txtAddress = By.id("textarea");
    private static final By radioBtnFemale = By.id("female");
    private static final By ddCountry = By.id("country");
    private static final By multiSelectDdColors = By.id("colors");
    private static final By txtDate = By.id("datepicker");
    private static final By selectDate = By.id("ui-datepicker-div");
    private static final By tableBooks = By.id("BookTable");
    private static final By pageTableProduct = By.id("productTable");
    private static final By txtWiki = By.id("Wikipedia1_wikipedia-search-input");
    private static final By frameForm = By.id("frame-one796456169");
    private static final String frameFormName = "frame-one796456169";
    private static final By dragDiv = By.id("draggable");
    private static final By dropDiv = By.id("droppable");
    private static final By txtField1 = By.id("field1");
    private static final By txtField2 = By.id("field2");
    private static final By txtFrameName = By.id("RESULT_TextField-0");
    private static final By radioBtnFrameFemale = By.id("RESULT_RadioButton-1_1");
    private static final By txtFrameDate = By.id("RESULT_TextField-2");
    private static final By ddJob = By.id("RESULT_RadioButton-3");
    private static final By btnFrameSubmit = By.id("FSsubmit");

    //class
    private static final By linkWiki = By.className("wikipedia-search-wiki-link");
    private static final By btnWikiSearch = By.className("wikipedia-search-button");
    private static final By iconCalendar = By.className("icon_calendar");
    private static final By frameFormTable = By.className("form_table");

    //xpath
    private static final By paginationUL = By.xpath("//ul[@id='pagination']//child::li//a");
    private static final By slider = By.xpath("//div[@id='slider']//span");
    private static final By btnCopyText = By.xpath("//button[text()='Copy Text']");
    private static final By btnAlert = By.xpath("//button[text()='Alert']");
    private static final By btnConfirmBox = By.xpath("//button[text()='Confirm Box']");
    private static final By btnPrompt = By.xpath("//button[text()='Prompt']");
    private static final By btnNewBrowserWindow = By.xpath("//button[text()='New Browser Window']");
    private static final By dayCal = By.xpath("//div[@id='ui-datepicker-div']//following::table//td/a[text()='" + date + "']");
    private static final By searchResults = By.xpath("(//input[@id='Wikipedia1_wikipedia-search-input']//following::div[@id='Wikipedia1_wikipedia-search-results']//child::a)[1]");
    private static final By resizeDiv = By.xpath("//*[@id='resizable']/div[3]");
    private static final By txtDroppedDiv = By.xpath("//*[@id='droppable']/p");
    private static final By pPrompt = By.xpath("//p[@id='demo']");

    public AutomationPracticeSitePage(WebDriver driver)
    {
        this.driver = driver;
        pageCache = new PageCache(this.driver);
    }

    public void fillForm()
    {
        driver.findElement(txtName).sendKeys("Alisha");
        driver.findElement(txtEmail).sendKeys("test123@test.com");
        driver.findElement(txtPhone).sendKeys("1234567890");
        driver.findElement(txtAddress).sendKeys("i don't know anymore but i should right LOL");
        driver.findElement(radioBtnFemale).click();
        driver.findElement(By.id("friday")).click();

        //select dropdown
        Select country = new Select(driver.findElement(ddCountry));
        country.selectByValue("india");

        //multi select dropdown
        Select colors = new Select(driver.findElement(multiSelectDdColors));
        colors.selectByValue("red");
        colors.selectByValue("white");

        //select date
        driver.findElement(txtDate).click();
        driver.findElement(dayCal).click();
    }

    public void iframeTest()
    {
        //scroll to element view
        WebElement frame = driver.findElement(frameForm);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", frame);

        driver.switchTo().frame(frameFormName);
        driver.findElement(txtFrameName).sendKeys("Alisha");

        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(radioBtnFrameFemale)).click().perform();
        driver.findElement(txtFrameDate).sendKeys("07/14/2023");

        //select dropdown
        Select job = new Select(driver.findElement(ddJob));
        job.selectByVisibleText("QA Engineer");

        //take screenshot of the frame form filled
        pageCache.getScreenshots().takeElementScreenshot(frameFormTable, "frame_elements_pic");

        driver.findElement(btnFrameSubmit).submit();

        //switch to parent frame
        driver.switchTo().defaultContent();

    }


    public String searchWiki()
    {

        String titleChildWindow = null;

        //get current window handle
        String parentWindow = driver.getWindowHandle();

        driver.findElement(txtWiki).clear();
        driver.findElement(txtWiki).sendKeys("king the land");
        driver.findElement(btnWikiSearch).click();

        //select 1st search result
        driver.findElement(searchResults).click();

        //link opens in new window -> switch to it
        Set<String> childWindows = driver.getWindowHandles();
        Iterator<String> i = childWindows.iterator();

        while(i.hasNext())
        {
            String childWindow = i.next();
            if(!parentWindow.equalsIgnoreCase(childWindow))
            {
                driver.switchTo().window(childWindow);
                titleChildWindow = driver.getTitle();
                driver.close();
            }

            driver.switchTo().window(parentWindow);
        }

      return titleChildWindow;

    }


    public String jsAlerts(String name)
    {
        //handle alert
        driver.findElement(btnAlert).click();
        pageCache.getUtilities().handleAlerts(null);

        //handle confirmation alert
        driver.findElement(btnConfirmBox).click();
        pageCache.getUtilities().handleAlerts(null);

        //handle prompts
        driver.findElement(btnPrompt).click();
        pageCache.getUtilities().handlePrompts(name, null);

        //get text after prompt accept
        return driver.findElement(pPrompt).getText();
    }


    public String doubleClickBtnCopyText()
    {
        actions.doubleClick(driver.findElement(btnCopyText)).perform();
        return driver.findElement(txtField1).getText();
    }


    public String dragAndDrop()
    {
        pageCache.getUtilities().scrollToElement(dragDiv);
        pageCache.getUtilities().dragAndDropElement(dragDiv, dropDiv);
        return driver.findElement(txtDroppedDiv).getText();
    }


    public void resizeElement()
    {
        pageCache.getUtilities().scrollToElement(resizeDiv);
        pageCache.getUtilities().resizeElement(resizeDiv);
        pageCache.getScreenshots().takePageScreenshot("test_resize_element");
    }

}
