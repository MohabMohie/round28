package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass3 {

    /**
     * #7
     * ________________ Moderate ________________
     * Open Google Chrome
     * Navigate to [https://www.w3schools.com/html/html_tables.asp]
     * Assert that the Country for the Company [Ernst Handel] is [Austria]
     * Close Google Chrome
     */
    @Test
    public void handlingTablesTest() {
        // variables declaration
        WebDriver driver;
        Wait<WebDriver> wait;

        // setup
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.enableBiDi();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        driver = new ChromeDriver(chromeOptions);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(AssertionError.class)
        ;

        driver.manage().window().maximize();

        // test steps
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");

        By countryNameLabel = By.xpath("//tr[contains(.,'Ernst Handel')]/td[3]");

        wait.until(d -> {
            String countryName = driver.findElement(countryNameLabel).getText();
            Assert.assertEquals(countryName, "Austria");
            return true;
        });

//        // not recommended due to failure message being non-descriptive
//        By companyRow = By.xpath("//tr[contains(.,'Ernst Handel')]");
//
//        wait.until(d -> {
//            String companyRowText = driver.findElement(companyRow).getText();
//            Assert.assertTrue(companyRowText.contains("Austriadddd"));
//            return true;
//        });

//        driver.findElement(countryNameLabel).click();
//        driver.findElement(countryNameLabel).sendKeys("string" + Keys.ENTER);
//
//        driver.findElement(countryNameLabel).getText();
//        driver.findElement(countryNameLabel).getDomAttribute("class");
//        driver.findElement(countryNameLabel).getDomProperty("class");
//

        // tear down
        driver.quit();
    }
}
