package testcases;

import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    @Test(priority = 1, groups = {"high"})
    public void enteringWrongEmailTest() {
        homePage.clickSignInBtn();
        signInPage.getLogger().info("LoginTests 1");
        signInPage.fillTheSignFormWithIncorrectEmail();
        waitForVisibilityOf(signInPage.getErrorMessage(), 5); // how to re-write it?
        signInPage.checkThatErrorMessageIsDisplayed();
        signInPage.checkErrorMessageAboutIncorrectEmail();
    }

    @Test(priority = 3, groups = {"high"})
    public void enteringEmptyFieldTest() {
        homePage.clickSignInBtn();
        signInPage.getLogger().info("LoginTests 2");
        signInPage.fillTheSignFormWithEmptyPassword();
        //waitForVisibilityOf(signInPage.getErrorMessage(), 5);
        signInPage.checkThatErrorMessageIsDisplayed();
        signInPage.checkErrorMessageAboutEmptyField();
    }


    @Test(priority = 4, groups = {"the lowest"})
    public void wrongCredentialsTest() {
        homePage.clickSignInBtn();
        signInPage.getLogger().info("LoginTests 3");
        signInPage.fillTheSignFormWithCorrectData();
        //waitForVisibilityOf(signInPage.getErrorMessage(), 5);
        signInPage.checkThatErrorMessageIsDisplayed();
        signInPage.checkErrorMessageAboutIncorrectCredentials(); // wrong error message taken!!!
    }
}
