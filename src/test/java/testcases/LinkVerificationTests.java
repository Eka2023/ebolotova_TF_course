package testcases;

import org.testng.annotations.Test;

public class LinkVerificationTests extends BaseTest{

    @Test
    public void verifyHomePageLinks(){
        homePage.getBaseURL();
        homePage.urlHomePageVerification();
    }

    @Test
    public void verifySignInPageLinksListAndListSize(){
        homePage.getBaseURL();
        homePage.clickSignInBtn();
        signInPage.urlSignInPageVerification();
    }

    @Test
    public void verifyGalleryPageLinksListAndListSize(){
        homePage.getBaseURL();
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.verifyLinkActive();
        courseGalleryPage.validateWithAssertEqual(courseGalleryPage.verifyLinkActive().size(), 13);
    }

}
