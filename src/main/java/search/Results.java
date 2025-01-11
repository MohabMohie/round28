package search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Results {
    // variables
    private WebDriver driver;
    // locators
    private By dynamicSearchResult;
    private By searchResultURL;

    // constructor
    public Results(WebDriver driver){
        this.driver = driver;
    }

    // actions(Keywords)
    public String getSearchResultTitle(int resultNumber) {
        dynamicSearchResult = By.xpath("(//li[@data-layout='organic'])["+resultNumber+"]//a[@data-testid='result-title-a']");
        return driver.findElement(dynamicSearchResult).getText();
    }

    public String getSearchResultURL(int resultNumber){
        searchResultURL = By.xpath("(//li[@data-layout='organic'])["+resultNumber+"]//a[@data-testid='result-title-a']");
        return driver.findElement(searchResultURL).getDomAttribute("href");
    }

    public void assertResultTitle(int resultNumber, String expectedTitle){
        dynamicSearchResult = By.xpath("(//li[@data-layout='organic'])["+resultNumber+"]//a[@data-testid='result-title-a']");
        String searchResultTitle = driver.findElement(dynamicSearchResult).getText();
        Assert.assertEquals(searchResultTitle, expectedTitle);
    }
}
