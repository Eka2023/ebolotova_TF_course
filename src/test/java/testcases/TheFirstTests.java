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
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TheFirstTests {
    WebDriver driver;

    By signInButton = By.xpath("//div[text()='Sign In']");
    By emailInputField = By.xpath("//input[@id='email']");
    By passwordInputField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[@type='submit']");
    By checkBoxRememberMe = By.xpath("//input[@id='auth-page-remember-me']");
    By errorAboutIncorrectEmail = By.xpath("//p[text()='Error: email is incorrect']");
    By errorAboutEmptyField = By.xpath("//p[text()='Error: fields are empty']");

    By errorAboutWrongCredentials = By.xpath("//p[text()='Error: credentials you provided are incorrect. Please try again. ']");

    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://test.my-fork.com/");
        //Open Sign In page
        driver.findElement(signInButton).click();
        Thread.sleep(2000);
    }

    @Test
    public void validateEmailPasswordFieldAndLoginButtonAreDisplayed() {

        boolean emailFieldIsDisplayed = driver.findElement(emailInputField).isDisplayed();
        boolean passwordFieldIsDisplayed = driver.findElement(passwordInputField).isDisplayed();
        boolean loginButtonIsDisplayed = driver.findElement(loginButton).isDisplayed();

        Assert.assertTrue(emailFieldIsDisplayed);
        Assert.assertTrue(passwordFieldIsDisplayed);
        Assert.assertTrue(loginButtonIsDisplayed);
    }

    @Test
    public void checkboxRememberMeIsSelected() {

        boolean rememberMeCheckBoxIsSelected = driver.findElement(checkBoxRememberMe).isSelected();

        Assert.assertTrue(rememberMeCheckBoxIsSelected);

    }

    @Test
    public void enteringWrongEmailTest() {

        driver.findElement(emailInputField).sendKeys("bolotova");
        driver.findElement(passwordInputField).sendKeys("password");
        driver.findElement(loginButton).click();
        waitForVisibilityOf(errorAboutIncorrectEmail, 5);
        WebElement errorMessage = driver.findElement(errorAboutIncorrectEmail);
        boolean actualErrorMessageIsEnabled = errorMessage.isDisplayed();

        String actualErrorMessage = errorMessage.getText();
        Assert.assertTrue(actualErrorMessageIsEnabled);
        Assert.assertEquals(actualErrorMessage, "Error: email is incorrect");

    }

    @Test
    public void enteringEmptyFieldTest() {

        driver.findElement(emailInputField).sendKeys("bolotova.katya@gmail.com");
        driver.findElement(passwordInputField).sendKeys("");
        driver.findElement(loginButton).click();
        waitForVisibilityOf(errorAboutEmptyField, 5);
        WebElement errorMessage = driver.findElement(errorAboutEmptyField);
        boolean actualErrorMessageIsEnabled = errorMessage.isDisplayed();
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessageIsEnabled);
        Assert.assertEquals(actualErrorMessage, "Error: fields are empty");

    }

    @Test
    @Ignore
    public void wrongCredentialsTest() throws InterruptedException {

        driver.findElement(emailInputField).sendKeys("bolotova.katya@gmail.com");
        driver.findElement(passwordInputField).sendKeys("password");
        driver.findElement(loginButton).click();
        //Thread.sleep(1000);
waitForVisibilityOf(errorAboutWrongCredentials, 5);
        WebElement errorMessage = driver.findElement(errorAboutWrongCredentials);
        boolean actualErrorMessageIsEnabled = errorMessage.isEnabled();
        //Thread.sleep(3000);
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessageIsEnabled);
        Assert.assertEquals(actualErrorMessage, "Error: credentials you provided are incorrect. Please try again. ");

    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }

    private void wait(ExpectedCondition<WebElement> condition, Integer timeOut) {
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
