package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass4 {

    @Test
    public void testMethod() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.navigate().to("https://www.selenium.dev/selenium/web/dynamic.html");

//        //1
//        driver.findElement(By.id("adder")).click();

        //2 **** the winner
        By adderButton = By.id("adder");
        driver.findElement(adderButton).click();

//        //3 @FindBy (By.id("adder")
//        WebElement adderButton2 = driver.findElement(By.id("adder"));
//        adderButton2.click();

        By redBox = By.id("box0");
        boolean isRedBoxDisplayed = driver.findElement(redBox).isDisplayed();

        Assert.assertTrue(isRedBoxDisplayed);

        driver.quit();
    }
}
