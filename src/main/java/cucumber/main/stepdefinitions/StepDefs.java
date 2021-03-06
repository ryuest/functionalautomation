package cucumber.main.stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by Juri on 16/11/2017.
 */
public class StepDefs extends BaseSteps {

    private final String BUTTON_BY_LABEL = "//button[contains(.,'%s')]";

    private final By BBC_FOOTBALL_LINK = By.linkText("Football - BBC Sport");

    private final By GOOGLE_LINKS_LIST = By.cssSelector("._NId");

    private final By GOOGLE_SEARCH = By.cssSelector("input[role='combobox']");

    private final String GOOGLE_URL = "https://www.google.com";

    private final String SPORTSBOOK_URL = "https://ryuest.github.io/mine-portfolio-final/";

    private final By ADD_STAKE = By.cssSelector("input[autocomplete = 'new-bet']");

    private final By RECEIPT_HEADER = By.cssSelector(".betslip-receipt_header-text");


    @Given("^User go to google site$")
    public void openGooglePage() {
        driver.navigate().to(GOOGLE_URL);
    }

    @Given("^User go to mine site$")
    public void openMinePage() {
        driver.navigate().to("https://www.google.co.uk/");
    }

    @Given("^User go to mine-portfolio site$")
    public void openSportsbookPage() {
        driver.navigate().to(SPORTSBOOK_URL);
    }

    @Given("^job$")
    public void countEdinburgh() {
        String city = "Edinburgh";
        driver.navigate().to("https://www.heathrow.com/arrivals");
        List<WebElement> flights = driver.findElement(By.id("arrivadatagrid")).findElements(By.tagName("tr"));
        int count = 0;
        for (int a = 0; a < flights.size(); a++) {
            if (flights.get(a).getText().contains(city)) {
                count++;
            }
        }
        System.out.println(city + "flights:" + count);
    }

    @Given("^Enter search term '(.*?)'$")
    public void searchFor(String searchTerm) {
        WebElement searchField = driver.findElement(By.id("searchInput"));
        searchField.sendKeys(searchTerm);
    }

    @When("^Do search$")
    public void clickSearchButton() {
        driver.findElement(By.cssSelector("div[role='presentation']")).click();
        driver.findElement(GOOGLE_SEARCH).click();
        driver.findElement(GOOGLE_SEARCH).sendKeys("football");
        wait(1);
        driver.findElement(By.xpath("//center/input[contains(@aria-label, 'Googl')]")).click();
        wait(1);
    }

    @When("^The user enter correct credentials$")
    public void userLogin() {
        login("user@test.com", "password1");
    }

    @When("^Click selection")
    public void clickSelection() {
        driver.findElement(By.className("betbutton")).click();
        wait(1);
    }

    @When("^Add Stake$")
    public void addStake() {
        WebElement element = driver.findElement(ADD_STAKE);
        element.click();
        element.sendKeys("2");
        wait(1);
    }

    @When("^Place the bet$")
    public void placeBet() {
        driver.findElement(By.xpath(String.format(BUTTON_BY_LABEL, "Place Bet"))).click();
        wait(1);
    }

    @Then("^Page show (is|is not) '(.*?)'$")
    public void verifyBetRecipt(String Displayed, String elementText) {
        WebElement element = driver.findElement(RECEIPT_HEADER);
        assertEquals(elementText, element.getText());
    }

    @Then("^Football page shown as '(.*?)'$")
    public void verifyPage(String elementText) {
        waitElement(2, GOOGLE_LINKS_LIST);
        waitElementClickable(2, "sdsd");
        WebElement element = driver.findElements(GOOGLE_LINKS_LIST).get(0).findElement(BBC_FOOTBALL_LINK);
        assertEquals(elementText, element.getText());
    }

    private void login(String username, String password) {
        driver.findElement(By.cssSelector("a[href = '/login']")).click();
        driver.findElement(By.cssSelector("input[name = 'email']")).click();
        driver.findElement(By.cssSelector("input[name = 'email']")).sendKeys(username);
        wait(1);
        driver.findElement(By.cssSelector("input[name = 'password']")).click();
        driver.findElement(By.cssSelector("input[name = 'password']")).sendKeys(password);
        wait(1);
        driver.findElement(By.xpath(String.format(BUTTON_BY_LABEL, "Login"))).click();
        wait(1);
    }
}
