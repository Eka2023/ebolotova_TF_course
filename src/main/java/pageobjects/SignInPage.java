package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class SignInPage extends BaseMain {

    public SignInPage(WebDriver dr) {
        super(dr);
    }

    String correctEmail = "bolotova.katya@gmail.com";
    String correctPassword = "password";
    String incorrectEmail = "bolotova";
    String emptyPassword = "";

    By emailInputField = By.xpath("//input[@id='email']");
    By passwordInputField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[@type='submit']");
    By checkBoxRememberMe = By.xpath("//input[@id='auth-page-remember-me']");
    By errorAboutIncorrectEmail = By.xpath("//p[text()='Error: email is incorrect']");
    By errorAboutEmptyField = By.xpath("//p[text()='Error: fields are empty']");
    By errorAboutWrongCredentials = By.xpath("//p[text()='Error: credentials you provided are incorrect. Please try again. ']");


    public void fillTheSignFormWithIncorrectEmail() {
        driver.findElement(emailInputField).sendKeys(incorrectEmail);
        driver.findElement(passwordInputField).sendKeys(correctPassword);
        driver.findElement(loginButton).click();
    }


    public void fillTheSignFormWithCorrectData() {
        driver.findElement(emailInputField).sendKeys(correctEmail);
        driver.findElement(passwordInputField).sendKeys(correctPassword);
        driver.findElement(loginButton).click();
    }

    public void fillTheSignFormWithEmptyPassword() {
        driver.findElement(emailInputField).sendKeys(correctEmail);
        driver.findElement(passwordInputField).sendKeys(emptyPassword);
        driver.findElement(loginButton).click();
    }

    public WebElement signInPageElement(By element){
        return driver.findElement(element);
    }


    public boolean signInPageElementSelected(By element){
        return driver.findElement(element).isSelected();
    }

    public boolean signInPageElementDisplayed(By element){
        return driver.findElement(element).isDisplayed();
    }

}
