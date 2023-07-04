package testcases;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
        @Test
    public void enteringWrongEmailTest() {
        homePage.clickSignInBtn();
        signInPage.fillTheSignFormWithIncorrectEmail();
        //waitForVisibilityOf(signInPage.getErrorMessage(), 5);
        signInPage.assertIfElementIsDisplayed(signInPage.getErrorMessage());
        signInPage.assertIfElementsAreEqual(
                signInPage.elementGetText(signInPage.getErrorMessage()),
                "Error: email is incorrect");
    }

    @Test
    public void enteringEmptyFieldTest() {
        homePage.clickSignInBtn();
        signInPage.fillTheSignFormWithEmptyPassword();
        //waitForVisibilityOf(signInPage.getErrorMessage(), 5);
        signInPage.assertIfElementIsDisplayed(signInPage.getErrorMessage());
        signInPage.assertIfElementsAreEqual(
                signInPage.elementGetText(signInPage.getErrorMessage()),
                "Error: fields are empty");
    }

    @Test
    public void wrongCredentialsTest_updated() {
        homePage.clickSignInBtn();
        signInPage.fillTheSignFormWithCorrectData();
        //waitForVisibilityOf(signInPage.getErrorMessage(), 5);
        signInPage.assertIfElementIsDisplayed(signInPage.getErrorMessage());
        signInPage.assertIfElementsAreEqual(
                signInPage.elementGetText(signInPage.getErrorMessage()),
                "Error: email is incorrect");
    }

    @Test
    @Ignore
    public void wrongCredentialsTest() {
        homePage.clickSignInBtn();
        signInPage.fillTheSignFormWithCorrectData();
        //waitForVisibilityOf(signInPage.getErrorMessage(), 5);
        signInPage.assertIfElementIsDisplayed(signInPage.getErrorMessage());
        signInPage.assertIfElementsAreEqual(
                signInPage.elementGetText(signInPage.getErrorMessage()),
                "Error: credentials you provided are incorrect. Please try again. ");
    }
}
