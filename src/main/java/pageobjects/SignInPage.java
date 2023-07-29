package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.TestUserData;

@Getter
public class SignInPage extends BaseMain {

    TestUserData userData;

    By emailInputField = By.xpath("//input[@id='email']");
    By passwordInputField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[@type='submit']");
    By checkBoxRememberMe = By.xpath("//input[@id='auth-page-remember-me']");

    By errorMessage = By.xpath("//p[contains(text(), 'Error') and @class  = '']");

    public SignInPage(WebDriver dr) {
        super(dr);
    }

    public void checkCurrentURL(){
        assertIfElementsAreEqual(driver.getCurrentUrl(), "https://test.my-fork.com/login");
    }

    public void fillInLoginForm(String name, String password){
        driver.findElement(emailInputField).sendKeys(name);
        driver.findElement(passwordInputField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void fillTheSignFormWithIncorrectEmail() {
        driver.findElement(emailInputField).sendKeys(userData.incorrectEmail);
        driver.findElement(passwordInputField).sendKeys(userData.correctPassword);
        driver.findElement(loginButton).click();
    }

    public void fillTheSignFormWithCorrectData() {
        driver.findElement(emailInputField).sendKeys(userData.correctEmail);
        driver.findElement(passwordInputField).sendKeys(userData.correctPassword);
        driver.findElement(loginButton).click();
    }

    public void fillTheSignFormWithEmptyPassword() {
        driver.findElement(emailInputField).sendKeys(userData.correctEmail);
        driver.findElement(passwordInputField).sendKeys(userData.emptyPassword);
        driver.findElement(loginButton).click();
    }

    public String elementGetText(By element) {
        return pageElement(element).getText();
    }

    public void checkTitle() {
        assertIfElementsAreEqual(getPageTitle(), "Sign in", "Title is not consistent");
    }
    public void checkEmailInputIsDisplayed(){
        checkElementIsDisplayed(getEmailInputField(), true);
    }
    public void checkPasswordInputIsDisplayed(){
        checkElementIsDisplayed(getPasswordInputField(), true);
    }

    public void checkLoginInputIsDisplayed(){
        checkElementIsDisplayed(getLoginButton(), true);
    }

    public void checkThatCheckBoxRememberMeIsSelected() {
        assertElementIsSelected(getCheckBoxRememberMe());

    }
    public void checkThatErrorMessageIsDisplayed() {
        checkElementIsDisplayed(getErrorMessage(), true);
    }
    public void checkErrorMessageAboutIncorrectEmail(){
        assertIfElementsAreEqual(elementGetText(getErrorMessage()), "Error: email is incorrect");
    }
    public void checkErrorMessageAboutEmptyField() {
        assertIfElementsAreEqual(elementGetText(getErrorMessage()), "Error: fields are empty");
    }

    public void checkErrorMessageAboutIncorrectCredentials() {
        assertIfElementsAreEqual(elementGetText(getErrorMessage()), "Error: credentials you provided are incorrect. Please try again. ");
    }


}
