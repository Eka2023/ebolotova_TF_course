package testcases;

import org.testng.annotations.Test;

public class LinkVerificationTests extends BaseTest{

    @Test
    public void verifyHomePageLinksListAndListSize(){
        homePage.getBaseURL();
        homePage.urlVerification();
        homePage.validateWithAssertEqual(homePage.urlVerification().size(), 6);
    }

    @Test
    public void verifySignInPageLinksListAndListSize(){
        homePage.getBaseURL();
        homePage.clickSignInBtn();
        signInPage.verifyLinkActive();
        signInPage.validateWithAssertEqual(signInPage.verifyLinkActive().size(), 5);
    }

    @Test
    public void verifyGalleryPageLinksListAndListSize(){
        homePage.getBaseURL();
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.verifyLinkActive();
        courseGalleryPage.validateWithAssertEqual(courseGalleryPage.verifyLinkActive().size(), 13);
    }

}
