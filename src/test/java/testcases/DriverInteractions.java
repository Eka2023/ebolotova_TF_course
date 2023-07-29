package testcases;

import org.testng.annotations.Test;

public class DriverInteractions extends BaseTest {

    @Test(groups = {"medium"})
    public void testCurrentUrl() {
        refreshWindow();
        homePage.clickSignInBtn();
        signInPage.checkCurrentURL();
    }

    @Test(groups = {"medium"})
    public void testTitle() {
        homePage.clickSignInBtn();
        signInPage.checkTitle();
    }

}
