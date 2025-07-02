package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelUtils;

public class LoginPageTest extends BaseTest {

    @Test
    public void verifySkipButtonText() {
        LoginPage loginPage = new LoginPage(driver);

        String actualText = loginPage.getSkipButtonText().replaceAll("\\s+", " ").trim();
        String expectedText = ExcelUtils.getExpectedText("LoginSkipText");

        System.out.println("🔍 Actual Skip Text: " + actualText);
        System.out.println("📖 Expected Skip Text: " + expectedText);

        Assert.assertEquals(actualText, expectedText, "❌ Skip button text mismatch!");
        System.out.println("✅ Skip button text verified.");
    }

    @Test(dependsOnMethods = "verifySkipButtonText")
    public void verifyNavigationToHomeAfterSkip() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSkipButton();

        HomePage homePage = new HomePage(driver);
        String actualText = homePage.getYourWalletsText().replaceAll("\\s+", " ").trim();
        String expectedText = ExcelUtils.getExpectedText("YourWallets");

        System.out.println("🔍 Actual Home Text: " + actualText);
        System.out.println("📖 Expected Home Text: " + expectedText);

        Assert.assertEquals(actualText, expectedText, "❌ User did not land on Home page!");
        System.out.println("✅ User successfully landed on Home page after clicking Skip.");
    }
}
