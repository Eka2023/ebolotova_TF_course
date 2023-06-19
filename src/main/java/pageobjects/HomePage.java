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
    By signUpButton = By.xpath("//div[@id='sign-up-button']");
    By signInButton = By.xpath("//div[text()='Sign In']");

    public void clickSignInBtn() {
        driver.findElement(signInButton).click();
    }

    public WebElement homePageElement(By element){
        return driver.findElement(element);
    }
}
