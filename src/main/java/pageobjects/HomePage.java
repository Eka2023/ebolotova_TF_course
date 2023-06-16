package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseMain {
    public HomePage(WebDriver dr) {
        super(dr);
    }

//    public HomePage(WebDriver dr) {
//        this.driver = dr;
//        PageFactory.initElements(driver, this);
//    }

    String baseURL = "https://test.my-fork.com/";

    @FindBy(id="sign-up-button")
    WebElement signUpButton;

    @FindBy(xpath="//div[text()='Sign In']")
    WebElement signInButton;

    public void clickSignInBtn() {
        signInButton.click();
    }

    public WebElement getSignInBtn() {
        return signInButton;
    }

    public WebElement getSignUpBtn() {
        return signUpButton;
    }

}
