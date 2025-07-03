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
    public void verifyLoginBottomText1() {
        LoginPage login = new LoginPage(driver);
        String actualText = login.getBottomText1().replaceAll("\\s+", " ").trim();
        String expectedText = ExcelUtils.getExpectedText("LoginBottomText1");
        Assert.assertEquals(actualText, expectedText, "❌ Bottom text 1 mismatch!");
        System.out.println("✅ Bottom text 1 verified");
    }

    @Test(dependsOnMethods = "verifySkipButtonText")
    public void verifyLoginBottomText2() {
        LoginPage login = new LoginPage(driver);
        String actualText = login.getBottomText2().trim();
        String expectedText = ExcelUtils.getExpectedText("LoginBottomText2");
        Assert.assertEquals(actualText, expectedText, "❌ Bottom text 2 mismatch!");
        System.out.println("✅ Bottom text 2 verified");
    }

    @Test(dependsOnMethods = "verifySkipButtonText")
    public void verifyLoginBottomText3() {
        LoginPage login = new LoginPage(driver);
        String actualText = login.getBottomText3().trim();
        String expectedText = ExcelUtils.getExpectedText("LoginBottomText3");
        Assert.assertEquals(actualText, expectedText, "❌ Bottom text 3 mismatch!");
        System.out.println("✅ Bottom text 3 verified");
    }

    @Test(dependsOnMethods = "verifySkipButtonText")
    public void verifyLoginBottomText4() {
        LoginPage login = new LoginPage(driver);
        String actualText = login.getBottomText4().trim();
        String expectedText = ExcelUtils.getExpectedText("LoginBottomText4");
        Assert.assertEquals(actualText, expectedText, "❌ Bottom text 4 mismatch!");
        System.out.println("✅ Bottom text 4 verified");
    }




//    @Test(dependsOnMethods = "verifyLoginBottomText4")
//    public void verifyNavigationToHomeAfterSkip() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.clickSkipButton();
//
//        HomePage homePage = new HomePage(driver);
//        String actualText = homePage.getYourWalletsText().replaceAll("\\s+", " ").trim();
//        String expectedText = ExcelUtils.getExpectedText("YourWallets");
//
//        System.out.println("🔍 Actual Home Text: " + actualText);
//        System.out.println("📖 Expected Home Text: " + expectedText);
//
//        Assert.assertEquals(actualText, expectedText, "❌ User did not land on Home page!");
//        System.out.println("✅ User successfully landed on Home page after clicking Skip.");
//    }

    @Test(dependsOnMethods = "verifyLoginBottomText4")
    public void verifyNavigationToHomeAfterSkip() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSkipButton();

        //String actualText = loginPage.getLocationPermissionPopupText().replaceAll("\\s+", " ").trim();
       // String expectedText = ExcelUtils.getExpectedText("LocationPermission");

        String actualText = loginPage.getLocationPermissionPopupText()
                .replaceAll("’", "'")
                .replaceAll("\\s+", " ")
                .trim();

        String expectedText = ExcelUtils.getExpectedText("LocationPermission")
                .replaceAll("’", "'")
                .replaceAll("\\s+", " ")
                .trim();

        System.out.println("🔍 Actual Location Permission Popup Text: " + actualText);
        System.out.println("📖 Expected Location Permission Popup Text: " + expectedText);

        Assert.assertEquals(actualText, expectedText, "❌ Location Permission popup text mismatch or not displayed!");
        System.out.println("✅ Successfully navigated and permission popup appeared after clicking Skip.");
    }

}
