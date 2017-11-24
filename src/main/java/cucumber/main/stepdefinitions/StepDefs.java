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

    @Given ("^user go to mine-portfolio site$")
    public void openSportsbookPage() {
        driver.navigate().to("https://ryuest.github.io/mine-portfolio-final/");
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

    @When("^the user enter correct credentials$")
    public void userLogin() {
        login("user@test.com", "password1");
    }

    @When("^Click seletion$")
    public void clickSelection() {
        driver.findElement(By.className("betbutton")).click();
        wait(1);
    }

    @When("^Add Stake$")
    public void addStake() {
        WebElement element = driver.findElement(By.cssSelector("input[autocomplete = 'new-bet']"));
        element.click();
        element.sendKeys("2");
        wait(1);
    }

    @When("^Place the bet$")
    public void placeBet() {
        driver.findElement(By.cssSelector(".betslip-bet-actions")).click();
        wait(1);
    }

    @Then("^page show '(.*?)'$")
    public void verifyBetRecipt(String elementText) {
        WebElement element = driver.findElement(By.cssSelector(".betslip-receipt_header-text"));
        assertEquals(elementText, element.getText());
    }

    @Then("^Football page shown as '(.*?)'$")
    public void verifyPage(String elementText) {
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

    private void login(String username, String password) {
        driver.findElement(By.cssSelector("a[href = '/login']")).click();
        driver.findElement(By.cssSelector("input[name = 'email']")).click();
        driver.findElement(By.cssSelector("input[name = 'email']")).sendKeys(username);
        wait(1);
        driver.findElement(By.cssSelector("input[name = 'password']")).click();
        driver.findElement(By.cssSelector("input[name = 'password']")).sendKeys(password);
        wait(1);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div[1]/form/div[3]/button")).click();
        wait(1);
    }
}
