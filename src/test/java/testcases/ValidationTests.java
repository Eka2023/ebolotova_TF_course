package testcases;

import org.testng.annotations.Test;

public class ValidationTests extends BaseTest {
    @Test(priority = 2, groups = {"high"})
    public void validateSignInAndSignUpButtonsPresented() {
        homePage.assertIfElementIsDisplayed(homePage.getSignInButton());
        homePage.assertIfElementIsDisplayed(homePage.getSignUpButton());
    }

    @Test(priority = 1, groups = {"high"})
    public void validateEmailPasswordFieldAndLoginButtonAreDisplayed() {
        homePage.clickSignInBtn();
        signInPage.assertIfElementIsDisplayed(signInPage.getEmailInputField());
        signInPage.assertIfElementIsDisplayed(signInPage.getPasswordInputField());
        signInPage.assertIfElementIsDisplayed(signInPage.getLoginButton());
    }

    @Test(priority = 3, groups = {"low"})
    public void validationThatCheckboxRememberMeIsSelected() {
        homePage.clickSignInBtn();
        signInPage.assertIfElementIsSelected(signInPage.getCheckBoxRememberMe());
    }
}
