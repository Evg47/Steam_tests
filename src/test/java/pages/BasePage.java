package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class BasePage {
    private static BasePage instance;
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    private BasePage() {
    }

    public static BasePage getInstance() {
        if (instance == null) {
            instance = new BasePage();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(BrowserOptions.setUpChromeOptions());
        }
        return instance;
    }

    public void closeBrowser() {
        driver.quit();
        instance = null;
    }

}
