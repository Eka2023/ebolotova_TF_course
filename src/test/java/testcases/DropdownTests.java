package testcases;

import org.testng.annotations.Test;

public class DropdownTests extends BaseTest{

    @Test
    public void printAllJobTitleList() {
        homePage.clickSignUpBtn();
        signUpPage.assertActualAndExpectedList(
                signUpPage.getJobTitleList(),
                signUpPage.expectedJobTitleList());
    }

    @Test
    public void printDevJobTitleList() {
        homePage.clickSignUpBtn();
        signUpPage.assertActualAndExpectedList(
                signUpPage.getJobListWithPreferableTitle("developer"),
                signUpPage.expectedDevJobTitleList());
    }

    @Test
    public void printQAJobTitleList() {
        homePage.clickSignUpBtn();
        signUpPage.assertActualAndExpectedList(
                signUpPage.getJobListWithPreferableTitle("test", "QA"),
                signUpPage.expectedQAJobTitleList());
    }

    @Test
    public void printAnalystJobTitleList() {
        homePage.clickSignUpBtn();
        signUpPage.assertActualAndExpectedList(
                signUpPage.getJobListWithPreferableTitle("analyst"),
                signUpPage.expectedAnalystJobTitleList());
    }

    @Test
    public void printBAJobTitleList() {
        homePage.clickSignUpBtn();
        signUpPage.assertActualAndExpectedList(
                signUpPage.getJobListWithPreferableTitle("business"),
                signUpPage.expectedBAJobTitleList());
    }
    @Test
    public void printAllJobTitleWithoutSeleniumSelection() {
        homePage.clickSignUpBtn();
        signUpPage.assertActualAndExpectedList(
                signUpPage.getJobTitleListWithoutSeleniumSelect(),
                signUpPage.expectedJobTitleList());

    }

}
