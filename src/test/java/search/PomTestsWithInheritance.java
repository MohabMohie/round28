package search;

import org.testng.annotations.Test;
import testTemplate.TestCase;

public class PomTestsWithInheritance extends TestCase{
    @Test
    public void checkSecondResultTitle() {
        new Landing(driver).navigate()
                .search("Selenium WebDriver")
                .assertResultTitle(3, "UserGuide");
    }
}
