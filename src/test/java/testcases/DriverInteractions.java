package testcases;

import org.testng.annotations.Test;


public class DriverInteractions extends BaseTest {

    @Test
    public void testCurrentUrl() {
        refreshWindow();
        homePage.clickSignInBtn();
        String currentURL = getCurrentURL();
        assertEquality(currentURL, "https://test.my-fork.com/login");
    }

    @Test
    public void testTitle() {
        homePage.clickSignInBtn();
        String pageTitle = getTitle();
        assertEquality(pageTitle, "Sign in");
    }

    @Test
    public void testOpenedTab() {
        signInPage.openNewWindowTab();
        signInPage.openNewWindowTab();
        navigateToAnotherURL("http://amazon.com");
        signInPage.openNewWindowTab();
        assertEquality(getQuantityOfOpenedTabs(), 4);
        switchToWindow(0);
        switchToWindow(2);
        assertEquality(getTitle(),"Amazon.com. Spend less. Smile more.");

    }

    @Test
    public void testJSscroll() {
        driver.get("http://amazon.com");
        homePage.scrollingPage(3000);
        homePage.scrollingPage(-2500);
    }
}
