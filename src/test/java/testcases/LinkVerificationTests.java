package testcases;

import org.testng.annotations.Test;

public class LinkVerificationTests extends BaseTest {

    @Test
    public void verifyHomePageLinks() {
        homePage.getBaseURL();
        homePage.verificationOfCodesLinkOnHomePage();
    }

    @Test
    public void verifySignInPageLinks() {
        homePage.getBaseURL();
        homePage.clickSignInBtn();
        signInPage.verificationOfCodesLinkOnSignInPage();
    }

    @Test
    public void verifyGalleryPageLinks() {
        homePage.getBaseURL();
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.verificationOfCodesLinkOnCourseGalleryPage();
    }

}
