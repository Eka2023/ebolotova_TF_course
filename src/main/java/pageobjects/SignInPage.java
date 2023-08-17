package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.logging.Logger;

import static utils.TestUserData.*;

@Getter
public class SignInPage extends BaseMain {
    By emailInputField = By.xpath("//input[@id='email']");
    By passwordInputField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[@type='submit']");
    By checkBoxRememberMe = By.xpath("//input[@id='auth-page-remember-me']");

    By errorMessage = By.xpath("//p[contains(text(), 'Error') and @class  = '']");

    public SignInPage(WebDriver dr, Logger log) {
        super(dr, log);
    }

    public void fillInLoginFormForDataProviderAsMethod(String name, String password, String... message) {
        typeInformation(emailInputField, "Email Input Field", name);
        typeInformation(passwordInputField, "Password Input Field", password);
        clickElement(loginButton, "Login Btn");
    }

    public void fillTheSignFormWithIncorrectEmail() {
        typeInformation(emailInputField, "Email Input Field", incorrectEmail);
        typeInformation(passwordInputField, "Password Input Field", correctPassword);
        clickElement(loginButton, "Login Btn");
    }

    public void fillTheSignFormWithCorrectData() {
        typeInformation(emailInputField, "Email Input Field", correctEmail);
        typeInformation(passwordInputField, "Password Input Field", correctPassword);
        clickElement(loginButton, "Login Btn");
    }

    public void fillTheSignFormWithEmptyPassword() {
        typeInformation(emailInputField, "Email Input Field", correctEmail);
        typeInformation(passwordInputField, "Password Input Field", emptyPassword);
        clickElement(loginButton, "Login Btn");
    }


    public void checkCurrentURL() {
        validateWithAssertEqual(driver.getCurrentUrl(), "https://test.my-fork.com/login");
    }


    public String elementGetText(By element) {
        return pageElement(element).getText();
    }

    public void checkTitle() {
        validateWithAssertEqual(getPageTitle(), "Sign in", "Title is not consistent");
    }

    public void checkEmailInputIsDisplayed() {
        checkElementIsDisplayed(getEmailInputField(), "EmailInput", true);
    }

    public void checkPasswordInputIsDisplayed() {
        checkElementIsDisplayed(getPasswordInputField(), "PasswordInput", true);
    }

    public void checkLoginInputIsDisplayed() {
        checkElementIsDisplayed(getLoginButton(), "LoginBtn", true);
    }

    public void checkThatCheckBoxRememberMeIsSelected() {
        assertElementIsSelected(getCheckBoxRememberMe(), "RememberMeCheckBox");

    }

    public void checkThatErrorMessageIsDisplayed() {
        checkElementIsDisplayed(getErrorMessage(), "ErrorMessage", true);
    }

    public void checkErrorMessageAboutIncorrectEmail() {
        validateWithAssertEqual(elementGetText(getErrorMessage()), "Error: email is incorrect");
    }

    public void checkErrorMessageAboutEmptyField() {
        validateWithAssertEqual(elementGetText(getErrorMessage()), "Error: fields are empty");
    }

    public String getErrorMessageText() {
        return elementGetText(getErrorMessage());
    }

    public void checkErrorMessageAboutIncorrectCredentials() {
        validateWithAssertEqual(elementGetText(getErrorMessage()), "Error: credentials you provided are incorrect. Please try again. ");
    }

    public void verificationOfCodesLinkOnSignInPage(){
        List<Integer> actualCodesLinkList = verifyLinkActive();
        SoftAssert softAssert = new SoftAssert();
        for(Integer code : actualCodesLinkList) {
            softAssert.assertEquals(code, (Integer) 200);
        }
        softAssert.assertAll();
    }

    public boolean convertBooleanToString(String value){
        return Boolean.valueOf(value);
    }

    public boolean elementIsDisplayedForCSVDataProviderTest(){
        return driver.findElement(loginButton).isDisplayed();
    }



}
