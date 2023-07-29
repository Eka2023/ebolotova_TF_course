package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class HomePage extends BaseMain {
    public HomePage(WebDriver dr) {
        super(dr);
    }
    By signUpButton = By.xpath("//a[@data='record-data' and contains(@href, 'register')]");
    By signInButton = By.xpath("//a[contains(@href, 'login')]");
    By signOutBtn = By.xpath("//a[contains(@href, 'logout')]");
    //By courseGalleryBtn = By.xpath("//a[@class='menu-item']/div[contains(text(), 'Course Gallery')]");
    By courseGalleryBtn = By.xpath("//div[contains(text(), 'Course Gallery')]");

    public void clickSignInBtn() {
        driver.findElement(signInButton).click();
    }

    public void clickSignUpBtn() {
        driver.findElement(signUpButton).click();
    }

    public void clickSignOutBtn() {
        driver.findElement(signOutBtn).click();
    }

    public void clickCourseGalleryBtn() {
        driver.findElement(courseGalleryBtn).click();
    }

    public void validationOfGalleryBtn(){
        checkElementIsDisplayed(getCourseGalleryBtn(), true);
    }
    public void checkSignInBtnIsDisplayed(){
        checkElementIsDisplayed(getSignInButton(), true);
    }
    public void checkSignUpBtnIsDisplayed() {
        checkElementIsDisplayed(getSignUpButton(), true);
    }


}
