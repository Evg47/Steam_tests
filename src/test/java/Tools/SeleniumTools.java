package Tools;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;

abstract public class SeleniumTools {
    public static void webDriverWaitWebElement(WebElement waitElement){
        new WebDriverWait(BasePage.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(waitElement));
    }
}
