package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.YourProfilePage;
import utils.ExcelUtils;

public class YourProfilePageTest extends BaseTest {

    @Test
    public void verifyNavigationToYourProfilePage() {
        HomePage homePage = new HomePage(driver);
        homePage.waitForHomePageToLoad(); // optional wait
        homePage.clickProfileIcon();

        YourProfilePage profilePage = new YourProfilePage(driver);
        Assert.assertTrue(profilePage.isProfilePageDisplayed(), "User is not navigated to Your Profile page.");

        String actualText = profilePage.getProfileTitleText();
        String expectedText = ExcelUtils.getExpectedText("ProfileHeading");

        System.out.println("👤 Actual Profile Heading: " + actualText);
        System.out.println("📖 Expected Profile Heading from Excel: " + expectedText);

        Assert.assertEquals(actualText.trim(), expectedText.trim(), "Profile title text mismatch!");
    }


    @Test(dependsOnMethods = {"verifyNavigationToYourProfilePage"})
    public void verifyAppearanceOptionVisibleInProfile() {
        YourProfilePage profilePage = new YourProfilePage(driver);  // assuming you're already inside

        String actualLabel = profilePage.getAppearanceLabel();
        String expectedLabel = ExcelUtils.getExpectedText("ProfileAppearance");

        System.out.println("🎨 Actual Appearance Label: " + actualLabel);
        System.out.println("📖 Expected from Excel: " + expectedLabel);

        Assert.assertEquals(actualLabel.trim(), expectedLabel.trim(), "'Appearance' label text mismatch in Profile screen.");
    }


    @Test(dependsOnMethods = {"verifyAppearanceOptionVisibleInProfile"})
    public void verifyAppearancePopupAfterTap() {
        YourProfilePage profilePage = new YourProfilePage(driver);  // already inside profile

        profilePage.tapAppearanceOption(); // opens the popup

        String actualText = profilePage.getAppearancePopupText();
        String expectedText = ExcelUtils.getExpectedText("AppearancePopupTitle");

        System.out.println("🧩 Actual popup title: " + actualText);
        System.out.println("📖 Expected from Excel: " + expectedText);

        Assert.assertEquals(actualText.trim(), expectedText.trim(), "Appearance popup title mismatch!");
    }

    @Test(dependsOnMethods = {"verifyAppearancePopupAfterTap"})
    public void verifySystemOptionTextInAppearancePopup() {
        YourProfilePage profilePage = new YourProfilePage(driver);
        String actualText = profilePage.getSystemTextInPopup();
        String expectedText = ExcelUtils.getExpectedText("AppearanceOptionSystem");

        System.out.println("🔎 System option text: " + actualText);
        Assert.assertEquals(actualText.trim(), expectedText.trim(), "'System' text mismatch in popup!");
    }

    @Test(dependsOnMethods = {"verifyAppearancePopupAfterTap"})
    public void verifyLightOptionTextInAppearancePopup() {
        YourProfilePage profilePage = new YourProfilePage(driver);
        String actualText = profilePage.getLightTextInPopup();
        String expectedText = ExcelUtils.getExpectedText("AppearanceOptionLight");

        System.out.println("🔎 Light option text: " + actualText);
        Assert.assertEquals(actualText.trim(), expectedText.trim(), "'Light' text mismatch in popup!");
    }

    @Test(dependsOnMethods = {"verifyAppearancePopupAfterTap"})
    public void verifyDarkOptionTextInAppearancePopup() {
        YourProfilePage profilePage = new YourProfilePage(driver);
        String actualText = profilePage.getDarkTextInPopup();
        String expectedText = ExcelUtils.getExpectedText("AppearanceOptionDark");

        System.out.println("🔎 Dark option text: " + actualText);
        Assert.assertEquals(actualText.trim(), expectedText.trim(), "'Dark' text mismatch in popup!");
    }

    @Test(dependsOnMethods = {"verifyAppearancePopupAfterTap","verifyDarkOptionTextInAppearancePopup",
            "verifyLightOptionTextInAppearancePopup"})
    public void verifyAppearancePopupClosesOnCloseTap() {
        YourProfilePage profilePage = new YourProfilePage(driver);

        profilePage.closeAppearancePopup();

        boolean isClosed = profilePage.isAppearancePopupClosed();
        System.out.println("✅ Popup closed state: " + isClosed);

        Assert.assertTrue(isClosed, "Popup did not close after tapping close icon!");
    }

}
