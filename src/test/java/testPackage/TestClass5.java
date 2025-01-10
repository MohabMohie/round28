package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass5 {
    WebDriver driver;
    Wait<WebDriver> wait;

    @Test
    public void testMethod() {
        driver.navigate().to("https://duckduckgo.com/");

        // identify search box
        By searchInput = By.id("searchbox_input");
        // type search query
        driver.findElement(searchInput).sendKeys("TestNG" + Keys.ENTER);
        // press enter

        // Synchronization point

        int targetSearchResult = 4;
        By dynamicSearchResult = By.xpath("(//li[@data-layout='organic'])["+targetSearchResult+"]//a[@data-testid='result-title-a']");

        wait.until(d -> {
            String searchResultTitle = driver.findElement(dynamicSearchResult).getText();
            Assert.assertEquals(searchResultTitle, "TestNG Tutorial");
            return true;
        });

    }

    @BeforeClass
    public void setup() {
        driver = new FirefoxDriver();
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(AssertionError.class)
        ;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
