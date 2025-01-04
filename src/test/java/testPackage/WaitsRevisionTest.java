package testPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WaitsRevisionTest {
    @Test
    public void test() {
        WebDriver driver;
        Wait<WebDriver> wait;

        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(2))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(NotFoundException.class)
                        .ignoring(StaleElementReferenceException.class)
                        .ignoring(ElementNotInteractableException.class);

        By adderButton = By.id("adder");

        // option 1
        wait.until(d -> driver.findElement(adderButton).isDisplayed());
//        wait.until(ExpectedConditions.visibilityOfElementLocated(adderButton));
        driver.findElement(adderButton).click();

        // option 2
        wait.until(d -> {
            driver.findElement(adderButton).click();
            return true;
        });
    }
}
