package test;

import Models.SearchCommunityMarketModel;
import Tools.DataProviderTool;
import Tools.JsonTool;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.steam.ItemPage;
import pages.steam.MainPage;
import pages.steam.MarketPage;
import pages.steam.PrivacyPolicyPage;

import java.time.Year;
import java.util.*;

public class SteamTest extends BaseTest {

    @Test(dataProviderClass = DataProviderTool.class, dataProvider = "languages_testCase1")
    public void checkLanguageListInPolicyPage(List<String> languagesList) {
        new MainPage().openPrivacyPolicyPage();
        PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage();

        int countLanguagesExpected = 9;
        Assert.assertTrue(privacyPolicyPage.checkSwitchLanguageElementsListDisplayed(countLanguagesExpected),
                "Switch language elements count are not " + countLanguagesExpected);

        Assert.assertTrue(privacyPolicyPage.checkSupportLanguages(languagesList),
                "Languages list is not as expected " + languagesList);

        int expectedYear = Year.now().getValue();
        Assert.assertTrue(privacyPolicyPage.checkRevisionCurrentYear(expectedYear),
                "Policy revision signed in not " + expectedYear);
    }

    @Test(dataProviderClass = DataProviderTool.class, dataProvider = "SearchCommunityMarketModel_testCase3")
    public void TestCase3(JSONObject jsonObject) {
        HashMap<String, String> hashMapData = JsonTool.parseJsonObjectToHashMap(jsonObject);

        MainPage mainPage = new MainPage();
        mainPage.navigateToCommunityMarket();
        MarketPage marketPage = new MarketPage();
        SearchCommunityMarketModel searchCMM = new SearchCommunityMarketModel(
                hashMapData.get("gameId"),
                hashMapData.get("heroValue"),
                hashMapData.get("rarityId"),
                hashMapData.get("SearchText"));
        marketPage.selectOptionsForSearchInDota(searchCMM);
        marketPage.advancedSearchSubmit();

        List<String> listForFilter = JsonTool.strJsonToArray(hashMapData.get("FilterList"));
        marketPage.checkAppliedFilters(listForFilter);
        marketPage.checkFirstFiveResultSearchContain("Golden");

        marketPage.deleteFilterItemsByName("\"golden\"");
        marketPage.deleteFilterItemsByName("Immortal");
        listForFilter.remove("\"golden\"");
        listForFilter.remove("Immortal");
        marketPage.checkAppliedFilters(listForFilter);

        String itemNameFromOldPage = marketPage.getNameOfItemByIndex(0);
        marketPage.openPageOfItemByIndex(0);
        ItemPage itemPage = new ItemPage();

        //  checkNameIsCompareWithOldPage
        String newItemName = itemPage.getItemName();
        Assert.assertEquals(newItemName, itemNameFromOldPage,
                "Name " + newItemName + " is not compare with name on market page" + itemNameFromOldPage);
    }

}
