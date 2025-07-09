package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
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

        HomePage homePage = new HomePage(driver);

        //tap on short location while in the home page
        homePage.clickShortLocation();
        System.out.println("👉 Clicked on short location.");

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


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



    @Test(dependsOnMethods ="verifyNoResultsFoundForNonExistingTerm")
    public void verifyCancelButtonText() {
        LocationSearchResultsPage locationPage = new LocationSearchResultsPage(driver);
        HomePage homePage = new HomePage(driver);

        // Get the actual Cancel button text
        String actualCancelText = locationPage.getCancelButtonText();

        // Get expected text from Excel (sheet should have a key like CancelButtonText)
        String expectedCancelText = ExcelUtils.getExpectedText("CancelButtonText");

        System.out.println("Actual Cancel Button Text: " + actualCancelText);
        System.out.println("Expected Cancel Button Text: " + expectedCancelText);

        //this is just to remove the location permission pop up appearance
        homePage.tapTopOfScreen();

        Assert.assertEquals(actualCancelText, expectedCancelText, "Cancel button text mismatch!");
    }

    @Test(dependsOnMethods = "verifyCancelButtonText")
    public void verifyCancelNavigationToHomePage() throws InterruptedException {
        LocationSearchResultsPage locationPage = new LocationSearchResultsPage(driver);
        HomePage homePage = new HomePage(driver);

        // Click the Cancel button
        locationPage.clickCancelButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //this is just to remove the location permission pop up appearance
        homePage.tapTopOfScreen();

        // Verify HomePage loaded (check for "Your Wallets" text)
        String actualWalletText = homePage.getYourWalletsText();
        String expectedWalletText = ExcelUtils.getExpectedText("YourWallets");

        System.out.println("Actual Your Wallets Text: " + actualWalletText);
        System.out.println("Expected Your Wallets Text: " + expectedWalletText);

        Assert.assertEquals(actualWalletText, expectedWalletText, "Navigation to Home Page failed!");
    }


    @Test(dependsOnMethods =  "verifyCancelNavigationToHomePage")
    public void verifyFilteredLocationNavigatesToHomePage() {
        HomePage homePage = new HomePage(driver);
        LocationSearchResultsPage locationPage = new LocationSearchResultsPage(driver);

        //this is just to remove the location permission pop up appearance
        homePage.tapTopOfScreen();

        // Step 1: Click on short location to open search
        homePage.clickShortLocation();



        // Step 2: Get search term from Excel
        String searchTerm = ExcelUtils.getExpectedText("UniqueSearchAddress");

        // Step 3: Enter search term in search box using the correct xpath
        locationPage.enterSearchTermUsingPlaceholder(searchTerm);

        // Step 4: Click on filtered location (exact text match)
        locationPage.clickFilteredLocationByExactText(searchTerm);


        // Step 5: Verify Home Page loaded (Your Wallets visible)
        String actualWalletText = homePage.getYourWalletsText();
        String expectedWalletText = ExcelUtils.getExpectedText("YourWallets");
        System.out.println("✅ Actual Your Wallets text: " + actualWalletText);
        Assert.assertEquals(actualWalletText, expectedWalletText, "User did not navigate to Home Page!");
    }

    @Test(dependsOnMethods = "verifyFilteredLocationNavigatesToHomePage")
    public void verifySelectedAddressDisplayedOnTopBar() {
        HomePage homePage = new HomePage(driver);

        //this is just to remove the location permission pop up appearance
        homePage.tapTopOfScreen();

        // Get expected address from Excel
        String expectedAddress = ExcelUtils.getExpectedText("UniqueSearchAddress");

        // Verify top bar address
        String actualTopBarAddress = homePage.getTopBarAddressByExactText(expectedAddress);
        System.out.println("✅ Actual Top Bar Address: " + actualTopBarAddress);
        Assert.assertEquals(actualTopBarAddress, expectedAddress, "Top bar address does not match selected address!");
    }


    @Test(dependsOnMethods = "verifySelectedAddressDisplayedOnTopBar")
    public void resetToDefaultAddressAndVerify() {
        HomePage homePage = new HomePage(driver);
        LocationSearchResultsPage locationPage = new LocationSearchResultsPage(driver);

        //this is just to remove the location permission pop up appearance
        homePage.tapTopOfScreen();

        // Step 1: Click on short location to open the search
        homePage.clickShortLocation2();



        // Step 2: Get default address (FullLocation) from Excel
        String defaultAddress = ExcelUtils.getExpectedText("FullLocation");
        Assert.assertNotNull(defaultAddress, "❌ Default address (FullLocation) missing in Excel!");

        // Step 3: Enter default address in search box
        locationPage.enterSearchTermUsingPlaceholder(defaultAddress);

        // Step 4: Click on filtered location that matches default address
        locationPage.clickFilteredLocationByExactText(defaultAddress);

        //this is just to remove the location permission pop up appearance
        homePage.tapTopOfScreen();

        // Step 5: Verify Home Page loaded (Your Wallets visible)
        String actualWalletText = homePage.getYourWalletsText();
        String expectedWalletText = ExcelUtils.getExpectedText("YourWallets");
        System.out.println("✅ Actual Your Wallets text after resetting: " + actualWalletText);
        Assert.assertEquals(actualWalletText, expectedWalletText, "User did not navigate to Home Page after resetting!");

        // Step 6: Verify top bar address is the default address
        String actualTopBarAddress = homePage.getTopBarAddressByExactText(defaultAddress);
        System.out.println("✅ Actual Top Bar Address after resetting: " + actualTopBarAddress);
        Assert.assertEquals(actualTopBarAddress, defaultAddress, "Top bar address does not match default address!");
    }






}




