package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseMain {

    WebDriver driver;
    String baseURL = "https://test.my-fork.com/";

    public void getURL() {
        driver.get(baseURL);
    }

    public BaseMain(WebDriver dr) {
        this.driver = dr;
        PageFactory.initElements(driver, this);
    }

}
