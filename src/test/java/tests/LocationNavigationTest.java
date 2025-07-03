package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LocationPage;
import utils.ExcelUtils;

public class LocationNavigationTest extends BaseTest {

    @Test
    public void verifyNavigationToLocationPage() {
        HomePage homePage = new HomePage(driver);
        LocationPage locationPage = new LocationPage(driver);

        // Wait briefly to allow location popup to appear
        try {
            Thread.sleep(2000); // Wait 2 seconds (adjust if needed)
            System.out.println("📌 Tapping top of screen to dismiss location popup...");
            new HomePage(driver).tapTopOfScreen(); // Tap to dismiss popup
        } catch (Exception e) {
            e.printStackTrace();
        }



        // Click short location
        homePage.clickShortLocation();
        System.out.println("👉 Clicked on short location.");

        // Optional: Replace with WebDriverWait in production
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.tapTopOfScreen();
        // Verify search placeholder
        String expectedPlaceholder = ExcelUtils.getExpectedText("LocationSearchPlaceholder");
        String actualPlaceholder = locationPage.getSearchPlaceholderText();

        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "❌ Search placeholder text mismatch.");
        System.out.println("✅ Search placeholder text matched: " + actualPlaceholder);
    }

    @Test(dependsOnMethods = "verifyNavigationToLocationPage")
    public void verifyDefaultLocationLinkage() {
        LocationPage locationPage = new LocationPage(driver);

        // Check "Use default location" text is visible
        Assert.assertTrue(locationPage.isUseDefaultLocationVisible(), "❌ 'Use default location' text not visible.");

        // Get actual default location text
        String actualDefaultLocation = locationPage.getActualDefaultLocationText();

        // Get expected from Excel
        String expectedDefaultLocation = ExcelUtils.getExpectedText("ExpectedDefaultLocation");

        // Verify default location text
        Assert.assertEquals(actualDefaultLocation, expectedDefaultLocation,
                "❌ Default location text does not match expected value.");

        System.out.println("✅ Default location is correctly linked: " + actualDefaultLocation);
    }
}
