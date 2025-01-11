package search;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Landing {
    // variables
    private WebDriver driver;
    private String url = "https://duckduckgo.com/";

    // locators
    private By searchInput = By.id("searchbox_input");

    // constructor
    public Landing(WebDriver driver){
        this.driver = driver;
    }

    // actions(Keywords)
    public Landing navigate(){
        driver.navigate().to(url);
        return this;
    }

    public Results search(String query){
        driver.findElement(searchInput).sendKeys(query+ Keys.ENTER);
        return new Results(driver);
    }
}
