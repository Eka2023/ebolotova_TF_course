package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LoginTestWithCSVDataProvider extends BaseTest{

    By loginButton = By.xpath("//button[@type='submit']");
    @DataProvider(name = "LoginPasswordDP")
    public static Object[][] dpFromCSV() throws IOException {
        ArrayList<Object[]> out = new ArrayList<>();
        Files.readAllLines(Paths.get("src/test/resources/dataproviders/user_data_provider.csv")).stream().forEach(s ->{
            String[] data = s.split(",");
            out.add(new Object[]{data[0], data[1], data[2], data[3],data[4]});
        });
        return out.toArray(new Object[out.size()][]);
    }

    @Test(dataProvider = "LoginPasswordDP")
    public void loginTest(String login, String password, String isElementDisplayed, String errorMessage,String title) {
        homePage.clickSignInBtn();
        Assert.assertEquals(signInPage.getPageTitle(), title);
        signInPage.fillInLoginFormForDataProviderAsMethod(login, password);
        Assert.assertEquals(signInPage.elementIsDisplayedForCSVDataProviderTest(),
                signInPage.convertBooleanToString(isElementDisplayed));
        waitForVisibilityOf(signInPage.getErrorMessage(), 5); // how to re-write it?
        signInPage.checkThatErrorMessageIsDisplayed();
        Assert.assertEquals(signInPage.getErrorMessageText(), errorMessage);
    }


}


