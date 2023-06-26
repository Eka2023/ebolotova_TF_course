package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
    public WebElement homePageElement(By element) {
        return driver.findElement(element);
    }

    public boolean elementIsDisplayedOnHomePage(By element) {
        WebElement webElement = homePageElement(element);
        boolean actualElement = webElement.isDisplayed();
        return actualElement;
    }

}
