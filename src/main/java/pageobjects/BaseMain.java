package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.testng.FileAssert.fail;

public class BaseMain {

    public WebDriver driver;
    Logger logger;
    String baseURL = "https://test.my-fork.com/";
    SoftAssert softAssert = new SoftAssert();

    public BaseMain(WebDriver dr, Logger log) {
        this.driver = dr;
        this.logger = log;
    }

    public String getBaseURL() {
        driver.get(baseURL);
        return baseURL;
    }

    public WebElement pageElement(By element) {
        return driver.findElement(element);
    }

    public void navigationViaBrowserBack() {
        driver.navigate().back();
        logger.info("Browser navigate to previous page");
    }

    public void checkElementIsDisplayed(By element, String elementName, boolean value) {
        Assert.assertEquals(driver.findElement(element).isDisplayed(), value);
        logger.info("Element " + elementName + " is displayed");
    }

    public boolean checkElementIsNotPresent(By element) {
        try {
            driver.findElement(element);
            fail("Element is not presented");
            return false;
        } catch (NoSuchElementException ex) {
            return true;
        }
    }

    public void clickElement(By element, String elementName) {
        driver.findElement(element).click();
        logger.info("Element " + elementName + " was successfully clicked");

    }

    public void clickElement(WebElement element, String elementName) {
        element.click();
        logger.info("Element " + elementName + " was successfully clicked");
    }

    public Logger getLogger() {
        return logger;
    }

    public void typeInformation(By element, String elementName, String text) {
        driver.findElement(element).sendKeys(text);
        logger.info("Text in " + elementName + " was successfully entered");
    }

    public void getListSize() {
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Page title is " + title);
        return title;
    }

    public void validateWithAssertEqual(String actual, String expected, String... message) {
        try {
            Assert.assertEquals(actual, expected);
            logger.info("Actual String value is " + actual + " and it's equal to " + expected);
        } catch (Exception e) {
            System.out.println(message);
        }
    }

    public void validateWithAssertEqual(double actual, double expected, String... message) {
        try {
            Assert.assertEquals(actual, expected);
            logger.info("Actual Double value is " + actual + " and it's equal to " + expected);
        } catch (Exception e) {
            System.out.println(message);
        }
    }

    public void validateWithAssertEqual(int actual, int expected, String... message) {
        try {
            Assert.assertEquals(actual, expected);
            logger.info("Actual Integer value is " + actual + " and it's equal to " + expected);
        } catch (Exception e) {
            System.out.println(message);
        }
    }

    public void validateWithAssertEqual(List<String> actual, List<String> expected, String... message) {
        try {
            Assert.assertEquals(actual, expected);
            logger.info("Actual List values are " + actual + " and it's equal to " + expected);
        } catch (Exception e) {
            System.out.println(message);
        }
    }

    public void assertElementIsSelected(By element, String elementName) {
        Assert.assertTrue(driver.findElement(element).isSelected());
        logger.info("Element "+elementName+" is selected");
    }

//    public void assertActualAndExpectedList(List<String> actual, List<String> expected) {
//        Assert.assertEquals(actual, expected);
//    }

    public void softAssertActualAndExpectedList(List<String> actual, List<String> expected) {
        softAssert.assertEquals(actual, expected);
        softAssert.assertAll();
        logger.info("Soft assert for Lists is passed");
    }

    public void softAssertActualAndExpectedListInt(List<Integer> actual, List<Integer> expected) {
        softAssert.assertEquals(actual, expected);
        softAssert.assertAll();
        logger.info("Soft assert for Lists is passed");
    }

    protected void switchToWindowFromBaseMain(int tab) {
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabHandler.get(tab));
        logger.info("Tab was changed to "+tab);
    }

    public void softAssertIfElementsAreEqual(String actual, String expected, String... message) {
        try {
            softAssert.assertEquals(actual, expected);
            softAssert.assertAll();
            logger.info("Soft assert for Strings is passed");
        } catch (Exception e) {
            System.out.println(message.toString());
        }
    }

    public void softAssertIfElementsAreEqual(int actual, int expected, String... message) {
        try {
            softAssert.assertEquals(actual, expected);
            softAssert.assertAll();
            logger.info("Soft assert for Integers is passed");
        } catch (Exception e) {
            System.out.println(message.toString());
        }
    }

    public void softAssertIfElementIsDisplayed_boolean(By element, String elementName, boolean value) {
        softAssert.assertEquals(driver.findElement(element).isDisplayed(), value);
        softAssert.assertAll();
        logger.info("Soft assert. Element"+elementName +" is displayed");
    }


    public List<String> getURLsFromLinkElements() {
        List<WebElement> linkElements = driver.findElements(By.xpath("//a"));
        //List<WebElement> linkElements = driver.findElements(By.xpath("//a")); //collect all links from page
        List<String> collectedURLs = new ArrayList<>();
        for (WebElement linkElement : linkElements) {//this loop takes each element from LinkElements and takes href attribute (since each item is a link it will have it)
            String attributeValue = linkElement.getAttribute("href");
            if(attributeValue!=null){
                collectedURLs.add(attributeValue);
            }
        }
        return collectedURLs;
    }

    public List<Integer> verifyLinkActive(){
        List<Integer> codes = new ArrayList<>(); //this List will have codes that each URL will return
        List<String> collectedURLs = getURLsFromLinkElements(); //this List will have actual URLs
        for(String collectedURL: collectedURLs) { // this loop will execute actions below to fill up codes List with actual values
            System.out.println("Starting verification of " + collectedURL);
            try { //making sure that exception won't fail the execution to carry execution on
                URL url = new URL(collectedURL); //initializes URL instance for provided URL
                HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection(); //initialize HTTP Connection
                httpURLConnect.setConnectTimeout(3000); //set timeout value
                httpURLConnect.connect(); //establish connection to provided URL to execute a call
                int resultCode = httpURLConnect.getResponseCode(); //providing actual value into a value of a variable to be returned
                System.out.println(resultCode);
                codes.add(resultCode); //writing the result in resultCode array to return it
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        logger.info("List of links on the page");
        return codes; //a return of a list with codes for further verification
    }

}


