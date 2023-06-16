package testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test
    public void enteringWrongEmailTest() {
        homePage.clickSignInBtn();
        signInPage.fillTheSignFormWithIncorrectEmail();
        waitForVisibilityOf(signInPage.getErrorAboutIncorrectEmail(), 5);
        WebElement errorMessage = signInPage.getErrorAboutIncorrectEmail();
        boolean actualErrorMessageIsEnabled = errorMessage.isDisplayed();
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessageIsEnabled);
        Assert.assertEquals(actualErrorMessage, "Error: email is incorrect");

    }

    @Test
    public void enteringEmptyFieldTest() {
        homePage.clickSignInBtn();
        signInPage.fillTheSignFormWithEmptyPassword();
        waitForVisibilityOf(signInPage.getErrorAboutEmptyField(), 5);
        WebElement errorMessage = signInPage.getErrorAboutEmptyField();
        boolean actualErrorMessageIsEnabled = errorMessage.isDisplayed();
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessageIsEnabled);
        Assert.assertEquals(actualErrorMessage, "Error: fields are empty");
    }

    @Test
    @Ignore
    public void wrongCredentialsTest() throws InterruptedException {
        homePage.clickSignInBtn();
        signInPage.fillTheSignFormWithCorrectData();
        Thread.sleep(1000);

        WebElement errorMessage = signInPage.getErrorAboutWrongCredentials();
        boolean actualErrorMessageIsEnabled = errorMessage.isEnabled();
        Thread.sleep(3000);
        String actualErrorMessage = errorMessage.getText();

        Assert.assertTrue(actualErrorMessageIsEnabled);
        Assert.assertEquals(actualErrorMessage, "Error: credentials you provided are incorrect. Please try again. ");
    }


}
