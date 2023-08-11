package testcases;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageobjects.*;
import pageobjects.coursepages.SQL101BasicsPage;
import pageobjects.coursepages.SQL101TestPage;
import utils.ExpectedData;


import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseTest extends ExpectedData {
    public WebDriver driver;
    Logger log = Logger.getLogger(getClass().getName());
    BaseMain baseMain;
    HomePage homePage;
    SignInPage signInPage;
    SignUpPage signUpPage;
    CourseGalleryPage courseGalleryPage;
    SQL101BasicsPage sql101BasicsPage;
    SQL101TestPage sql101TestPage;

    @BeforeTest
    public void createLog() throws IOException {
        saveLogs(log);
    }
    @BeforeMethod(groups = {"high"})
    public void openDriver() throws IOException {
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", "/home/vboxuser/Documents/chromedriver");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");      
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        //options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model

        
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        log = Logger.getLogger(getClass().getName());
//        saveLogs(log);
        baseMain = new BaseMain(driver, log);
        homePage = new HomePage(driver, log);
        homePage.getBaseURL();
        signInPage = new SignInPage(driver, log);
        signUpPage = new SignUpPage(driver, log);
        courseGalleryPage = new CourseGalleryPage(driver, log);
        sql101BasicsPage = new SQL101BasicsPage(driver, log);
        sql101TestPage = new SQL101TestPage(driver, log);

        /**
         *         This example slows down tests in two times:
         *         DevTools devTools = ((ChromeDriver) driver).getDevTools();
         *         devTools.createSession();
         *         devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
         *         devTools.send(Network.emulateNetworkConditions(false, 1000, 10000, 10000, Optional.of(ConnectionType.CELLULAR3G)));
         */

    }

    @AfterMethod(groups = {"high"})
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void wait(ExpectedCondition<WebElement> condition, Integer timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(condition);
    }

    public void waitForVisibilityOf(By locator, Integer timeOutInSeconds) {
        try {
            wait(ExpectedConditions.visibilityOfElementLocated(locator),
                    timeOutInSeconds);
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException - -> Element not found");
        }
    }

    protected void switchToWindowFromTestBase(int tab) {
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabHandler.get(tab));
    }

    protected int getQuantityOfOpenedTabs() {
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        return tabHandler.size();
    }

    protected void refreshWindow() {
        driver.navigate().refresh();
    }

    protected void navigateToAnotherURL(String url) {
        driver.navigate().to(url);
    }


    protected String getTitle() {
        return driver.getTitle();
    }

    protected void openNewWindowTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    protected void scrollingPage(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")", "");

    }
    private void saveLogs(Logger log) throws IOException {
        //FileHandler fileHandler = new FileHandler("/Users/ekaterinabolotova/IdeaProjects/ebolotova_TF_course/Logs.log");
        FileHandler fileHandler = new FileHandler("/home/vboxuser/Documents/ebolotova_TF_course/MyLogs.log");
        log.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        log.info("This is the beginning of Test Suit");
    }

}
