package testcases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomePage;
import pageobjects.SignInPage;
import pageobjects.SignUpPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    SignUpPage signUpPage;

    @BeforeMethod(groups = {"high"})
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        homePage = new HomePage(driver);
        homePage.getBaseURL();
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);

        /**
         *         This example slows down tests in two times:
         *         DevTools devTools = ((ChromeDriver) driver).getDevTools();
         *         devTools.createSession();
         *         devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
         *         devTools.send(Network.emulateNetworkConditions(false, 1000, 10000, 10000, Optional.of(ConnectionType.CELLULAR3G)));
         */

    }

    @AfterMethod(groups = {"high"})
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void wait(ExpectedCondition<WebElement> condition, Integer timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(condition);
    }

    protected void waitForVisibilityOf(By locator, Integer timeOutInSeconds) {
        try {
            wait(ExpectedConditions.visibilityOfElementLocated(locator),
                    timeOutInSeconds);
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException - -> Element not found");
        }
    }

    protected void switchToWindow(int tab) {
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabHandler.get(tab));
    }

    protected int getQuantityOfOpenedTabs() {
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        return tabHandler.size();
    }

    protected void refreshWindow() {
        driver.navigate().refresh();
    }

    protected void navigateToAnotherURL(String url) {
        driver.navigate().to(url);
    }


    protected String getCurrentURL() {
        return driver.getCurrentUrl();

    }

    protected String getTitle() {
        return driver.getTitle();
    }

    protected void openNewWindowTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    protected void scrollingPage(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")", "");

    }

    protected void assertEquality(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    protected void assertEquality(int actual, int expected) {
        Assert.assertEquals(actual, expected);
    }


}
