package cucumber.main.stepdefinitions;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.logging.Level;

public class BaseSteps {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected void startWebDriver() {
        driver = getChromeDriver("src/test/resources/selenium-drivers/");
    }

    private static WebDriver getChromeDriver(String driverpath) {

        WebDriver driver = null;

        try {
            String localMachineEnvironment = System.getProperty("os.name");
            LoggingPreferences logPrefs = new LoggingPreferences();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            if(localMachineEnvironment.contains("Windows"))
                System.setProperty("webdriver.chrome.driver", driverpath+"chromedriver.exe");
                //else if(localMachineEnvironment.contains("Linux"))
            else
                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            Configuration.screenshots = false;
            Configuration.savePageSource = false;
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            //     options.addArguments("--headless");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--lang=de");
            options.addExtensions(new File("src/test/resources/chrome-extensions/GoogleTranslater.crx"));
            logPrefs.enable(LogType.BROWSER, Level.ALL);
            capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
            options.merge(capabilities);

            driver = new ChromeDriver(options);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    protected void stopWebDriver() {
        driver.quit();
    }

    public void waitElement(int timeOutInSeconds, By locator) {
        Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitElementClickable(int timeOutInSeconds, String text) {
        Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Football - BBC Sport")));
    }

    protected void wait(int timeOutInSeconds) {
        try {
            Thread.sleep(timeOutInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
