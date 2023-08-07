package testcases;

import org.testng.annotations.Test;

public class LinkVerificationTests extends BaseTest{

    @Test
    public void verifyHomePageLinks(){
        homePage.getBaseURL();
        homePage.urlHomePageVerification();
        homePage.urlCodesHomePageVerification();
    }

    @Test
    public void verifySignInPageLinksListAndListSize(){
        homePage.getBaseURL();
        homePage.clickSignInBtn();
        signInPage.urlSignInPageVerification();
        signInPage.urlCodesSignInPageVerification();
    }

    @Test
    public void verifyGalleryPageLinksListAndListSize(){
        homePage.getBaseURL();
        homePage.clickCourseGalleryBtn();
        courseGalleryPage.urlCourseGalleryVerification();
        courseGalleryPage.urlCodesCourseGalleryPageVerification();
    }

}
