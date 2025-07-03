package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashScreenPage;
import utils.ExcelUtils;

public class SplashScreenTest extends BaseTest {

    @Test
    public void verifySplashScreen() {
        SplashScreenPage splash = new SplashScreenPage(driver);
        String actualText = splash.getSplashText();
        String expectedText = ExcelUtils.getExpectedText("splashText");

        System.out.println("🔍 Actual UI text: " + actualText);
        System.out.println("📖 Expected from Excel: " + expectedText);

        Assert.assertEquals(actualText.trim(), expectedText.trim(), "Splash text does not match!");
        System.out.println("✅ Splash screen text verified successfully...");
    }

    @Test
    public void verifySplashText() {
        SplashScreenPage splash = new SplashScreenPage(driver);
        String actualText = splash.getSplashText();
        String expectedText = ExcelUtils.getExpectedText("splashText"+"123");

        System.out.println("🔍 Actual UI text: " + actualText);
        System.out.println("📖 Expected from Excel: " + expectedText);

        Assert.assertEquals(actualText.trim(), expectedText.trim(), "Splash text does not match!");
        System.out.println("✅ Splash screen text verified successfully... (duplicate run)");
    }


//    @Test
//    public void measureSplashToHomeLoadTime() {
//        SplashScreenPage splash = new SplashScreenPage(driver);
//
//        long startTime = ExcelUtils.PerformanceUtils.getStartTime();
//
//        splash.waitForHomePageAfterSplash(); // Waits until "Your Wallets" is visible
//
//        long duration = ExcelUtils.PerformanceUtils.getEndTime(startTime);
//        ExcelUtils.PerformanceUtils.logLoadTime("Splash ➜ Home", duration);
//
//        System.out.println("✅ Splash to Home transition verified...");
//    }
//



}
