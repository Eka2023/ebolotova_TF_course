package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.logging.Logger;

import static utils.ExpectedData.expectedActiveLinksOnHomePage;
import static utils.ExpectedData.expectedCodesOfActiveLinksOnHomePage;

@Getter
public class HomePage extends BaseMain {
    public HomePage(WebDriver dr, Logger log) {
        super(dr, log);
    }
    By signUpButton = By.xpath("//a[@data='record-data' and contains(@href, 'register')]");
    By signInButton = By.xpath("//a[contains(@href, 'login')]");
    By signOutBtn = By.xpath("//a[contains(@href, 'logout')]");
    By courseGalleryBtn = By.xpath("//div[contains(text(), 'Course Gallery')]");

    public void clickSignInBtn() {
        clickElement(signInButton, "SignInBtn");
    }

    public void clickSignUpBtn() {
        clickElement(signUpButton, "SignUpBtn");
    }

    public void clickSignOutBtn() {
        clickElement(signOutBtn, "SignOutBtn");
    }

    public void clickCourseGalleryBtn() {
        clickElement(courseGalleryBtn, "CourseGalleryBtn");
    }

    public void validationOfGalleryBtn() {
        checkElementIsDisplayed(getCourseGalleryBtn(), "CourseGalleryBtn", true);
    }

    public void checkSignInBtnIsDisplayed() {
        checkElementIsDisplayed(getSignInButton(), "SignInBtn", true);
    }

    public void checkSignUpBtnIsDisplayed() {
        checkElementIsDisplayed(getSignUpButton(), "SingUpBtn", true);
    }

    public void verificationOfCodesLink(){
        List<Integer> actualCodesLinkList = verifyLinkActive();
        SoftAssert softAssert = new SoftAssert();
        for(Integer code : actualCodesLinkList) {
            softAssert.assertEquals(code, (Integer) 200);
        }
        softAssert.assertAll();
    }
}
