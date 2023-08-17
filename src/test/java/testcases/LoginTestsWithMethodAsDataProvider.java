package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestsWithMethodAsDataProvider extends BaseTest{

    @DataProvider(name = "LoginPasswordDataProvider")
    public Object[][] dpMethod() {
        return new Object[][]{
                {"bolotova.katya@gmail.com", "correctPassword", "Error: email is incorrect"},
                {"bolotova.katya@gmail.com", "wrongPassword", "Error: email is incorrect"},
                {"ebolotov", "correctPassword", "Error: email is incorrect"},
                {"bolotova.katya@gmail.com", "", "Error: fields are empty"},
                {"", "correctPassword", "Error: fields are empty"}
        };
    }

    @Test(dataProvider = "LoginPasswordDataProvider")
    public void loginTest(String login, String password, String... message) {
        homePage.clickSignInBtn();
        signInPage.fillInLoginFormForDataProviderAsMethod(login, password);
        waitForVisibilityOf(signInPage.getErrorMessage(), 5); // how to re-write it?
        signInPage.checkThatErrorMessageIsDisplayed();
        signInPage.getErrorMessageText();

    }
}
