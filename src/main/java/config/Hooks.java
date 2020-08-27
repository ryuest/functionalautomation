package config;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.SkipException;

import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.util.stream.Collectors.joining;

public class Hooks {

    @Before
    public void before(Scenario scenario) {
    	System.out.println("<========================================================================================================>");
    	System.out.println("Start of scenario: " + scenario.getName());
        WebDriverRunner.setWebDriver(DriverFactory.getDriverInstance());

        String tagsName = scenario.getSourceTagNames().toString();

    }

    @After
    public void tearDown(Scenario scenario) {
    	System.out.println("<========================================================================================================>");
    	System.out.println("End of scenario: " + scenario.getName());
        final AllureLifecycle lifecycle = Allure.getLifecycle();
        if (scenario.isFailed()) {
            lifecycle.getCurrentTestCase().ifPresent(uuid -> {
                lifecycle.addAttachment("Screenshot", "image/png", "png", getScreenshotBytes());
                lifecycle.addAttachment("Page source", "text/html", "html", getPageSourceBytes());
                    lifecycle.addAttachment("Browser Logs", "text/plain", "txt", getBrowserLogBytes());

            });
        } else {
            lifecycle.getCurrentTestCase().ifPresent(uuid -> {
                    lifecycle.addAttachment("Browser Logs", "text/plain", "txt", getBrowserLogBytes());

            });
        }

        lifecycle.addAttachment("Time Stamp","text/plain","txt",
                (DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy 'at' HH:mm:ss zzzz(z)", Locale.ENGLISH)
                        .format(java.time.ZonedDateTime.now()))
                        .getBytes(StandardCharsets.UTF_8));
        getWebDriver().quit();
    }


    private static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    private static byte[] getPageSourceBytes() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    private static byte[] getBrowserLogBytes(){
        try{
            LogEntries logEntries = getWebDriver().manage().logs().get(LogType.BROWSER);
            String logOutput = logEntries.getAll().stream().map(LogEntry::toString).collect(joining("\n"));
            return logOutput.getBytes(StandardCharsets.UTF_8);
        }catch(JsonException jEx){
            return new byte[1];
        }
    }
}

