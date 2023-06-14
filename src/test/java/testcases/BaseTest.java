package testcases;

import net.bytebuddy.utility.nullability.AlwaysNull;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageobjects.HomePage;
import pageobjects.SignInPage;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;

    @BeforeMethod
    public void openDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        homePage.getURL();
        waitForVisibilityOf(homePage.getSignInBtn(),10);
        signInPage = new SignInPage(driver);
    }

//    @AfterTest
//    public void quitDriver() {
//        driver.quit();
//    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
    }



    public void wait(ExpectedCondition<WebElement> condition, Integer timeOut){
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

}
