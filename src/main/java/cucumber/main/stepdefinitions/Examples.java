package cucumber.main.stepdefinitions;

import org.openqa.selenium.By;

/**
 * Created by jboiko on 25/11/2017.
 */
public class Examples {

    private static final By CAROUSEL_CONTAINS_ACTIVE_TITLE = By.cssSelector("#carousel li[class*='active'] .contextual-nav__title");

    private static final By ACTIVE_SELECTION = By.cssSelector("[id^='OB_EV']:not(.disabled-event)" +
            " [id^='OB_MA'][data-status='A']:not(.disabled-market) [id^='OB_OU']" +
            "[data-status='A']:not(.disabled)");

    private static final By WH_LOGO = By.cssSelector("a[href^='/betting/'][title*='William Hill']");

    private final By LOGIN_BUTTON = By.xpath("//form[@id='account']//button[contains(@class,'button')]");

    private static final String RACE_MEETING_SELECTION_BY_MEETING = "#%s .race-meeting__selection";

    private static final String ONE_MM_DROP_DOWN_MENU = "//div[@class='omm-dropdown__nav']//div[contains(@id, '%s')]";

    private static final String AVAILABLE_CIMB_CONFIRMATION_BUTTONS = ".betslip-cashin:not(.ng-hide) .betslip-cashin__confirmation:not(.ng-hide)";

    private final static String MENU_SUBMENU_ELEMENT = "li[data-id-en='nav-%s-%s'] a";

    private static final By TOMORROW_TAB = By.xpath("//a[contains(@class,'today')]/../a[2]");

    // $(competition).attr("class").contains("-expanded"))

    //$(By.xpath("//section[contains(@class,'-expanded')]")).$$(By.xpath("//*[@class='race-group-content__item']"));

    // String competitionId = competitionList.get(0).$(By.xpath(".//div[contains(@id,'OB_TY')]")).attr("id");


    /*
    public boolean waitForBalanceValue(String expectedValue, long timeout) {
        return $(ACCOUNT_BALANCE).waitUntil(text(expectedValue), timeout * 1000).isDisplayed();
    }

    public void clickOnTheFirstAllRaces() {
        $(By.xpath("(//button[contains(@class,'race-meeting__allRaces')])[1]")).click();
        waitSportsbook();
    }

    private boolean properMeeting(WebElement meeting) {
        return (!$(meeting).attr("data-name").equalsIgnoreCase("Meeting Markets") &&
                !$(meeting).has(attribute("data-status", "S")));
    }


    public void clickOnLoginButton() {
        $(LOGIN_BUTTON).waitUntil(visible, 10000).shouldBe(enabled).click();
        waitSportsbook();
        if ($(CLOSE_WELCOME_MESSAGE_BUTTON).isDisplayed()) {
            $(CLOSE_WELCOME_MESSAGE_BUTTON).click();
        }
    }

    */
}
