package pages;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

abstract public class BrowserOptions {
    public static ChromeOptions setUpChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--incognito");
        options.addArguments("--start-maximized ");
        return options;
    }
}
