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

    @Test(dependsOnMethods = "verifyAppearancePopupClosesOnCloseTap")
    public void verifyLanguageTextWithExcelData() {
        YourProfilePage profilePage = new YourProfilePage(driver);
        Assert.assertTrue(profilePage.verifyLanguageTextFromExcel(), "'Language' text does not match expected value from Excel.");
    }


    @Test(dependsOnMethods = "verifyLanguageTextWithExcelData")
    public void verifyChangeLanguagePopupAppearsCorrectly() {
        YourProfilePage profilePage = new YourProfilePage(driver);

        // Step 1: Tap the Language option
        profilePage.tapLanguageOption();

        // Step 2: Assert popup title using Excel-driven value
        Assert.assertTrue(profilePage.isChangeLanguagePopupOpenedCorrectly(),
                "'Change Language' popup did not appear correctly or title mismatched.");
    }


    @Test(dependsOnMethods = "verifyChangeLanguagePopupAppearsCorrectly")
    public void verifyEnglishUSTextMatchesExcel() {
        YourProfilePage profilePage = new YourProfilePage(driver);
        String expected = ExcelUtils.getExpectedText("LanguageOptionEnglishUS");
        String actual = profilePage.getEnglishUSText();
        Assert.assertEquals(actual, expected, "Mismatch for English (US)");
    }

    @Test(dependsOnMethods = "verifyChangeLanguagePopupAppearsCorrectly")
    public void verifyEnglishUKTextMatchesExcel() {
        YourProfilePage profilePage = new YourProfilePage(driver);
        String expected = ExcelUtils.getExpectedText("LanguageOptionEnglishUK");
        String actual = profilePage.getEnglishUKText();
        Assert.assertEquals(actual, expected, "Mismatch for English (UK)");
    }

    @Test(dependsOnMethods = "verifyChangeLanguagePopupAppearsCorrectly")
    public void verifyEnglishAUTextMatchesExcel() {
        YourProfilePage profilePage = new YourProfilePage(driver);
        String expected = ExcelUtils.getExpectedText("LanguageOptionEnglishAU");
        String actual = profilePage.getEnglishAUText();
        Assert.assertEquals(actual, expected, "Mismatch for English (AU)");
    }

    @Test(dependsOnMethods = "verifyChangeLanguagePopupAppearsCorrectly")
    public void verifyFrenchTextMatchesExcel() {
        YourProfilePage profilePage = new YourProfilePage(driver);
        String expected = ExcelUtils.getExpectedText("LanguageOptionFrench");
        String actual = profilePage.getFrenchText();
        Assert.assertEquals(actual, expected, "Mismatch for Le français");
    }


    @Test(dependsOnMethods = "verifyFrenchTextMatchesExcel")
    public void verifyLanguagePopupClosesOnCloseTap() {
        YourProfilePage profilePage = new YourProfilePage(driver);

        profilePage.closeLanguagePopup();

        Assert.assertTrue(profilePage.isLanguagePopupClosed(), "Change Language popup did not close after tapping close icon.");
    }

    @Test(dependsOnMethods = "verifyLanguagePopupClosesOnCloseTap")
    public void verifyPopupClosesOnOutsideClickUsingYourProfile() {
        YourProfilePage profilePage = new YourProfilePage(driver);

        // Step 1: Tap Language to open popup
        profilePage.tapLanguageOption();
        Assert.assertTrue(profilePage.isChangeLanguagePopupOpenedCorrectly(),
                "Popup did not open before tapping outside.");

        // Step 2: Tap outside (on Your Profile title)
        profilePage.tapOutsidePopupUsingProfileTitle();

        // Step 3: Verify popup closed
        Assert.assertTrue(profilePage.isLanguagePopupClosed(),
                "Popup did not close after tapping on 'Your Profile' outside the popup.");
    }

    @Test(dependsOnMethods = "verifyPopupClosesOnOutsideClickUsingYourProfile")
    public void verifyHelpSupportTextMatchesExcel() {
        YourProfilePage profilePage = new YourProfilePage(driver);
        String expected = ExcelUtils.getExpectedText("ProfileHelpLabel");
        String actual = profilePage.getHelpSupportText();
        Assert.assertEquals(actual, expected, "Mismatch in 'Help & Support' text.");
    }

    @Test(dependsOnMethods = "verifyPopupClosesOnOutsideClickUsingYourProfile")
    public void verifyTermsPrivacyTextMatchesExcel() {
        YourProfilePage profilePage = new YourProfilePage(driver);
        String expected = ExcelUtils.getExpectedText("ProfileTermsLabel");
        String actual = profilePage.getTermsPrivacyText();
        Assert.assertEquals(actual, expected, "Mismatch in 'Terms & Privacy' text.");
    }

    @Test(dependsOnMethods = "verifyPopupClosesOnOutsideClickUsingYourProfile")
    public void verifySendFeedbackTextMatchesExcel() {
        YourProfilePage profilePage = new YourProfilePage(driver);
        String expected = ExcelUtils.getExpectedText("ProfileSendFeedbackLabel");
        String actual = profilePage.getSendFeedbackText();
        Assert.assertEquals(actual, expected, "Mismatch in 'Send Feedback' text.");
    }

    @Test(dependsOnMethods = "verifySendFeedbackTextMatchesExcel")
    public void verifyFeedbackPopupOpensCorrectly() {
        YourProfilePage profilePage = new YourProfilePage(driver);

        // Step 1: Tap on 'Send Feedback'
        profilePage.tapSendFeedback();

        // Step 2: Get actual title from UI
        String actual = profilePage.getFeedbackPopupTitleText();

        // Step 3: Get expected text from Excel
        String expected = ExcelUtils.getExpectedText("FeedbackPopupTitle");

        // Step 4: Assert
        Assert.assertEquals(actual, expected, "'Tell us about it!' popup title mismatch.");
    }




}
