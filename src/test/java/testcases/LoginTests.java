package testcases;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void enteringWrongEmailTest() {
        homePage.clickSignInBtn();
        signInPage.fillTheSignFormWithIncorrectEmail();
        waitForVisibilityOf(signInPage.getErrorAboutIncorrectEmail(), 5);
        signInPage.elementIsDisplayedOnSignInPage(signInPage.getErrorAboutIncorrectEmail());
        signInPage.assertIfElementIsDisplayed(signInPage.getErrorAboutIncorrectEmail());
        signInPage.assertIfElementsAreEqual(
                signInPage.elementGetText(signInPage.getErrorAboutIncorrectEmail()),
                "Error: email is incorrect");
    }

    @Test
    public void enteringEmptyFieldTest() {
        homePage.clickSignInBtn();
        signInPage.fillTheSignFormWithEmptyPassword();
        waitForVisibilityOf(signInPage.getErrorAboutEmptyField(), 5);
        signInPage.elementIsDisplayedOnSignInPage(signInPage.getErrorAboutEmptyField());
        signInPage.assertIfElementIsDisplayed(signInPage.getErrorAboutEmptyField());
        signInPage.assertIfElementsAreEqual(
                signInPage.elementGetText(signInPage.getErrorAboutEmptyField()),
                "Error: fields are empty");
    }

    @Test
    public void wrongCredentialsTest_updated() {
        homePage.clickSignInBtn();
        signInPage.fillTheSignFormWithCorrectData();
        waitForVisibilityOf(signInPage.getErrorAboutIncorrectEmail(), 5);
        signInPage.elementIsDisplayedOnSignInPage(signInPage.getErrorAboutWrongCredentialsUpdated());
        signInPage.assertIfElementIsDisplayed(signInPage.getErrorAboutWrongCredentialsUpdated());
        signInPage.assertIfElementsAreEqual(
                signInPage.elementGetText(signInPage.getErrorAboutWrongCredentialsUpdated()),
                "Error: email is incorrect");
    }

    @Test
    @Ignore
    public void wrongCredentialsTest() {
        homePage.clickSignInBtn();
        signInPage.fillTheSignFormWithCorrectData();
        waitForVisibilityOf(signInPage.getErrorAboutIncorrectEmail(), 5);
        signInPage.elementIsDisplayedOnSignInPage(signInPage.getErrorAboutWrongCredentials());
        signInPage.assertIfElementIsDisplayed(signInPage.getErrorAboutWrongCredentials());
        signInPage.assertIfElementsAreEqual(
                signInPage.elementGetText(signInPage.getErrorAboutWrongCredentials()),
                "Error: credentials you provided are incorrect. Please try again. ");
    }
}
