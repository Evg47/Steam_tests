package pages.steam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrivacyPolicyPage {
    private WebDriver driver;
    @FindBy(css = "#languages>a")
    private List<WebElement> languagesList;

    @FindBy(xpath = "//*[@id=\"newsColumn\"]/i[3]")
    private WebElement RevisionDate;

    public PrivacyPolicyPage() {
        driver = BasePage.getDriver();
        PageFactory.initElements(driver, this);
    }

    public int getLanguagesListSize(){
        return languagesList.size();
    }
    public boolean checkSwitchLanguageElementsListDisplayed(int countLanguagesExpected) {
        Integer countLanguages = languagesList.size();
        return countLanguages.equals(countLanguagesExpected);
    }

    public boolean checkSupportLanguages(List<String> listLanguagesExpected) {
        List<String> languagesListActual = getCountriesFromUrlsWebElements(languagesList);

        listLanguagesExpected.replaceAll(String::toLowerCase);
        languagesListActual.replaceAll(String::toLowerCase);
        //sorting lists for comparison
        Collections.sort(listLanguagesExpected);
        Collections.sort(languagesListActual);
        return languagesListActual.equals(listLanguagesExpected);

    }

    private List<String> getCountriesFromUrlsWebElements(List<WebElement> languagesListWeb) {
        List<String> languagesListActual = new ArrayList<>();
        Matcher matcher;
        for (WebElement a : languagesListWeb) {
            try {
                matcher = Pattern.compile(("privacy_agreement\\/(.*?)\\/$")).matcher(a.getAttribute("href"));
                if(matcher.find()) {
                    languagesListActual.add(matcher.group(1).toLowerCase());
                }
            } catch (IllegalStateException | IndexOutOfBoundsException ex) {
                throw new RuntimeException(ex);
            }
        }
        return languagesListActual;
    }


    public boolean checkRevisionCurrentYear(int expectedYear) {
        String[] arr = RevisionDate.getText().split(",");
        Integer revisionYear = Integer.parseInt(arr[1].replace(" ", ""));
        return revisionYear.equals(expectedYear);
    }
}
