package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Getter
public class HomePage extends BaseMain {
    public HomePage(WebDriver dr) {
        super(dr);
    }

    String baseURL = "https://test.my-fork.com/";
    By signUpButton = By.xpath("//div[@id='sign-up-button']");
    //By signInButton = By.xpath("//div[@id='log-in-button']");
    By signInButton = By.xpath("//div[text()='Sign In']");

    public void clickSignInBtn() {
        driver.findElement(signInButton).click();
    }
    public By getSignInBtn() {
        return signInButton;
    }

    public By getSignUpBtn() {
        return signUpButton;
    }

    public boolean homePageElementDisplayed(By element){
        return driver.findElement(element).isDisplayed();
    }
}
