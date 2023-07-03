package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions extends BaseTest{

    @Test
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

    @Test
    public void softAssertions(){
        String expectedTitle = "Sign";
        int expectedJobTitleListSize = 12;
        boolean expectedDisplayed = false;

        homePage.clickSignUpBtn();
        String actualTitle = signUpPage.getPageTitle();
        int actualJobTitleListSize = signUpPage.getJobTitleList().size();

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(actualTitle, expectedTitle, "Title is not correct");
        sa.assertEquals(actualJobTitleListSize, expectedJobTitleListSize, "Size of the list is not correct");
        sa.assertEquals(signUpPage.getOtherInfoBlock(), expectedDisplayed);
        sa.assertEquals(
                signUpPage.getJobListWithPreferableTitle("developer"),
                signUpPage.expectedDevJobTitleList());
        sa.assertAll();
    }

}
