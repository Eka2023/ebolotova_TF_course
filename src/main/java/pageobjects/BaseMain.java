package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BaseMain {

    WebDriver driver;
    String baseURL = "https://test.my-fork.com/";

    public BaseMain(WebDriver dr) {
        this.driver = dr;
    }

    public void getURL() {
        driver.get(baseURL);
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
