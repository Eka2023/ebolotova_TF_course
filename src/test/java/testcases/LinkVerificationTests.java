package testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LinkVerificationTests extends BaseTest{

    @Test
    public void verifyHomePageLinks(){
        homePage.getBaseURL();
        homePage.verificationOfCodesLink();
    }

    @Test
    public void verifySignInPageLinks(){
        homePage.getBaseURL();
        homePage.clickSignInBtn();
        List<Integer> actualCodesLinkList = signInPage.verifyLinkActive();
        SoftAssert softAssert = new SoftAssert();
        for(Integer code : actualCodesLinkList) {
            softAssert.assertEquals(code, (Integer) 200);
        }
        softAssert.assertAll();
    }

    @Test
    public void verifyGalleryPageLinks(){
        homePage.getBaseURL();
        homePage.clickCourseGalleryBtn();
        List<Integer> actualCodesLinkList = courseGalleryPage.verifyLinkActive();
        SoftAssert softAssert = new SoftAssert();
        for(Integer code : actualCodesLinkList) {
            softAssert.assertEquals(code, (Integer) 200);
        }
        softAssert.assertAll();
    }

}
