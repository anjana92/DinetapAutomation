package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HowAppWorksPopupPage;
import utils.ExcelUtils;

public class HowAppWorksPopupTest extends BaseTest {

    HomePage homePage;
    HowAppWorksPopupPage popupPage;

    @Test
    public void openPopupByClickingBanner() {
        homePage = new HomePage(driver);
        popupPage = new HowAppWorksPopupPage(driver);

        homePage.clickHowAppWorksBanner();

        Assert.assertTrue(popupPage.isStep1PopupVisible(), "❌ Step 1 popup did not open after clicking Let’s Go.");
        System.out.println("✅ Step 1 popup is visible.");
    }

    @Test(dependsOnMethods = "openPopupByClickingBanner")
    public void verifyStep1Title() {
        String expected = ExcelUtils.getExpectedText("Step1Title");
        String actual = popupPage.getStep1TitleText();

        Assert.assertEquals(actual, expected, "❌ Step 1 title mismatch!");
        System.out.println("✅ Step 1 title matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyStep1Title")
    public void verifyStep1DescriptionTitle() {
        String expected = ExcelUtils.getExpectedText("Step1DescTitle");
        String actual = popupPage.getStep1DescriptionTitleText();

        Assert.assertEquals(actual, expected, "❌ Step 1 description title mismatch!");
        System.out.println("✅ Step 1 description title matched: " + actual);
    }
//
//    @Test(dependsOnMethods = "verifyStep1Title")
//    public void verifyStep1DescriptionDetail() {
//        String expected = ExcelUtils.getExpectedText("Step1DescDetail");
//        String actual = popupPage.getStep1DescriptionDetailText();
//
//        Assert.assertEquals(actual, expected, "❌ Step 1 description detail mismatch!");
//        System.out.println("✅ Step 1 description detail matched: " + actual);
//    }


    @Test(dependsOnMethods = "verifyStep1Title")
    public void verifyStep1DescriptionDetail() {
        String expected = ExcelUtils.getExpectedText("Step1DescDetail").trim();
        String actual = popupPage.getStep1DescriptionDetailText().trim();

        System.out.println("🔍 Actual Text: " + actual);
        System.out.println("📖 Expected Text: " + expected);

        Assert.assertEquals(actual, expected, "❌ Step 1 description detail mismatch!");
        System.out.println("✅ Step 1 description detail matched.");
    }

    @Test(dependsOnMethods = "verifyStep1Title")
    public void verifyStep1DotIsVisible() {
        Assert.assertTrue(popupPage.isStep1DotVisible(), "❌ Step 1 dot is not visible.");
        System.out.println("✅ Step 1 dot is visible.");
    }

    @Test(dependsOnMethods = {
            "verifyStep1Title",
            "verifyStep1DescriptionTitle",
            "verifyStep1DescriptionDetail",
            "verifyStep1DotIsVisible"
    })
    public void verifyScrollToStep2AndTitle() {
        popupPage.scrollOnStepByStep();

        Assert.assertTrue(popupPage.isStep2Visible(), "❌ Step 2 is not visible after scroll.");
        System.out.println("✅ Step 2 is visible: " + popupPage.getStep2TitleText());
    }

    @Test(dependsOnMethods = "verifyScrollToStep2AndTitle")
    public void verifyStep2Title() {
        Assert.assertTrue(popupPage.isStep2Visible(), "❌ Step 2 is not visible. Cannot verify title.");

        String expected = ExcelUtils.getExpectedText("Step2Title");
        String actual = popupPage.getStep2TitleText();

        Assert.assertEquals(actual, expected, "❌ Step 2 title mismatch!");
        System.out.println("✅ Step 2 title matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyScrollToStep2AndTitle")
    public void verifyStep2DescriptionTitle() {
        Assert.assertTrue(popupPage.isStep2Visible(), "❌ Step 2 is not visible. Cannot verify description title.");

        String expected = ExcelUtils.getExpectedText("Step2DescTitle");
        String actual = popupPage.getStep2DescriptionTitleText();

        Assert.assertEquals(actual, expected, "❌ Step 2 description title mismatch!");
        System.out.println("✅ Step 2 description title matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyScrollToStep2AndTitle")
    public void verifyStep2DescriptionDetail() {
        Assert.assertTrue(popupPage.isStep2Visible(), "❌ Step 2 is not visible. Cannot verify description detail.");

        String expected = ExcelUtils.getExpectedText("Step2DescDetail");
        String actual = popupPage.getStep2DescriptionDetailText();

        Assert.assertEquals(actual, expected, "❌ Step 2 description detail mismatch!");
        System.out.println("✅ Step 2 description detail matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyScrollToStep2AndTitle")
    public void verifyStep2DotIsVisible() {
        Assert.assertTrue(popupPage.isStep2DotVisible(), "❌ Step 2 dot is not visible.");
        System.out.println("✅ Step 2 dot is visible.");
    }




    @Test(dependsOnMethods = {
            "verifyStep2Title",
            "verifyStep2DescriptionTitle",
            "verifyStep2DescriptionDetail",
            "verifyStep2DotIsVisible"
    })
    public void verifyScrollToStep3AndTitle() {
        popupPage.scrollOnStepByStep();

        Assert.assertTrue(popupPage.isStep3Visible(), "❌ Step 3 is not visible after scroll.");
        System.out.println("✅ Step 3 is visible: " + popupPage.getStep3TitleText());
    }

    @Test(dependsOnMethods = "verifyScrollToStep3AndTitle")
    public void verifyStep3Title() {
        Assert.assertTrue(popupPage.isStep3Visible(), "❌ Step 3 is not visible. Cannot verify title.");

        String expected = ExcelUtils.getExpectedText("Step3Title");
        String actual = popupPage.getStep3TitleText();

        Assert.assertEquals(actual, expected, "❌ Step 3 title mismatch!");
        System.out.println("✅ Step 3 title matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyScrollToStep3AndTitle")
    public void verifyStep3DescriptionTitle() {
        Assert.assertTrue(popupPage.isStep3Visible(), "❌ Step 3 is not visible. Cannot verify description title.");

        String expected = ExcelUtils.getExpectedText("Step3DescTitle");
        String actual = popupPage.getStep3DescriptionTitleText();

        Assert.assertEquals(actual, expected, "❌ Step 3 description title mismatch!");
        System.out.println("✅ Step 3 description title matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyScrollToStep3AndTitle")
    public void verifyStep3DescriptionDetail() {
        Assert.assertTrue(popupPage.isStep3Visible(), "❌ Step 3 is not visible. Cannot verify description detail.");

        String expected = ExcelUtils.getExpectedText("Step3DescDetail");
        String actual = popupPage.getStep3DescriptionDetailText();

        Assert.assertEquals(actual, expected, "❌ Step 3 description detail mismatch!");
        System.out.println("✅ Step 3 description detail matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyScrollToStep3AndTitle")
    public void verifyStep3DotIsVisible() {
        Assert.assertTrue(popupPage.isStep3DotVisible(), "❌ Step 3 dot is not visible.");
        System.out.println("✅ Step 3 dot is visible.");
    }



    // ===== STEP 4 =====

    @Test(dependsOnMethods = {
            "verifyStep3Title",
            "verifyStep3DescriptionTitle",
            "verifyStep3DescriptionDetail",
            "verifyStep3DotIsVisible"
    })
    public void verifyScrollToStep4AndTitle() {
        popupPage.scrollOnStepByStep();

        Assert.assertTrue(popupPage.isStep4Visible(), "❌ Step 4 is not visible after scroll.");
        System.out.println("✅ Step 4 is visible: " + popupPage.getStep4TitleText());
    }

    @Test(dependsOnMethods = "verifyScrollToStep4AndTitle")
    public void verifyStep4Title() {
        Assert.assertTrue(popupPage.isStep4Visible(), "❌ Step 4 is not visible. Cannot verify title.");

        String expected = ExcelUtils.getExpectedText("Step4Title");
        String actual = popupPage.getStep4TitleText();

        Assert.assertEquals(actual, expected, "❌ Step 4 title mismatch!");
        System.out.println("✅ Step 4 title matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyScrollToStep4AndTitle")
    public void verifyStep4DescriptionTitle() {
        Assert.assertTrue(popupPage.isStep4Visible(), "❌ Step 4 is not visible. Cannot verify description title.");

        String expected = ExcelUtils.getExpectedText("Step4DescTitle");
        String actual = popupPage.getStep4DescriptionTitleText();

        Assert.assertEquals(actual, expected, "❌ Step 4 description title mismatch!");
        System.out.println("✅ Step 4 description title matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyScrollToStep4AndTitle")
    public void verifyStep4DescriptionDetail() {
        Assert.assertTrue(popupPage.isStep4Visible(), "❌ Step 4 is not visible. Cannot verify description detail.");

        String expected = ExcelUtils.getExpectedText("Step4DescDetail");
        String actual = popupPage.getStep4DescriptionDetailText();

        Assert.assertEquals(actual, expected, "❌ Step 4 description detail mismatch!");
        System.out.println("✅ Step 4 description detail matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyScrollToStep4AndTitle")
    public void verifyStep4DotIsVisible() {
        Assert.assertTrue(popupPage.isStep4DotVisible(), "❌ Step 4 dot is not visible.");
        System.out.println("✅ Step 4 dot is visible.");
    }

// ===== STEP 5 =====

    @Test(dependsOnMethods = {
            "verifyStep4Title",
            "verifyStep4DescriptionTitle",
            "verifyStep4DescriptionDetail",
            "verifyStep4DotIsVisible"
    })
    public void verifyScrollToStep5AndTitle() {
        popupPage.scrollOnStepByStep();

        Assert.assertTrue(popupPage.isStep5Visible(), "❌ Step 5 is not visible after scroll.");
        System.out.println("✅ Step 5 is visible: " + popupPage.getStep5TitleText());
    }

    @Test(dependsOnMethods = "verifyScrollToStep5AndTitle")
    public void verifyStep5Title() {
        Assert.assertTrue(popupPage.isStep5Visible(), "❌ Step 5 is not visible. Cannot verify title.");

        String expected = ExcelUtils.getExpectedText("Step5Title");
        String actual = popupPage.getStep5TitleText();

        Assert.assertEquals(actual, expected, "❌ Step 5 title mismatch!");
        System.out.println("✅ Step 5 title matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyScrollToStep5AndTitle")
    public void verifyStep5DescriptionTitle() {
        Assert.assertTrue(popupPage.isStep5Visible(), "❌ Step 5 is not visible. Cannot verify description title.");

        String expected = ExcelUtils.getExpectedText("Step5DescTitle");
        String actual = popupPage.getStep5DescriptionTitleText();

        Assert.assertEquals(actual, expected, "❌ Step 5 description title mismatch!");
        System.out.println("✅ Step 5 description title matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyScrollToStep5AndTitle")
    public void verifyStep5DescriptionDetail() {
        Assert.assertTrue(popupPage.isStep5Visible(), "❌ Step 5 is not visible. Cannot verify description detail.");

        String expected = ExcelUtils.getExpectedText("Step5DescDetail");
        String actual = popupPage.getStep5DescriptionDetailText();

        Assert.assertEquals(actual, expected, "❌ Step 5 description detail mismatch!");
        System.out.println("✅ Step 5 description detail matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyScrollToStep5AndTitle")
    public void verifyStep5DotIsVisible() {
        Assert.assertTrue(popupPage.isStep5DotVisible(), "❌ Step 5 dot is not visible.");
        System.out.println("✅ Step 5 dot is visible.");
    }

// ===== STEP 6 =====

    @Test(dependsOnMethods = {
            "verifyStep5Title",
            "verifyStep5DescriptionTitle",
            "verifyStep5DescriptionDetail",
            "verifyStep5DotIsVisible"
    })
    public void verifyScrollToStep6AndTitle() {
        popupPage.scrollOnStepByStep();

        Assert.assertTrue(popupPage.isStep6Visible(), "❌ Step 6 is not visible after scroll.");
        System.out.println("✅ Step 6 is visible: " + popupPage.getStep6TitleText());
    }

    @Test(dependsOnMethods = "verifyScrollToStep6AndTitle")
    public void verifyStep6Title() {
        Assert.assertTrue(popupPage.isStep6Visible(), "❌ Step 6 is not visible. Cannot verify title.");

        String expected = ExcelUtils.getExpectedText("Step6Title");
        String actual = popupPage.getStep6TitleText();

        Assert.assertEquals(actual, expected, "❌ Step 6 title mismatch!");
        System.out.println("✅ Step 6 title matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyScrollToStep6AndTitle")
    public void verifyStep6DescriptionTitle() {
        Assert.assertTrue(popupPage.isStep6Visible(), "❌ Step 6 is not visible. Cannot verify description title.");

        String expected = ExcelUtils.getExpectedText("Step6DescTitle");
        String actual = popupPage.getStep6DescriptionTitleText();

        Assert.assertEquals(actual, expected, "❌ Step 6 description title mismatch!");
        System.out.println("✅ Step 6 description title matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyScrollToStep6AndTitle")
    public void verifyStep6DescriptionDetail() {
        Assert.assertTrue(popupPage.isStep6Visible(), "❌ Step 6 is not visible. Cannot verify description detail.");

        String expected = ExcelUtils.getExpectedText("Step6DescDetail");
        String actual = popupPage.getStep6DescriptionDetailText();

        Assert.assertEquals(actual, expected, "❌ Step 6 description detail mismatch!");
        System.out.println("✅ Step 6 description detail matched: " + actual);
    }

    @Test(dependsOnMethods = "verifyScrollToStep6AndTitle")
    public void verifyStep6DotIsVisible() {
        Assert.assertTrue(popupPage.isStep6DotVisible(), "❌ Step 6 dot is not visible.");
        System.out.println("✅ Step 6 dot is visible.");
    }


    @Test(dependsOnMethods = {
            "verifyStep6DotIsVisible" // or wherever you want to close from
    })
    public void verifyPopupCloseFunctionality() throws InterruptedException {
        popupPage.clickCloseIcon();

        // Optionally wait a moment for popup to dismiss
        try {
            Thread.sleep(1000);  // or better: use WebDriverWait if you want
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertTrue(homePage.isLetsGoBannerVisible(), "❌ Popup did not close successfully — Let's Go! banner not visible.");
        System.out.println("✅ Popup closed successfully and Let's Go! banner is visible.");
    }





    //Verify click outside on the Pop up functionality
    @Test(dependsOnMethods = {
            "verifyPopupCloseFunctionality" // or wherever you want to place this in the sequence
    })
    public void verifyPopupCloseByClickingOutside() throws InterruptedException {
        // Open popup again
        homePage.clickHowAppWorksBanner();

        Assert.assertTrue(popupPage.isStep1PopupVisible(), "❌ Popup did not open when expected.");
        System.out.println("✅ Popup opened successfully for outside click close test.");

        // Click outside the popup
        popupPage.clickOutsidePopupWithCoordinates();

        // Optionally wait for UI update
        try {
            Thread.sleep(1000);  // Replace with proper wait ideally
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Verify popup is closed (Let's Go! banner visible again)
        Assert.assertTrue(homePage.isLetsGoBannerVisible(), "❌ Popup did not close after clicking outside.");
        System.out.println("✅ Popup closed successfully by clicking outside, Let's Go! banner is visible.");
    }










}
