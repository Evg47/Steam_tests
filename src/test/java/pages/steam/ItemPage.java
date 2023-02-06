package pages.steam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;

public class ItemPage{
    private WebDriver driver;
    @FindBy(id = "largeiteminfo_item_name")
    private WebElement itemName;

    public ItemPage() {
        driver = BasePage.getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getItemName(){
        return itemName.getText();
    }
}
