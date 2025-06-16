package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HowAppWorksPopupPage;
import utils.ExcelUtils;

public class HowAppWorksPopupTest extends BaseTest {

    @Test
    public void verifyStep1PopupIsOpened() {
        HomePage homePage = new HomePage(driver);
        HowAppWorksPopupPage popupPage = new HowAppWorksPopupPage(driver);

        homePage.clickHowAppWorksBanner();

        Assert.assertTrue(popupPage.isStep1PopupVisible(), "❌ Step 1 popup did not open after clicking Let’s Go.");
        System.out.println("✅ Step 1 popup is visible.");
    }

    @Test
    public void verifyStep1Title() {
        HowAppWorksPopupPage popupPage = new HowAppWorksPopupPage(driver);

        String expected = ExcelUtils.getExpectedText("Step1Title");
        String actual = popupPage.getStep1TitleText();

        Assert.assertEquals(actual, expected, "❌ Step 1 title mismatch!");
        System.out.println("✅ Step 1 title matched: " + actual);
    }

    @Test
    public void verifyStep1DescriptionTitle() {
        HowAppWorksPopupPage popupPage = new HowAppWorksPopupPage(driver);

        String expected = ExcelUtils.getExpectedText("Step1DescTitle");
        String actual = popupPage.getStep1DescriptionTitleText();

        Assert.assertEquals(actual, expected, "❌ Step 1 description title mismatch!");
        System.out.println("✅ Step 1 description title matched: " + actual);
    }

    @Test
    public void verifyStep1DescriptionDetail() {
        HowAppWorksPopupPage popupPage = new HowAppWorksPopupPage(driver);

        String expected = ExcelUtils.getExpectedText("Step1DescDetail");
        String actual = popupPage.getStep1DescriptionDetailText();

        Assert.assertEquals(actual, expected, "❌ Step 1 description detail mismatch!");
        System.out.println("✅ Step 1 description detail matched: " + actual);
    }

    /*@Test
    public void verifyStep1DotIsVisible() {
        HowAppWorksPopupPage popupPage = new HowAppWorksPopupPage(driver);

        Assert.assertTrue(popupPage.isStep1DotVisible(), "❌ Step 1 dot is not visible.");
        System.out.println("✅ Step 1 dot is visible.");
    }*/
}
