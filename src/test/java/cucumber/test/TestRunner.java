package cucumber.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"cucumber.main.stepdefinitions"},
        plugin = {"pretty", "json:target/cucumber-report/report.json"},
        tags = {"@Google"},
        monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

        public static String language;

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
                return super.scenarios();
        }

        @Parameters({"language"})
        @BeforeTest(alwaysRun = true)
        public static void setLanguage(String lang) {
                language = lang;
        }


}