package pageobjects;

import org.openqa.selenium.WebDriver;

public class BaseMain {

    WebDriver driver;
    String baseURL = "https://test.my-fork.com/";

    public BaseMain(WebDriver dr) {
        this.driver = dr;
    }

    public void getURL() {
        driver.get(baseURL);
    }

}
