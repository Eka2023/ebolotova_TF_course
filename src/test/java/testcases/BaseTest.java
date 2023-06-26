package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomePage;
import pageobjects.SignInPage;
import pageobjects.SignUpPage;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    SignUpPage signUpPage;

    @BeforeMethod
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        homePage.getURL();
        waitForVisibilityOf(homePage.getSignInButton(), 10);
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
    }

//    @AfterTest
//    public void quitDriver() {
//        driver.quit();
//    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
    }


    public void wait(ExpectedCondition<WebElement> condition, Integer timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(condition);
    }

    protected void waitForVisibilityOf(By locator, Integer timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                wait(ExpectedConditions.visibilityOfElementLocated(locator),
                        timeOutInSeconds);
            } catch (StaleElementReferenceException ignored) {
            }
            attempts++;
        }
    }

    protected void waitForVisibilityOf_test(By locator) {
        int attempts = 0;
        var wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        while (attempts < 2) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (StaleElementReferenceException ignored) {
            }
            attempts++;
        }

    }
}
