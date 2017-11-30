package cucumber.main.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSteps {

    private static final String WEB_DRIVER_FOLDER = "src\\test\\resources\\drivers\\chromedriver.exe";

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected void startWebDriver() {
        System.setProperty("webdriver.chrome.driver", WEB_DRIVER_FOLDER);
        driver = new ChromeDriver();
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
