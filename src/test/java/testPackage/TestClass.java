package testPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass {

    @Test
    public void test() {
        WebDriver driver;
        driver = new ChromeDriver();
        //TODO: headless chrome options
        driver.manage().window().maximize();
//        driver.manage().window().setPosition(new Point(0,0));
//        driver.manage().window().setSize(new Dimension(1080,720));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
//        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");

//        driver.findElement(By.id("")).sendKeys("text");
//        driver.switchTo().activeElement().sendKeys(" more text");

//        driver.switchTo().alert().accept();
        String window1Handle = driver.getWindowHandle();
        String window2Handle = driver.switchTo().newWindow(WindowType.TAB).getWindowHandle();

        driver.switchTo().window(window1Handle);
        driver.switchTo().window(window2Handle);

//        driver.findElement()
//        driver.findElements()

//        driver.close();
        driver.quit();
    }

    @Test
    public void test2() {

    }

}
