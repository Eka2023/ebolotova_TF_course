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
    By signUpButton = By.xpath("//a[contains(@href, 'register')]");
    By signInButton = By.xpath("//a[contains(@href, 'login')]");

    public void clickSignInBtn() {
        driver.findElement(signInButton).click();
    }

    public void clickSignUpBtn() {
        driver.findElement(signUpButton).click();
    }

}
