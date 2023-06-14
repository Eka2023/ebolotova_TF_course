package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TheFirstTests {

    //parameters (value)
    WebDriver driver;
    String baseURL = "https://test.my-fork.com/";
    String correctEmail = "bolotova.katya@gmail.com";
    String correctPassword = "password";
    String incorrectEmail = "bolotova";
    String emptyPassword = "";

    //locators
    By signUpButton = By.xpath("//div[@id='sign-up-button']");
    //By signInButton = By.xpath("//div[@id='log-in-button']");
    By signInButton = By.xpath("//div[text()='Sign In']");
    By emailInputField = By.xpath("//input[@id='email']");
    By passwordInputField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[@type='submit']");
    By checkBoxRememberMe = By.xpath("//input[@id='auth-page-remember-me']");
    By errorAboutIncorrectEmail = By.xpath("//p[text()='Error: email is incorrect']");
    By errorAboutEmptyField = By.xpath("//p[text()='Error: fields are empty']");

    By errorAboutWrongCredentials = By.xpath("//p[text()='Error: credentials you provided are incorrect. Please try again. ']");

    @BeforeTest
    public void openDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(baseURL);
        Thread.sleep(1000);
    }
    @Test
    public void validateSignInAndSignUpButtonsPresented() {
        //driver.get(baseURL);
        boolean singInBtnIsPresented = driver.findElement(signInButton).isDisplayed();
        boolean singUpBtnIsPresented = driver.findElement(signUpButton).isDisplayed();
        Assert.assertTrue(singInBtnIsPresented);
        Assert.assertTrue(singUpBtnIsPresented);

    }

    @Test
    public void validateEmailPasswordFieldAndLoginButtonAreDisplayed() throws InterruptedException{
//        driver.get(baseURL);
//        Thread.sleep(1000);
        driver.findElement(signInButton).click();
        boolean emailFieldIsDisplayed = driver.findElement(emailInputField).isDisplayed();
        boolean passwordFieldIsDisplayed = driver.findElement(passwordInputField).isDisplayed();
        boolean loginButtonIsDisplayed = driver.findElement(loginButton).isDisplayed();

        Assert.assertTrue(emailFieldIsDisplayed);
        Assert.assertTrue(passwordFieldIsDisplayed);
        Assert.assertTrue(loginButtonIsDisplayed);
    }

    @Test
    public void checkboxRememberMeIsSelected() throws InterruptedException{
//        driver.get(baseURL);
//        Thread.sleep(1000);
        driver.findElement(signInButton).click();
        boolean rememberMeCheckBoxIsSelected = driver.findElement(checkBoxRememberMe).isSelected();

        Assert.assertTrue(rememberMeCheckBoxIsSelected);
    }

    @Test
    public void enteringWrongEmailTest() throws InterruptedException {
//        driver.get(baseURL);
//        Thread.sleep(1000);
        driver.findElement(signInButton).click();
        driver.findElement(emailInputField).sendKeys(incorrectEmail);
        driver.findElement(passwordInputField).sendKeys(correctPassword);
        driver.findElement(loginButton).click();
        Thread.sleep(1000);
        WebElement errorMessage = driver.findElement(errorAboutIncorrectEmail);
        boolean actualErrorMessageIsEnabled = errorMessage.isEnabled();
        //boolean actualErrorMessageIsEnabled = errorMessage.isDisplayed();
        Thread.sleep(3000);
        String actualErrorMessage = errorMessage.getText();
        Assert.assertTrue(actualErrorMessageIsEnabled);
        Assert.assertEquals(actualErrorMessage, "Error: email is incorrect");

    }

    @Test
    public void enteringEmptyFieldTest() throws InterruptedException {
//        driver.get(baseURL);
//        Thread.sleep(1000);
        driver.findElement(signInButton).click();
        driver.findElement(emailInputField).sendKeys(correctEmail);
        driver.findElement(passwordInputField).sendKeys(emptyPassword);
        driver.findElement(loginButton).click();
        Thread.sleep(1000);

        WebElement errorMessage = driver.findElement(errorAboutEmptyField);
        boolean actualErrorMessageIsEnabled = errorMessage.isEnabled();
        Thread.sleep(3000);
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessageIsEnabled);
        Assert.assertEquals(actualErrorMessage, "Error: fields are empty");
    }

    @Test
    @Ignore
    public void wrongCredentialsTest() throws InterruptedException {
//        driver.get(baseURL);
//        Thread.sleep(1000);
        driver.findElement(signInButton).click();
        driver.findElement(emailInputField).sendKeys(correctEmail);
        driver.findElement(passwordInputField).sendKeys(correctPassword);
        driver.findElement(loginButton).click();
        Thread.sleep(1000);

        WebElement errorMessage = driver.findElement(errorAboutWrongCredentials);
        boolean actualErrorMessageIsEnabled = errorMessage.isEnabled();
        Thread.sleep(3000);
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessageIsEnabled);
        Assert.assertEquals(actualErrorMessage, "Error: credentials you provided are incorrect. Please try again. ");
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }

}
