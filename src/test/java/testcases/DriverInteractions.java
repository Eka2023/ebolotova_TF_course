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
        openNewWindowTab();
        openNewWindowTab();
        navigateToAnotherURL("http://amazon.com");
        openNewWindowTab();
        assertEquality(getQuantityOfOpenedTabs(), 4);
        switchToWindow(0);
        switchToWindow(2);
        assertEquality(getTitle(),"Amazon.com. Spend less. Smile more.");

    }

    @Test
    public void testJSscroll() {
        driver.get("http://amazon.com");
        scrollingPage(3000);
        scrollingPage(-2500);
    }
}
