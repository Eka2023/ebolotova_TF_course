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
    public void printAllJobTitleWithoutSeleniumSelection() {
        homePage.clickSignUpBtn();
        signUpPage.assertActualAndExpectedList(
                signUpPage.getJobTitleListWithoutSeleniumSelect(),
                signUpPage.expectedJobTitleList());

    }

}
