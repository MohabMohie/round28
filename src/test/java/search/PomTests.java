package search;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PomTests {
    WebDriver driver;
    Wait<WebDriver> wait;
    Landing landingPage;
    Results resultsPage;

    @Test
    public void checkSecondResultTitle() {
        new Landing(driver).navigate()
                .search("Selenium WebDriver")
                .assertResultTitle(3, "UserGuide");
    }

    @Test
    public void checkThirdResultTitle() {
        String searchResultTitle = new Landing(driver).navigate().search("TestNG").getSearchResultTitle(3);
        Assert.assertEquals(searchResultTitle, "TestNG Tutorial");
    }

    @Test
    public void checkFourthResultTitle() {
        landingPage.navigate();
        landingPage.search("TestNG");
        String searchResultTitle = resultsPage.getSearchResultTitle(4);
        Assert.assertEquals(searchResultTitle, "TestNG Tutorial - GeeksforGeeks");
    }

    @Test
    public void checkFifthResultTitle() {
        driver.navigate().to("https://duckduckgo.com/");
        By searchInput = By.id("searchbox_input");
        driver.findElement(searchInput).sendKeys("Selenium WebDriver" + Keys.ENTER);
        int targetSearchResult = 5;
        By dynamicSearchResult = By.xpath("(//li[@data-layout='organic'])["+targetSearchResult+"]//a[@data-testid='result-title-a']");
        String searchResultTitle = driver.findElement(dynamicSearchResult).getText();
        Assert.assertEquals(searchResultTitle, "Selenium WebDriver");
    }

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(AssertionError.class)
        ;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        landingPage = new Landing(driver);
        resultsPage = new Results(driver);

        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
