package pages;

import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ExcelUtils;

import java.time.Duration;
import java.time.Instant;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class YourProfilePage {
    private final AppiumDriver driver;

    //private final WebDriverWait wait;

    private final By yourProfileText = By.xpath("//android.widget.TextView[@text='Your Profile']");
    private final By appearanceOption = By.xpath("//android.view.ViewGroup[@content-desc='Appearance']");
    private final By appearanceSettingPopupText = By.xpath("(//android.widget.TextView[@text='Appearance'])[1]");
    private final By languageOptionText = By.xpath("//android.widget.TextView[@text='Language']");
    private final By helpSupportLabel = By.xpath("//android.widget.TextView[@text='Help & Support']");
    private final By termsPrivacyLabel = By.xpath("//android.widget.TextView[@text='Terms & Privacy']");
    private final By sendFeedbackLabel = By.xpath("//android.widget.TextView[@text='Send Feedback']");

    //Send Feedback Pop up
    private final By feedbackPopupTitle = By.xpath("//android.widget.TextView[@text='Tell us about it!']");


    // Options inside the Appearance popup
    private final By systemOption = By.xpath("//android.widget.TextView[@text='System']");
    private final By lightOption = By.xpath("//android.widget.TextView[@text='Light']");
    private final By darkOption = By.xpath("//android.widget.TextView[@text='Dark']");

    // Close icon for the Appearance popup
    //private final By appearancePopupCloseIcon = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[3]/com.horcrux.svg.SvgView");
    private final By appearancePopupCloseIcon = By.xpath(
            "//android.widget.FrameLayout[@resource-id='android:id/content']" +
                    "/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup" +
                    "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup" +
                    "/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[3]" +
                    "/com.horcrux.svg.SvgView"
    );


    private final By languageOption = By.xpath("//android.view.ViewGroup[@content-desc='Language']");
    private final By changeLanguagePopupTitle = By.xpath("//android.widget.TextView[@text='Change Language']");

    // Popup language options
    private final By englishUSOption = By.xpath("//android.widget.TextView[@text='English (US)']");
    private final By englishUKOption = By.xpath("//android.widget.TextView[@text='English (UK)']");
    private final By englishAUOption = By.xpath("//android.widget.TextView[@text='English (AU)']");
    private final By frenchOption = By.xpath("//android.widget.TextView[@text='Le français']");

    //private final By languagePopupCloseIcon = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView");
    private final By languagePopupCloseIcon = By.xpath(
            "//android.widget.FrameLayout[@resource-id='android:id/content']" +
                    "/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup" +
                    "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup" +
                    "/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]" +
                    "/com.horcrux.svg.SvgView"
    );

    //private final By feedbackDescription = By.xpath("//android.widget.TextView[@text=\"We are super serious about your feedback! Tell us everything.\"]");


    private final By feedbackDescription = By.xpath("//android.widget.TextView[@text=\"We are super serious about your feedback! Tell us everything.\"]");

    private final By feedbackPopupCloseIcon = By.xpath(
            "//android.widget.FrameLayout[@resource-id='android:id/content']" +
                    "/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup" +
                    "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup" +
                    "/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[2]"
    );


    public YourProfilePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public boolean isProfilePageDisplayed() {
        return driver.findElement(yourProfileText).isDisplayed();
    }

    public String getProfileTitleText() {
        return driver.findElement(yourProfileText).getText();
    }

    public boolean isAppearanceOptionVisible() {
        return driver.findElement(appearanceOption).isDisplayed();
    }

    public String getAppearanceLabel() {
        return driver.findElement(appearanceOption).getAttribute("content-desc");
    }

    public String getAppearancePopupText() {
        return driver.findElement(appearanceSettingPopupText).getText();
    }

    public void tapAppearanceOption() {
        driver.findElement(appearanceOption).click(); // reuse the existing locator for Appearance button
    }


    public String getSystemTextInPopup() {
        return driver.findElement(systemOption).getText();
    }

    public String getLightTextInPopup() {
        return driver.findElement(lightOption).getText();
    }

    public String getDarkTextInPopup() {
        return driver.findElement(darkOption).getText();
    }


    public void closeAppearancePopup() {
        driver.findElement(appearancePopupCloseIcon).click();
    }

    public boolean isAppearancePopupClosed() {
        // Assuming popup disappears and title is gone
        return driver.findElements(By.xpath("(//android.widget.TextView[@text='Appearance'])[2]")).isEmpty();
    }

    public boolean verifyLanguageTextFromExcel() {
        String expectedText = ExcelUtils.getExpectedText("ProfileLanguageLabel");
        String actualText = driver.findElement(languageOptionText).getText();
        return expectedText.equals(actualText);

    }

    public void tapLanguageOption() {
        driver.findElement(languageOption).click();
    }


    public boolean isChangeLanguagePopupOpenedCorrectly() {
        String expected = ExcelUtils.getExpectedText("ChangeLanguagePopupTitle");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popupTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(changeLanguagePopupTitle));
        return expected.equals(popupTitle.getText());
    }

    public boolean verifyLanguageOptionVisible(By locator, String expectedText) {
        String actual = driver.findElement(locator).getText();
        return expectedText.equals(actual);

    }


    public String getEnglishUSText() {
        return driver.findElement(englishUSOption).getText();
    }

    public String getEnglishUKText() {
        return driver.findElement(englishUKOption).getText();
    }

    public String getEnglishAUText() {
        return driver.findElement(englishAUOption).getText();
    }

    public String getFrenchText() {
        return driver.findElement(frenchOption).getText();
    }

    public void closeLanguagePopup() {
        driver.findElement(languagePopupCloseIcon).click();
    }

    public boolean isLanguagePopupClosed() {
        return driver.findElements(changeLanguagePopupTitle).isEmpty();
    }


    public void tapOutsidePopupUsingProfileTitle() {
        driver.findElement(yourProfileText).click();
    }

    public String getHelpSupportText() {
        return driver.findElement(helpSupportLabel).getText();
    }

    public String getTermsPrivacyText() {
        return driver.findElement(termsPrivacyLabel).getText();
    }

    public String getSendFeedbackText() {
        return driver.findElement(sendFeedbackLabel).getText();
    }


    public void tapSendFeedback() {
        driver.findElement(sendFeedbackLabel).click();
    }


    public String getFeedbackPopupTitleText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackPopupTitle)).getText();
    }


    public void clickFeedbackPopupCloseIcon() {
        try {
            driver.findElement(feedbackPopupCloseIcon).click();
            System.out.println("✅ Clicked on Feedback Close Icon");
        } catch (Exception e) {
            System.out.println("⚠️ Could not click Feedback Close Icon: " + e.getMessage());
        }
    }

    public boolean isPopupClosed() {
        return driver.findElements(feedbackDescription).isEmpty();
    }


}







