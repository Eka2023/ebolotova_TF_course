package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseTest extends ExpectedData {
    public RemoteWebDriver driver;
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
    @Parameters("browser")
    public void openDriver() throws MalformedURLException {
        driverConfig("sauce-chrome");

        //WebDriverManager.chromedriver().setup();
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
        FileHandler fileHandler = new FileHandler("/Users/ekaterinabolotova/IdeaProjects/ebolotova_TF_course/Logs.log");
        log.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        log.info("This is the beginning of Test Suit");
    }

    public void driverConfig(String browserName) throws MalformedURLException {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            //options.addArguments("--headless");
            System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--remote-allow-origins=*");
            System.setProperty("webdriver.gecko.driver", "src/test/resources/webdrivers/geckodriver");
            driver = new FirefoxDriver(options);
        } else if (browserName.equalsIgnoreCase("safari")) {
            System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
            driver = new SafariDriver();
        } else if (browserName.equalsIgnoreCase("sauce-chrome")) {
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("latest");

            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("username", "oauth-bolotova.katya-76d03");
            sauceOptions.put("accessKey", "808f828e-61a4-47e3-94fd-58cc90e80ea8");
            sauceOptions.put("build", "selenium-build-GRSIM");
            sauceOptions.put("name", "Whole Test Suite on SauceLab");
            browserOptions.setCapability("sauce:options", sauceOptions);
            URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(url, browserOptions);
        } else if (browserName.equalsIgnoreCase("sauce-firefox")) {
            FirefoxOptions browserOptions = new FirefoxOptions();
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("latest");

            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("username", "oauth-bolotova.katya-76d03");
            sauceOptions.put("accessKey", "808f828e-61a4-47e3-94fd-58cc90e80ea8");
            sauceOptions.put("build", "selenium-build-GRSIM");
            sauceOptions.put("name", "Whole Test Suite on SauceLab");
            browserOptions.setCapability("sauce:options", sauceOptions);
            URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(url, browserOptions);
        } else {
            System.out.println("Correct browser name is not found. Please check @Optional in @BeforeMethod.");
        }
    }
}


