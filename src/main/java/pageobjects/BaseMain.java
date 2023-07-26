package pageobjects;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.FileAssert.fail;

public class BaseMain {

    public WebDriver driver;
    String baseURL = "https://test.my-fork.com/";
    SoftAssert softAssert = new SoftAssert();

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

    public void navigationViaBrowserBack(){
        driver.navigate().back();
    }
    public void checkIfElementIsDisplayedOrNot(By element, boolean value) {
        Assert.assertEquals(driver.findElement(element).isDisplayed(), value);
    }

    public void checkElementIsNotPresent(By element) {
        try {
            driver.findElement(element);
            fail("Element is not presented");
        } catch (NoSuchElementException ex) {
            /* do nothing, link is not present, assert is passed */
        }
    }

    public void assertIfElementsAreEqual(String actual, String expected, String... message) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            System.out.println(message);
        }
    }

    public void assertIfElementsAreEqual(double actual, double expected, String... message) {
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

    public void softAssertActualAndExpectedList(List<String> actual, List<String> expected) {
        softAssert.assertEquals(actual, expected);
    }

    public void softAssertIfElementsAreEqual(String actual, String expected, String... message) {
        try {
            softAssert.assertEquals(actual, expected);
        } catch (Exception e) {
            System.out.println(message.toString());
        }
    }
    public void softAssertIfElementsAreEqual(int actual, int expected, String... message) {
        try {
            softAssert.assertEquals(actual, expected);
        } catch (Exception e) {
            System.out.println(message.toString());
        }
    }

    public void softAssertIfElementIsDisplayed_boolean(By element, boolean value) {
        softAssert.assertEquals(driver.findElement(element).isDisplayed(), value);
    }

    public void softAssertAll() {
        softAssert.assertAll();
    }

}
