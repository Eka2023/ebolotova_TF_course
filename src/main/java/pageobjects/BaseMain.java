package pageobjects;

import org.openqa.selenium.*;
import org.testng.Assert;

public class BaseMain {

    WebDriver driver;
    String baseURL = "https://test.my-fork.com/";

    public BaseMain(WebDriver dr) {
        this.driver = dr;

    }

    public String getBaseURL() {
        driver.get(baseURL);
        return baseURL;
    }

    public WebElement pageElement(By element) {
        return driver.findElement(element);
    }

    public void openNewWindowTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void scrollingPage(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")", "");

    }

    public void assertIfElementIsDisplayed(By element) {
        Assert.assertTrue(driver.findElement(element).isDisplayed());
    }

    public void assertIfElementsAreEqual(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    public void assertIfElementIsSelected(By element) {
        Assert.assertTrue(driver.findElement(element).isSelected());
    }

}
