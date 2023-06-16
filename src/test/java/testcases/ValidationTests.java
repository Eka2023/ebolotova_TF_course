package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.SignInPage;

public class ValidationTests extends BaseTest{

    @Test
    public void validateSignInAndSignUpButtonsPresented() {
        boolean singInBtnIsPresented = homePage.getSignInBtn().isDisplayed();
        boolean singUpBtnIsPresented = homePage.getSignUpBtn().isDisplayed();

        Assert.assertTrue(singInBtnIsPresented);
        Assert.assertTrue(singUpBtnIsPresented);
    }

    @Test
    public void validateEmailPasswordFieldAndLoginButtonAreDisplayed() {
        homePage.clickSignInBtn();
        SignInPage signInPage = new SignInPage(driver);
        boolean emailFieldIsDisplayed = signInPage.getEmailInputField().isDisplayed();
        boolean passwordFieldIsDisplayed = signInPage.getPasswordInputField().isDisplayed();
        boolean loginButtonIsDisplayed = signInPage.getLoginButton().isDisplayed();

        Assert.assertTrue(emailFieldIsDisplayed);
        Assert.assertTrue(passwordFieldIsDisplayed);
        Assert.assertTrue(loginButtonIsDisplayed);
    }

    @Test
    public void validationThatCheckboxRememberMeIsSelected() {
        homePage.clickSignInBtn();
        boolean rememberMeCheckBoxIsSelected = signInPage.getCheckBoxRememberMe().isSelected();

        Assert.assertTrue(rememberMeCheckBoxIsSelected);
    }
}
