package tests;

import base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OnboardingPage;
import utils.ExcelUtils;

public class OnboardingTest extends BaseTest {

    @Test
    public void verifyOnboardingScreen1Title() {
        OnboardingPage onboarding = new OnboardingPage(driver);
        String actual = onboarding.getScreen1TitleText().replaceAll("\\s+", " ").trim();
        String expected = ExcelUtils.getExpectedText("OnboardingScreen1Title").trim();

        System.out.println("🔍 Actual Title: " + actual);
        System.out.println("📖 Expected Title: " + expected);
        Assert.assertEquals(actual, expected, "❌ Title mismatch on Onboarding Screen 1!");
    }

    @Test(dependsOnMethods = "verifyOnboardingScreen1Title")
    public void verifyOnboardingScreen1Description() {
        OnboardingPage onboarding = new OnboardingPage(driver);
        String actual = onboarding.getScreen1DescriptionText().replaceAll("\\s+", " ").trim();
        String expected = ExcelUtils.getExpectedText("OnboardingScreen1Desc").trim();

        System.out.println("🔍 Actual Description: " + actual);
        System.out.println("📖 Expected Description: " + expected);
        Assert.assertEquals(actual, expected, "❌ Description mismatch on Onboarding Screen 1!");
    }

    @Test(dependsOnMethods = "verifyOnboardingScreen1Description")
    public void verifyScreen2NavigationAndTitle() {
        OnboardingPage onboarding = new OnboardingPage(driver);
        onboarding.clickScreen1Arrow();
        Assert.assertTrue(onboarding.isScreen2TitleDisplayed(), "❌ Navigation to Screen 2 failed!");

        String actual = onboarding.getScreen2TitleText().replaceAll("\\s+", " ").trim();
        String expected = ExcelUtils.getExpectedText("OnboardingScreen2Title").trim();
        System.out.println("🔍 Actual Screen 2 Title: " + actual);
        System.out.println("📖 Expected Screen 2 Title: " + expected);
        Assert.assertEquals(actual, expected, "❌ Title mismatch on Onboarding Screen 2!");
    }

    @Test(dependsOnMethods = "verifyScreen2NavigationAndTitle")
    public void verifyScreen2Description() {
        OnboardingPage onboarding = new OnboardingPage(driver);
        String actual = onboarding.getScreen2DescriptionText().replaceAll("\\s+", " ").trim();
        String expected = ExcelUtils.getExpectedText("OnboardingScreen2Desc").trim();
        System.out.println("🔍 Actual Screen 2 Description: " + actual);
        System.out.println("📖 Expected Screen 2 Description: " + expected);
        Assert.assertEquals(actual, expected, "❌ Description mismatch on Onboarding Screen 2!");
    }

    @Test(dependsOnMethods = "verifyScreen2Description")
    public void verifyScreen3NavigationAndTitle() {
        OnboardingPage onboarding = new OnboardingPage(driver);
        onboarding.clickScreen2Arrow();
        Assert.assertTrue(onboarding.isScreen3TitleDisplayed(), "❌ Navigation to Screen 3 failed!");

        String actual = onboarding.getScreen3TitleText().replaceAll("\\s+", " ").trim();
        String expected = ExcelUtils.getExpectedText("OnboardingScreen3Title").trim();
        System.out.println("🔍 Actual Screen 3 Title: " + actual);
        System.out.println("📖 Expected Screen 3 Title: " + expected);
        Assert.assertEquals(actual, expected, "❌ Title mismatch on Onboarding Screen 3!");
    }

    @Test(dependsOnMethods = "verifyScreen3NavigationAndTitle")
    public void verifyScreen3Description() {
        OnboardingPage onboarding = new OnboardingPage(driver);
        String actual = onboarding.getScreen3DescriptionText().replaceAll("\\s+", " ").trim();
        String expected = ExcelUtils.getExpectedText("OnboardingScreen3Desc").trim();
        System.out.println("🔍 Actual Screen 3 Description: " + actual);
        System.out.println("📖 Expected Screen 3 Description: " + expected);
        Assert.assertEquals(actual, expected, "❌ Description mismatch on Onboarding Screen 3!");
    }

    @Test(dependsOnMethods = "verifyScreen3Description")
    public void verifyScreen4NavigationAndTitle() {
        OnboardingPage onboarding = new OnboardingPage(driver);
        onboarding.clickScreen1Arrow();
        Assert.assertTrue(onboarding.isScreen4TitleDisplayed(), "❌ Navigation to Screen 4 failed!");

        String actual = onboarding.getScreen4TitleText().replaceAll("\\s+", " ").trim();
        String expected = ExcelUtils.getExpectedText("OnboardingScreen4Title").trim();

        System.out.println("🔍 Actual Screen 4 Title: " + actual);
        System.out.println("📖 Expected Screen 4 Title: " + expected);
        Assert.assertEquals(actual, expected, "❌ Title mismatch on Onboarding Screen 4!");
    }

    @Test(dependsOnMethods = "verifyScreen4NavigationAndTitle")
    public void verifyScreen4Description1() {
        OnboardingPage onboarding = new OnboardingPage(driver);

        String actual = onboarding.getScreen4Description1Text().replaceAll("\\s+", " ").trim();
        String expected = ExcelUtils.getExpectedText("OnboardingScreen4Desc1").trim();

        System.out.println("🔍 Actual Screen 4 Desc1: " + actual);
        System.out.println("📖 Expected Screen 4 Desc1: " + expected);
        Assert.assertEquals(actual, expected, "❌ Description 1 mismatch on Onboarding Screen 4!");
    }

    @Test(dependsOnMethods = "verifyScreen4Description1")
    public void verifyScreen4Description2() {
        OnboardingPage onboarding = new OnboardingPage(driver);

        String actual = onboarding.getScreen4Description2Text().replaceAll("\\s+", " ").trim();
        String expected = ExcelUtils.getExpectedText("OnboardingScreen4Desc2").trim();

        System.out.println("🔍 Actual Screen 4 Desc2: " + actual);
        System.out.println("📖 Expected Screen 4 Desc2: " + expected);
        Assert.assertEquals(actual, expected, "❌ Description 2 mismatch on Onboarding Screen 4!");
    }

//    @Test(dependsOnMethods = "verifyScreen4Description2")
//    public void verifyScrollBackToScreen3() {
//        OnboardingPage onboarding = new OnboardingPage(driver);
//
//        onboarding.swipeRight();  // Swipe right = backward
//
//        String currentPackage = ((AndroidDriver) driver).getCurrentPackage();
//        Assert.assertEquals(currentPackage, "com.dinetap.app.qa", "❌ App closed or navigated away!");
//
//        Assert.assertTrue(onboarding.isScreen3TitleDisplayed(), "❌ Failed to scroll back to Screen 3!");
//        System.out.println("✅ Successfully navigated back to Screen 3.");
//    }
//
//    @Test(dependsOnMethods = "verifyScrollBackToScreen3")
//    public void verifyScrollForwardToScreen4() {
//        OnboardingPage onboarding = new OnboardingPage(driver);
//
//        onboarding.swipeLeft();  // Swipe left = forward
//
//        Assert.assertTrue(onboarding.isScreen4TitleDisplayed(), "❌ Failed to scroll forward to Screen 4!");
//        System.out.println("✅ Successfully navigated forward to Screen 4.");
//    }

    @Test(dependsOnMethods = "verifyScreen4Description2")
    public void verifyGetStartedButtonText() {
        OnboardingPage onboarding = new OnboardingPage(driver);
        String expectedText = ExcelUtils.getExpectedText("GetStarted");
        String actualText = onboarding.getGetStartedText();

        Assert.assertEquals(actualText, expectedText, "❌ 'Get Started' button text mismatch!");
        System.out.println("✅ 'Get Started' button text verified: " + actualText);
    }

    @Test(dependsOnMethods = "verifyGetStartedButtonText")
    public void verifyNavigationToLoginScreen() {
        OnboardingPage onboarding = new OnboardingPage(driver);

        onboarding.clickGetStartedButton();

        String actualLoginHeader = onboarding.getLoginHeaderText().replaceAll("\\s+", " ").trim();
        String expectedLoginHeader = ExcelUtils.getExpectedText("LoginHeader").replaceAll("\\s+", " ").trim();

        System.out.println("🔍 Actual Login Header: " + actualLoginHeader);
        System.out.println("📖 Expected Login Header: " + expectedLoginHeader);

        Assert.assertEquals(actualLoginHeader, expectedLoginHeader, "❌ Login screen header text mismatch!");
        System.out.println("✅ Successfully navigated to login screen.");
    }



}
