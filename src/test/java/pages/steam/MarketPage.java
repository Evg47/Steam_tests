package pages.steam;


import Models.SearchCommunityMarketModel;
import Tools.SeleniumTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.BasePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MarketPage {
    private WebDriver driver;
    @FindBy(id = "market_search_advanced_show")
    private WebElement showAdvancedOptions;

    @FindBy(id = "market_advancedsearch_appselect_activeapp")
    private WebElement dropDownAllGames;

    @FindBy(css = "[name=\"category_570_Hero[]\"]")
    private WebElement dropDownHeroDota;

    @FindBy(id = "advancedSearchBox")
    private WebElement advancedSearchBox;
    @FindBy(id = "advancedSearchSubmit")
    private WebElement advancedSearchSubmitBtn;

    @FindBy(css = "div.market_search_results_header > div a.market_searchedForTerm")
    private List<WebElement> listFilterItems;

    public MarketPage() {
        driver = BasePage.getDriver();
        PageFactory.initElements(driver, this);
    }

    private void openShowAdvancedOptions() {
        showAdvancedOptions.click();
    }

    private void advancedOptionsSelectGameById(String idGame) {
        dropDownAllGames.click();
        driver.findElement(By.id(idGame)).click();
    }

    public void deleteFilterItemsByName(String filterItemName) {
        for (WebElement item : listFilterItems) {
            if (item.getText().equals(filterItemName)) {
                item.click();
            }
        }
    }

    public void selectOptionsForSearchInDota(SearchCommunityMarketModel SearchCMM) {
        openShowAdvancedOptions();
        advancedOptionsSelectGameById(SearchCMM.getGameId());
        selectHeroDotaByValue(SearchCMM.getHeroValue());
        selectRarityById(SearchCMM.getRarityId());
        advancedSearchBoxSendText(SearchCMM.getSearchText());

    }

    private void selectHeroDotaByValue(String heroValue) {
        SeleniumTools.webDriverWaitWebElement(dropDownHeroDota);
        dropDownHeroDota.click();
        new Select(dropDownHeroDota).selectByValue(heroValue);
        dropDownHeroDota.click();
    }

    private void selectRarityById(String rarityId) {
        driver.findElement(By.id(rarityId)).click();
    }

    public void advancedSearchBoxSendText(String text) {
        advancedSearchBox.sendKeys(text);
    }

    public void advancedSearchSubmit() {
        advancedSearchSubmitBtn.click();
    }

    public void checkAppliedFilters(List<String> filterItemNamesExpected) {
        List<String> filterItemNamesExpectedCopy = new ArrayList<>(filterItemNamesExpected);

        List<String> filterItemNamesActual = new ArrayList<>();
        for (WebElement item : listFilterItems) {
            filterItemNamesActual.add(item.getText());
        }

        filterItemNamesExpectedCopy.replaceAll(String::toLowerCase);
        filterItemNamesActual.replaceAll(String::toLowerCase);

        //sorting lists for comparison
        Collections.sort(filterItemNamesExpectedCopy);
        Collections.sort(filterItemNamesActual);

        Assert.assertEquals(filterItemNamesActual, filterItemNamesExpectedCopy,
                "filter items " + filterItemNamesActual + " is not as expected " + filterItemNamesExpectedCopy);
    }

    public void checkFirstFiveResultSearchContain(String containExpected) {
        List<String> results = getListOfItems(5);
        results.replaceAll(String::toLowerCase);
        containExpected = containExpected.toLowerCase();
        for (String actualStr : results) {
            Assert.assertTrue(actualStr.contains(containExpected),
                    "the search result [" + actualStr + "] does not contain " + containExpected);
        }
    }

    private List<String> getListOfItems(int itemsCount) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < itemsCount; i++) {
            results.add(driver.findElement(By.id("result_" + i + "_name")).getText());
        }
        return results;
    }


    public void openPageOfItemByIndex(int i) {
        driver.findElement(By.id("result_" + i)).click();
    }

    public String getNameOfItemByIndex(int i) {
        return driver.findElement(By.id("result_" + i + "_name")).getText();
    }
}
