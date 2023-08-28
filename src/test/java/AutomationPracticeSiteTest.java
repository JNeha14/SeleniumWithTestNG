import org.testng.Assert;
import org.testng.annotations.Test;

public class AutomationPracticeSiteTest extends BaseTest
{

    @Test(priority = 0)
    public void testFillForm()
    {
        pageCache.getAutomationPracticeSitePage().fillForm();
    }

    @Test(priority = 1)
    public void testSearchWikiNewWindow()
    {
        var title = pageCache.getAutomationPracticeSitePage().searchWiki();
        Assert.assertEquals(title, "King the Land - Wikipedia", "The title of the child window does not match");
    }

    @Test(priority = 2)
    public void testFillFrameForm()
    {
        pageCache.getAutomationPracticeSitePage().iframeTest();
    }

    @Test(priority = 3)
    public void testCopyTextBtn()
    {
        String expected = pageCache.getAutomationPracticeSitePage().doubleClickBtnCopyText();
        Assert.assertEquals(expected, expected, "Copied text after double click does not match");
        pageCache.getScreenshots().takePageScreenshot("test_copy_text_button_screenshot");
    }

    @Test(priority = 4)
    public void testDragAndDropElements()
    {
        String actualText = pageCache.getAutomationPracticeSitePage().dragAndDrop();
        Assert.assertEquals(actualText, "Dropped!", actualText);
    }

    @Test(priority = 5)
    public void testResizeElement()
    {
        pageCache.getAutomationPracticeSitePage().resizeElement();
    }

    @Test(priority = 6)
    public void testAlerts()
    {
        String name = "Akshay Bendal";
        String promptText = pageCache.getAutomationPracticeSitePage().jsAlerts(name);
        Assert.assertEquals(promptText, "Hello "+ name +"! How are you today?", "Expected prompt text does not match actual text");
    }

}

