package testcases;

import org.testng.annotations.Test;

public class ValidationTests extends BaseTest {
    @Test(priority = 2, groups = {"high"})
    public void validateSignInAndSignUpButtonsPresented() {
        homePage.checkSignUpBtnIsDisplayed();
        homePage.checkSignInBtnIsDisplayed();
    }

    @Test(priority = 1, groups = {"high"})
    public void validateEmailPasswordFieldAndLoginButtonAreDisplayed() {
        homePage.clickSignInBtn();
        signInPage.checkEmailInputIsDisplayed();
        signInPage.checkPasswordInputIsDisplayed();
        signInPage.checkLoginInputIsDisplayed();
    }

    @Test(priority = 3, groups = {"low"})
    public void validationThatCheckboxRememberMeIsSelected() {
        homePage.clickSignInBtn();
        signInPage.checkThatCheckBoxRememberMeIsSelected();
    }
}
