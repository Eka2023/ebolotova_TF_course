package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

    @FindBy(xpath = "//p[text()='Error: email is incorrect']")
    WebElement errorAboutWrongCredentialsUpdated;

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

    public WebElement signInPageElement(WebElement element) {
        return element;
    }

    public boolean elementIsDisplayedOnSignInPage(WebElement element) {
        boolean actualElement = element.isDisplayed();
        return actualElement;
    }

    public boolean elementIsSelectedOnSignInPage(WebElement element) {
        boolean actualElement = element.isSelected();
        return actualElement;
    }


    public String elementGetText(WebElement element) {
        WebElement message = signInPageElement(element);
        String actualText = message.getText();
        return actualText;
    }

    public void assertIfElementIsDisplayedOnSignInPage(WebElement element) {
        Assert.assertTrue(signInPageElement(element).isDisplayed());
    }

    public void assertIfElementsAreEqualOnSignInPage(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    public void assertIfElementIsSelectedOnSignInPage(WebElement element) {
        Assert.assertTrue(signInPageElement(element).isSelected());
    }

}
