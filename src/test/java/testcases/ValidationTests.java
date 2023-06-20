package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.SignInPage;

public class ValidationTests extends BaseTest{

    @Test
    public void validateSignInAndSignUpButtonsPresented() {
        /**  should it be deleted or not?
         homePage.elementIsDisplayedOnHomePage(homePage.getSignInButton());
         homePage.elementIsDisplayedOnHomePage(homePage.getSignUpButton());
         */

        homePage.assertIfElementIsDisplayedOnHomePage(homePage.getSignInButton());
        homePage.assertIfElementIsDisplayedOnHomePage(homePage.getSignUpButton());
    }

    @Test
    public void validateEmailPasswordFieldAndLoginButtonAreDisplayed() {
        homePage.clickSignInBtn();
        /** should it be deleted?
         signInPage.elementIsDisplayedOnSignInPage(signInPage.getEmailInputField());
         signInPage.elementIsDisplayedOnSignInPage(signInPage.getPasswordInputField());
         signInPage.elementIsDisplayedOnSignInPage(signInPage.getLoginButton());
         */

        signInPage.assertIfElementIsDisplayedOnSignInPage(signInPage.getEmailInputField());
        signInPage.assertIfElementIsDisplayedOnSignInPage(signInPage.getPasswordInputField());
        signInPage.assertIfElementIsDisplayedOnSignInPage(signInPage.getLoginButton());
    }

    @Test
    public void validationThatCheckboxRememberMeIsSelected() {
        homePage.clickSignInBtn();
        /** should be deleted?
         signInPage.elementIsSelectedOnSignInPage(signInPage.getCheckBoxRememberMe());
         */

        signInPage.assertIfElementIsSelectedOnSignInPage(signInPage.getCheckBoxRememberMe());
    }
}
