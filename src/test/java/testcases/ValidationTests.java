package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.SignInPage;

public class ValidationTests extends BaseTest{
    @Test
    public void validateSignInAndSignUpButtonsPresented() {
        boolean singInBtnIsPresented = homePage.homePageElement(homePage.getSignInButton()).isDisplayed();
        boolean singUpBtnIsPresented = homePage.homePageElement(homePage.getSignUpButton()).isDisplayed();

        Assert.assertTrue(singInBtnIsPresented);
        Assert.assertTrue(singUpBtnIsPresented);
    }

    @Test
    public void validateEmailPasswordFieldAndLoginButtonAreDisplayed() {
        homePage.clickSignInBtn();
        boolean emailFieldIsDisplayed = signInPage.signInPageElement(signInPage.getEmailInputField()).isDisplayed();
        boolean passwordFieldIsDisplayed = signInPage.signInPageElement(signInPage.getPasswordInputField()).isDisplayed();
        boolean loginButtonIsDisplayed = signInPage.signInPageElement(signInPage.getLoginButton()).isDisplayed();

        Assert.assertTrue(emailFieldIsDisplayed);
        Assert.assertTrue(passwordFieldIsDisplayed);
        Assert.assertTrue(loginButtonIsDisplayed);
    }

    @Test
    public void validationThatCheckboxRememberMeIsSelected() {
        homePage.clickSignInBtn();
        boolean rememberMeCheckBoxIsSelected = signInPage.signInPageElement(signInPage.getCheckBoxRememberMe()).isSelected();

        Assert.assertTrue(rememberMeCheckBoxIsSelected);
    }
}
