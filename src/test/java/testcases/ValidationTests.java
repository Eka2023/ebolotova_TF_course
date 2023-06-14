package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.SignInPage;

public class ValidationTests extends BaseTest{

    @Test
    public void validateSignInAndSignUpButtonsPresented() {
        boolean singInBtnIsPresented = driver.findElement(homePage.getSignInBtn()).isDisplayed();
        boolean singUpBtnIsPresented = driver.findElement(homePage.getSignUpBtn()).isDisplayed();

        Assert.assertTrue(singInBtnIsPresented);
        Assert.assertTrue(singUpBtnIsPresented);
    }

    @Test
    public void validateEmailPasswordFieldAndLoginButtonAreDisplayed() {
        homePage.clickSignInBtn();
        SignInPage signInPage = new SignInPage(driver);
        boolean emailFieldIsDisplayed = driver.findElement(signInPage.getEmailInputField()).isDisplayed();
        boolean passwordFieldIsDisplayed = driver.findElement(signInPage.getPasswordInputField()).isDisplayed();
        boolean loginButtonIsDisplayed = driver.findElement(signInPage.getLoginButton()).isDisplayed();

        Assert.assertTrue(emailFieldIsDisplayed);
        Assert.assertTrue(passwordFieldIsDisplayed);
        Assert.assertTrue(loginButtonIsDisplayed);
    }

    @Test
    public void validationThatCheckboxRememberMeIsSelected() {
        homePage.clickSignInBtn();
        boolean rememberMeCheckBoxIsSelected = driver.findElement(signInPage.getCheckBoxRememberMe()).isSelected();

        Assert.assertTrue(rememberMeCheckBoxIsSelected);
    }
}
