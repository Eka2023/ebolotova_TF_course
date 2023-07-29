package testcases.outofbaseurl;

import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.BaseTest;

public class AmazonTest extends BaseTest {

    @Test(groups = {"the lowest"})
    public void testOpenedTab() {
        openNewWindowTab();
        openNewWindowTab();
        navigateToAnotherURL("http://amazon.com");
        openNewWindowTab();
        Assert.assertEquals(getQuantityOfOpenedTabs(), 4);
        switchToWindowFromTestBase(0);
        switchToWindowFromTestBase(2);
        Assert.assertEquals(getTitle(), "Amazon.com. Spend less. Smile more.");

    }

    @Test(groups = {"medium"})
    public void testJSscroll() {
        driver.get("http://amazon.com");
        scrollingPage(3000);
        scrollingPage(-2500);
    }

}
