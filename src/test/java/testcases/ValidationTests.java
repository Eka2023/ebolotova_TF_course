package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.SignInPage;

public class ValidationTests extends BaseTest{

    @Test
    public void validateSignInAndSignUpButtonsPresented() {
        homePage.assertIfElementIsDisplayedOnHomePage(homePage.getSignInButton());
        homePage.assertIfElementIsDisplayedOnHomePage(homePage.getSignUpButton());
    }

    @Test
    public void validateEmailPasswordFieldAndLoginButtonAreDisplayed() {
        homePage.clickSignInBtn();
        signInPage.assertIfElementIsDisplayedOnSignInPage(signInPage.getEmailInputField());
        signInPage.assertIfElementIsDisplayedOnSignInPage(signInPage.getPasswordInputField());
        signInPage.assertIfElementIsDisplayedOnSignInPage(signInPage.getLoginButton());
    }

    @Test
    public void validationThatCheckboxRememberMeIsSelected() {
        homePage.clickSignInBtn();
         signInPage.assertIfElementIsSelectedOnSignInPage(signInPage.getCheckBoxRememberMe());
    }
}
