package pages.steam;

import Tools.JsonTool;
import Tools.SeleniumTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.WorkWithBrowser;
import readProperties.PropertiesTest;

public class MainPage {
    private WebDriver driver;

    @FindBy(css = ".supernav_container [data-tooltip-content=\".submenu_community\"]")
    private WebElement community;

    @FindBy(css = ".content .submenu_community [href$=\"/market/\"]")
    private WebElement communityMarket;

    @FindBy(css = "#footer_text [href*=\"privacy_agreement\"]")
    private WebElement privacyPolicy;

    public MainPage() {
        driver = BasePage.getDriver();
        driver.get(PropertiesTest.getProperty("url"));
        PageFactory.initElements(driver, this);
    }

    public void navigateToCommunityMarket() {
        SeleniumTools.webDriverWaitWebElement(community);
        new Actions(driver).moveToElement(community).build().perform();
        communityMarket.click();
    }

    public void openPrivacyPolicyPage() {
        new Actions(driver).scrollToElement(privacyPolicy).perform();
        privacyPolicy.click();
        WorkWithBrowser.changeToNewTab();
    }


}
