package testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestClass6 {
    // login, add item to cart, checkout, pay using credit card, confirm order is placed

    WebDriver driver;

    @Test
    public void addToCart() {
        System.out.println("Adding item to cart");
    }

    @Test(dependsOnMethods = "addToCart")
    public void payUsingCreditCard() {
        System.out.println("Paying using credit card");
    }

    @Test(dependsOnMethods = {"addToCart", "payUsingCreditCard"})
    public void confirmOrderStatusIsPlaced() {
        System.out.println("Confirming order status is placed");
    }

    @BeforeClass
    public void setup() {
        //init browser
        // navigate
        // login
        System.out.println("Setting up browser");
    }

    @AfterClass
    public void tearDown() {
        //close browser
        System.out.println("Tearing down browser");
    }
}
