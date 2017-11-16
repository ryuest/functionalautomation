package cucumber.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"cucumber.main.stepdefinitions"},
        format = {
                "json:target/cucumber/cucumber-automation-report.json",
                "html:target/cucumber/cucumber-html-report",
                "pretty"
        }
     //   tags = {"@tags"}
)
public class Config {
}