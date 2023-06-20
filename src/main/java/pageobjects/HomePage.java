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

    By signUpButton = By.xpath("//div[@id='sign-up-button']");
    By signInButton = By.xpath("//div[text()='Sign In']");

    public void clickSignInBtn() {
        driver.findElement(signInButton).click();
    }

    public WebElement homePageElement(By element) {
        return driver.findElement(element);
    }

    public boolean elementIsDisplayedOnHomePage(By element) {
        WebElement webElement = homePageElement(element);
        boolean actualElement = webElement.isDisplayed();
        return actualElement;
    }

    public void assertIfElementIsDisplayedOnHomePage(By element) {
        Assert.assertTrue(homePageElement(element).isDisplayed());
    }

}
