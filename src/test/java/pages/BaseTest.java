package pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


abstract public class BaseTest {

    @BeforeMethod
    public void setUp() {
        BasePage.getInstance();
    }

    @AfterMethod
    public void tearDown() {
        BasePage.getInstance().closeBrowser();
    }
}
