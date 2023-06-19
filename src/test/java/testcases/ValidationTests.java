package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.SignInPage;

public class ValidationTests extends BaseTest{

    @Test
    public void validateSignInAndSignUpButtonsPresented() {
        boolean singInBtnIsPresented = homePage.homePageElementDisplayed(homePage.getSignInButton());
        boolean singUpBtnIsPresented = homePage.homePageElementDisplayed(homePage.getSignUpBtn());

        Assert.assertTrue(singInBtnIsPresented);
        Assert.assertTrue(singUpBtnIsPresented);
    }

    @Test
    public void validateEmailPasswordFieldAndLoginButtonAreDisplayed() {
        homePage.clickSignInBtn();
        SignInPage signInPage = new SignInPage(driver);
        boolean emailFieldIsDisplayed = signInPage.signInPageElementDisplayed(signInPage.getEmailInputField());
        boolean passwordFieldIsDisplayed = signInPage.signInPageElementDisplayed(signInPage.getPasswordInputField());
        boolean loginButtonIsDisplayed = signInPage.signInPageElementDisplayed(signInPage.getLoginButton());

        Assert.assertTrue(emailFieldIsDisplayed);
        Assert.assertTrue(passwordFieldIsDisplayed);
        Assert.assertTrue(loginButtonIsDisplayed);
    }

    @Test
    public void validationThatCheckboxRememberMeIsSelected() {
        homePage.clickSignInBtn();
        boolean rememberMeCheckBoxIsSelected = signInPage.signInPageElementSelected(signInPage.getCheckBoxRememberMe());

        Assert.assertTrue(rememberMeCheckBoxIsSelected);
    }
}
