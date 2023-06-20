package pageobjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@Getter
public class HomePage extends BaseMain {
    public HomePage(WebDriver dr) {
        super(dr);
    }

    @FindBy(xpath = "//div[@id='sign-up-button']")
    WebElement signUpButton;

    @FindBy(xpath = "//div[text()='Sign In']")
    WebElement signInButton;

    public void clickSignInBtn() {
        signInButton.click();
    }

    public WebElement homePageElement(WebElement element) {
        return element;
    }

    public boolean elementIsDisplayedOnHomePage(WebElement element) {
        boolean actualElement = element.isDisplayed();
        return actualElement;
    }

    public void assertIfElementIsDisplayedOnHomePage(WebElement element) {
        Assert.assertTrue(homePageElement(element).isDisplayed());
    }

}
