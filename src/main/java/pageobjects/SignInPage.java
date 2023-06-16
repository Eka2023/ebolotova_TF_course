package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SignInPage extends BaseMain {
    public SignInPage(WebDriver dr) {
        super(dr);
    }

    String correctEmail = "bolotova.katya@gmail.com";
    String correctPassword = "password";
    String incorrectEmail = "bolotova";
    String emptyPassword = "";

    @FindBy(id = "email")
    WebElement emailInputField;

    @FindBy(id= "password")
    WebElement passwordInputField;

    @FindBy(xpath =  "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(id = "auth-page-remember-me")
    WebElement checkBoxRememberMe ;

    @FindBy(xpath = "//p[text()='Error: email is incorrect']")
    WebElement errorAboutIncorrectEmail;

    @FindBy(xpath = "//p[text()='Error: fields are empty']")
    WebElement errorAboutEmptyField;

    @FindBy(xpath = "//p[text()='Error: credentials you provided are incorrect. Please try again. ']")
    WebElement errorAboutWrongCredentials;


    public void fillTheSignFormWithIncorrectEmail() {
        emailInputField.sendKeys(incorrectEmail);
        passwordInputField.sendKeys(correctPassword);
        loginButton.click();
    }

    public void fillTheSignFormWithCorrectData() {
        emailInputField.sendKeys(correctEmail);
        passwordInputField.sendKeys(correctPassword);
        loginButton.click();
    }

    public void fillTheSignFormWithEmptyPassword() {
        emailInputField.sendKeys(correctEmail);
        passwordInputField.sendKeys(emptyPassword);
        loginButton.click();
    }
}
