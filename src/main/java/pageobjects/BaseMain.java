package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

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

    public void assertIfElementIsDisplayed(By element) {
        Assert.assertTrue(driver.findElement(element).isDisplayed());
    }

    public void assertIfElementIsDisplayed_boolean(By element, boolean value) {
        Assert.assertEquals(driver.findElement(element).isDisplayed(), value);
    }

    public void assertIfElementsAreEqual(String actual, String expected, String... message) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            System.out.println(message);
        }
    }

    public void assertIfElementsAreEqual(int actual, int expected, String... message) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            System.out.println(message);
        }
    }

    public void assertIfElementIsSelected(By element) {
        Assert.assertTrue(driver.findElement(element).isSelected());
    }

    public void assertActualAndExpectedList(List<String> actual, List<String> expected) {
        Assert.assertEquals(expected, actual);
    }

    public SoftAssert softAssert() {
        SoftAssert softAssert = new SoftAssert();
        return softAssert;
    }
    public void softAssertActualAndExpectedList(List<String> actual, List<String> expected) {
        SoftAssert softAssert = softAssert();
        softAssert.assertEquals(actual, expected);
    }

    public void softAssertIfElementsAreEqual(String actual, String expected, String... message) {
        SoftAssert softAssert = softAssert();
        try {
            softAssert.assertEquals(actual, expected);
        } catch (Exception e) {
            System.out.println(message.toString());
        }
    }
    public void softAssertIfElementsAreEqual(int actual, int expected, String... message) {
        SoftAssert softAssert = softAssert();
        try {
            softAssert.assertEquals(actual, expected);
        } catch (Exception e) {
            System.out.println(message.toString());
        }
    }

    public void softAssertIfElementIsDisplayed_boolean(By element, boolean value) {
        SoftAssert softAssert = softAssert();
        softAssert.assertEquals(driver.findElement(element).isDisplayed(), value);
    }

    public void softAssertAll() {
        SoftAssert softAssert = softAssert();
        softAssert.assertAll();
    }

}
