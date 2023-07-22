package testcases;

import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    @Test(priority = 1, groups = {"high"})
    public void enteringWrongEmailTest() {
        homePage.clickSignInBtn();
        signInPage.fillTheSignFormWithIncorrectEmail();
        waitForVisibilityOf(signInPage.getErrorMessage(), 5);
        signInPage.checkIfElementIsDisplayedOrNot(signInPage.getErrorMessage(), true);
        signInPage.assertIfElementsAreEqual(
                signInPage.elementGetText(signInPage.getErrorMessage()),
                "Error: email is incorrect");
    }

    @Test(priority = 3, groups = {"high"})
    public void enteringEmptyFieldTest() {
        homePage.clickSignInBtn();
        signInPage.fillTheSignFormWithEmptyPassword();
        //waitForVisibilityOf(signInPage.getErrorMessage(), 5);
        signInPage.checkIfElementIsDisplayedOrNot(signInPage.getErrorMessage(), true);
        signInPage.assertIfElementsAreEqual(
                signInPage.elementGetText(signInPage.getErrorMessage()),
                "Error: fields are empty");
    }

//    @Test(priority = 2, groups = {"high", "medium"})
//    public void wrongCredentialsTest_updated() {
//        homePage.clickSignInBtn();
//        signInPage.fillTheSignFormWithCorrectData();
//        //waitForVisibilityOf(signInPage.getErrorMessage(), 5);
//        signInPage.checkIfElementIsDisplayedOrNot(signInPage.getErrorMessage(), true);
//        signInPage.assertIfElementsAreEqual(
//                signInPage.elementGetText(signInPage.getErrorMessage()),
//                "Error: email is incorrect");
//    }

//    @Test(priority = 4, groups = {"the lowest"})
//    public void wrongCredentialsTest() {
//        homePage.clickSignInBtn();
//        signInPage.fillTheSignFormWithCorrectData();
//        //waitForVisibilityOf(signInPage.getErrorMessage(), 5);
//        signInPage.checkIfElementIsDisplayedOrNot(signInPage.getErrorMessage(), true);
//        signInPage.assertIfElementsAreEqual(
//                signInPage.elementGetText(signInPage.getErrorMessage()),
//                "Error: credentials you provided are incorrect. Please try again. ");
//    }
}
