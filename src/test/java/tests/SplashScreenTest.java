package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SplashScreenPage;
import utils.ExcelUtils;

public class SplashScreenTest extends BaseTest {

    @Test
    public void verifySplashText() {
        SplashScreenPage splash = new SplashScreenPage(driver);
        String actualText = splash.getSplashText();
        String expectedText = ExcelUtils.getExpectedText("splashText");

        System.out.println("🔍 Actual UI text: " + actualText);
        System.out.println("📖 Expected from Excel: " + expectedText);

        Assert.assertEquals(actualText.trim(), expectedText.trim(), "Splash text does not match!");
        System.out.println("✅ Splash screen text verified successfully...");

    }
}
