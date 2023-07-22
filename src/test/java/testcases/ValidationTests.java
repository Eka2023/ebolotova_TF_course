package testcases;

import org.testng.annotations.Test;

public class ValidationTests extends BaseTest {
    @Test(priority = 2, groups = {"high"})
    public void validateSignInAndSignUpButtonsPresented() {
        homePage.checkIfElementIsDisplayedOrNot(homePage.getSignInButton(), true);
        homePage.checkIfElementIsDisplayedOrNot(homePage.getSignUpButton(), true);
    }

    @Test(priority = 1, groups = {"high"})
    public void validateEmailPasswordFieldAndLoginButtonAreDisplayed() {
        homePage.clickSignInBtn();
        signInPage.checkIfElementIsDisplayedOrNot(signInPage.getEmailInputField(), true);
        signInPage.checkIfElementIsDisplayedOrNot(signInPage.getPasswordInputField(), true);
        signInPage.checkIfElementIsDisplayedOrNot(signInPage.getLoginButton(), true);
    }

    @Test(priority = 3, groups = {"low"})
    public void validationThatCheckboxRememberMeIsSelected() {
        homePage.clickSignInBtn();
        signInPage.assertIfElementIsSelected(signInPage.getCheckBoxRememberMe());
    }
}
