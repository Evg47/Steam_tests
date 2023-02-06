package Tools;

import org.testng.annotations.DataProvider;
import readProperties.PropertiesTest;

public class DataProviderTool {

    @DataProvider
    public Object[][] languages_testCase1() {
        return JsonTool.getArrayOnObject(PropertiesTest.getProperty("testDataNameFile"), "languages_testCase1");
    }

    @DataProvider
    public Object[][] SearchCommunityMarketModel_testCase3() {
        return JsonTool.getJSONObjectByName(PropertiesTest.getProperty("testDataNameFile"),"SearchCommunityMarketModel_testCase3");
    }

}
