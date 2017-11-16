package cucumber.main.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by Juri on 16/11/2017.
 */
public class StepDefs extends BaseSteps {

    @Before
    public void before() {
        startWebDriver();
    }

    @After
    public void after() {
        stopWebDriver();
    }

    @Given ("^user go to google site$")
    public void openGooglePage() {
        driver.navigate().to("https://www.google.com");
    }

    @Given("^Enter search term '(.*?)'$")
    public void searchFor(String searchTerm) {
        WebElement searchField = driver.findElement(By.id("searchInput"));
        searchField.sendKeys(searchTerm);
    }

    @When("^Do search$")
    public void clickSearchButton() {
        driver.findElement(By.id("lst-ib")).click();
        driver.findElement(By.id("lst-ib")).sendKeys("football");
        wait(1);
        driver.findElement(By.className("lsb")).click();
        wait(1);
    }
    //http://www.bbc.com/sport/football
    //By.cssSelector("a[data-racename = 'All Races']")
    // Football - BBC Sport
    @Then("^Football page shown as '(.*?)'$")
    public void verifyElement(String elementText) {
        WebElement element = driver.findElement(By.cssSelector("a[data-href = 'http://www.bbc.com/sport/football']"));
        assertEquals(elementText, element.getText());
    }

    @Then("^Multiple results are shown for '(.*?)'$")
    public void assertMultipleResults(String searchResults) {
        WebElement firstSearchResult = driver.findElement(By.cssSelector("div#mw-content-text.mw-content-ltr p"));
        assertEquals(searchResults, firstSearchResult.getText());
    }

    @Then("^Single result is shown for '(.*?)'$")
    public void assertSingleResult(String searchResults) {
        WebElement articleName = driver.findElement(By.id("firstHeading"));
        assertEquals(articleName.getText(), searchResults);
    }
}
