package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LocationSearchResultsPage;
import utils.ExcelUtils;

import java.time.Duration;
import java.util.List;

public class LocationSearchResultsTest extends BaseTest {

    LocationSearchResultsPage searchPage;
    String searchTerm;

    @Test
    public void enterSearchTerm() {
        searchPage = new LocationSearchResultsPage(driver);

        searchTerm = ExcelUtils.getExpectedText("LocationSearchTerm1");
        Assert.assertNotNull(searchTerm, "❌ Search term missing in Excel for key: LocationSearchTerm1");

        searchPage.enterSearchTerm(searchTerm);
        System.out.println("✅ Entered search term: " + searchTerm);

        // Wait for either Malls or Addresses section to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(d -> searchPage.isMallsSectionPresent() || searchPage.isAddressesSectionPresent());
    }

    @Test(dependsOnMethods = "enterSearchTerm")
    public void verifyMallsSectionPresence() {
        if (searchPage.isMallsSectionPresent()) {
            System.out.println("✅ Malls section is visible for search term: " + searchTerm);
        } else {
            System.out.println("ℹ️ Malls section not present for search term: " + searchTerm);
        }
    }

    @Test(dependsOnMethods = "enterSearchTerm")
    public void verifyMallResultsContainSearchTerm() {
        if (searchPage.isMallsSectionPresent()) {
            List<WebElement> mallResults = searchPage.getMallResults();
            Assert.assertFalse(mallResults.isEmpty(), "❌ No mall results displayed.");

            System.out.println("📝 Mall Results for '" + searchTerm + "':");
            for (WebElement mall : mallResults) {
                String mallText = mall.getText();
                System.out.println("👉 " + mallText);
                Assert.assertTrue(mallText.toLowerCase().contains(searchTerm.toLowerCase()),
                        "❌ Irrelevant mall result: " + mallText);
            }
            System.out.println("✅ All mall results contain: " + searchTerm);
        }
    }

    @Test(dependsOnMethods = "enterSearchTerm")
    public void verifyAddressesSectionPresence() {
        if (searchPage.isAddressesSectionPresent()) {
            System.out.println("✅ Addresses section is visible for search term: " + searchTerm);
        } else {
            System.out.println("ℹ️ Addresses section not present for search term: " + searchTerm);
        }
    }

    @Test(dependsOnMethods = "enterSearchTerm")
    public void verifyAddressResultsContainSearchTerm() {
        if (searchPage.isAddressesSectionPresent()) {
            List<WebElement> addressResults = searchPage.getAddressResults();
            Assert.assertFalse(addressResults.isEmpty(), "❌ No address results displayed.");

            System.out.println("📝 Address Results for '" + searchTerm + "':");
            for (WebElement addr : addressResults) {
                String addrText = addr.getText();
                System.out.println("👉 " + addrText);
                Assert.assertTrue(addrText.toLowerCase().contains(searchTerm.toLowerCase()),
                        "❌ Irrelevant address result: " + addrText);
            }
            System.out.println("✅ All address results contain: " + searchTerm);
        }
    }



    @Test(dependsOnMethods = {
            "enterSearchTerm",
            "verifyMallsSectionPresence",
            "verifyMallResultsContainSearchTerm",
            "verifyAddressesSectionPresence",
            "verifyAddressResultsContainSearchTerm"
    })
    public void verifyFilteredResultTextMatchesSearchTerm() {
        searchPage = new LocationSearchResultsPage(driver);

        String searchTerm = ExcelUtils.getExpectedText("ExactLocationSearchTerm");
        Assert.assertNotNull(searchTerm, "❌ Search term not found in Excel for key: ExactLocationSearchTerm");

        searchPage.enterSearchTerm(searchTerm);
        System.out.println("✅ Sent search term: " + searchTerm);

        String actualText = searchPage.getFilteredResultTextContaining(searchTerm);
        System.out.println("👉 Actual filtered result: " + actualText);

        Assert.assertTrue(actualText.toLowerCase().contains(searchTerm.toLowerCase()),
                "❌ Filtered result does not contain the search term\nExpected to contain: " + searchTerm + "\nActual: " + actualText);

        System.out.println("✅ Filtered result contains the search term as expected");
    }



    @Test(dependsOnMethods = "verifyFilteredResultTextMatchesSearchTerm")
    public void verifyNoResultsFoundForNonExistingTerm() {
        searchPage = new LocationSearchResultsPage(driver);

        String searchTerm = ExcelUtils.getExpectedText("NonExistingSearchTerm");
        Assert.assertNotNull(searchTerm, "❌ Search term not found in Excel for key: NonExistingSearchTerm");

        searchPage.enterSearchTerm(searchTerm);
        System.out.println("✅ Sent search term (expected no results): " + searchTerm);

        boolean isNoResultsVisible = searchPage.isNoResultsFoundTextVisible();

        Assert.assertTrue(isNoResultsVisible,
                "❌ Expected 'No results found' text to appear, but it did not for search term: " + searchTerm);

        System.out.println("✅ 'No results found' text displayed as expected for: " + searchTerm);
    }


}
