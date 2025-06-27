package pages;

import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;

public class YourProfilePage {
    private final AppiumDriver driver;

    private final By yourProfileText = By.xpath("//android.widget.TextView[@text='Your Profile']");
    private final By appearanceOption = By.xpath("//android.view.ViewGroup[@content-desc='Appearance']");
    private final By appearanceSettingPopupText = By.xpath("(//android.widget.TextView[@text='Appearance'])[1]");

    // Options inside the popup
    private final By systemOption = By.xpath("//android.widget.TextView[@text='System']");
    private final By lightOption = By.xpath("//android.widget.TextView[@text='Light']");
    private final By darkOption = By.xpath("//android.widget.TextView[@text='Dark']");

    // Close icon for the Appearance popup
    private final By appearancePopupCloseIcon = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[3]/com.horcrux.svg.SvgView");


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
}
