package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions extends BaseTest{

    @Test(groups = {"low"})
    public void hardAssertions(){
        String expectedTitle = "Sign Up";
        int expectedJobTitleListSize = 13;
        boolean expectedDisplayed = true;

        homePage.clickSignUpBtn();
        String actualTitle = signUpPage.getPageTitle();
        int actualJobTitleListSize = signUpPage.getJobTitleList().size();

        signUpPage.assertIfElementsAreEqual(actualTitle, expectedTitle, "Title is not correct");
        signUpPage.assertIfElementsAreEqual(actualJobTitleListSize, expectedJobTitleListSize, "Size of the list is not correct");
        signUpPage.assertIfElementIsDisplayed_boolean(signUpPage.getOtherInfoBlock(), expectedDisplayed);
        signUpPage.assertActualAndExpectedList(
                signUpPage.getJobListWithPreferableTitle("developers"),
                signUpPage.expectedDevJobTitleList());
    }

    @Test(groups = {"medium"})
    public void softAssertions(){
        String expectedTitle = "Sign";
        int expectedJobTitleListSize = 12;
        boolean expectedDisplayed = false;
        homePage.clickSignUpBtn();
        String actualTitle = signUpPage.getPageTitle();
        int actualJobTitleListSize = signUpPage.getJobTitleList().size();

        signUpPage.softAssertIfElementsAreEqual(actualTitle, expectedTitle, "Title is not correct");
        signUpPage.softAssertIfElementsAreEqual(actualJobTitleListSize, expectedJobTitleListSize, "Size of the list is not correct");
        signUpPage.softAssertIfElementIsDisplayed_boolean(signUpPage.getOtherInfoBlock(), expectedDisplayed);
        signUpPage.softAssertActualAndExpectedList(
                signUpPage.getJobListWithPreferableTitle("developer"),
                signUpPage.expectedDevJobTitleList());
        signUpPage.softAssertAll();
    }

}
