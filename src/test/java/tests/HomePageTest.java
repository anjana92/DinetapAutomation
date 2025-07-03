package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HowAppWorksPopupPage;
import utils.ExcelUtils;

public class HomePageTest extends BaseTest {


    @Test
    public void verifyAndHandleLocationPermissionPopup() {
        HomePage homePage = new HomePage(driver);

        try {
            Thread.sleep(2000); // Give time for popup to appear
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (homePage.isLocationPermissionDenyButtonVisible()) {
            String actualText = homePage.getLocationPermissionDenyText().trim();
            String expectedText = ExcelUtils.getExpectedText("LocationPermissionDenyText").trim();

            System.out.println("🔍 Actual Button Text: " + actualText);
            System.out.println("📖 Expected Button Text: " + expectedText);

            Assert.assertEquals(actualText, expectedText, "❌ Location permission button text mismatch!");

            homePage.clickLocationPermissionDenyButton();
            System.out.println("✅ Location permission popup denied successfully.");
        } else {
            System.out.println("ℹ️ Location deny button not visible. Tapping top of screen as fallback.");
            homePage.tapTopOfScreen();  // fallback tap
            String actualText = homePage.getLocationPermissionDenyText().trim();
            System.out.println(actualText);
        }
    }





    @Test(dependsOnMethods = "verifyAndHandleLocationPermissionPopup")
    public void verifyLocationTexts() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForHomePageToLoad();

        // Verify Short Location
        String actualShort = homePage.getShortLocationText();
        String expectedShort = ExcelUtils.getExpectedText("ShortLocation");
        Assert.assertEquals(actualShort, expectedShort, "❌ Short location text mismatch!");
        System.out.println("✅ Short location text matched: " + actualShort);

        // Verify Full Location
        String actualFull = homePage.getFullLocationText();
        String expectedFull = ExcelUtils.getExpectedText("FullLocation");
        Assert.assertEquals(actualFull, expectedFull, "❌ Full location text mismatch!");
        System.out.println("✅ Full location text matched: " + actualFull);
    }






    @Test(dependsOnMethods = "verifyLocationTexts")
    public void verifyHomePageByWalletText() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForHomePageToLoad();

        // Verify "Your Wallets" is visible
        String actualWallet = homePage.getYourWalletsText();
        String expectedWallet = ExcelUtils.getExpectedText("YourWallets");
        Assert.assertEquals(actualWallet, expectedWallet, "❌ Your Wallets text mismatch! Not on Home Page?");
        System.out.println("✅ Confirmed Home Page: Your Wallets text matched: " + actualWallet);
    }


    @Test(dependsOnMethods = "verifyHomePageByWalletText")
    public void getLetsGoBannerText() {
        HomePage homePage = new HomePage(driver);

        String actual = homePage.getLetsGoBannerText();
        String expected = ExcelUtils.getExpectedText("HowAppWorksBanner");


        Assert.assertEquals(actual, expected, "❌ How App Works banner text mismatch!");
        System.out.println("✅ How App Works banner text matched: " + actual);
    }

    @Test(dependsOnMethods = "getLetsGoBannerText")
    public void clickHowAppWorksBannerAndVerifyPopupOpened() {
        HomePage homePage = new HomePage(driver);
        HowAppWorksPopupPage popupPage = new HowAppWorksPopupPage(driver);

        homePage.clickHowAppWorksBanner();

        // Immediately verify popup opened by checking Step 1
        Assert.assertTrue(popupPage.isStep1PopupVisible(), "❌ Popup did not open as expected after clicking banner.");
        System.out.println("✅ Popup opened successfully. Step 1 is visible.");
    }










}
