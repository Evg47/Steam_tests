package pages;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

abstract public class WorkWithBrowser {

    public static void changeToNewTab() {
        String oldTab = BasePage.getDriver().getWindowHandle();
        ArrayList<String> newTab = new ArrayList<>(BasePage.getDriver().getWindowHandles());
        newTab.remove(oldTab);
        BasePage.getDriver().switchTo().window(newTab.get(0));
    }
}
