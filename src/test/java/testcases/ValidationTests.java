package testcases;

import org.testng.annotations.Test;

public class ValidationTests extends BaseTest {
    @Test
    public void validateSignInAndSignUpButtonsPresented() {
        homePage.assertIfElementIsDisplayed(homePage.getSignInButton());
        homePage.assertIfElementIsDisplayed(homePage.getSignUpButton());
    }

    @Test
    public void validateEmailPasswordFieldAndLoginButtonAreDisplayed() {
        homePage.clickSignInBtn();
        signInPage.assertIfElementIsDisplayed(signInPage.getEmailInputField());
        signInPage.assertIfElementIsDisplayed(signInPage.getPasswordInputField());
        signInPage.assertIfElementIsDisplayed(signInPage.getLoginButton());
    }

    @Test
    public void validationThatCheckboxRememberMeIsSelected() {
        homePage.clickSignInBtn();
        signInPage.assertIfElementIsSelected(signInPage.getCheckBoxRememberMe());
    }
}
