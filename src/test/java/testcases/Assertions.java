package testcases;

import org.testng.annotations.Test;

public class Assertions extends BaseTest {

    @Test(groups = {"low"})
    public void hardAssertions() {
        homePage.clickSignUpBtn();
        signUpPage.checkTitle();
        signUpPage.checkJobTitleListSize();
        signUpPage.checkThatOtherInfoBlockIsDisplayed();
        signUpPage.checkDevTitleList();
    }

    @Test(groups = {"medium"})
    public void softAssertions() {
        homePage.clickSignUpBtn();
        signUpPage.checkTitle();
        signUpPage.checkJobTitleListSize();
        signUpPage.checkThatOtherInfoBlockIsDisplayed();
        signUpPage.checkDevTitleList();
        //signUpPage.softAssertAll();
    }

}
