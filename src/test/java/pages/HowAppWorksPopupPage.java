package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HowAppWorksPopupPage {

    private final AppiumDriver driver;
    private final WebDriverWait wait;

    // Step 1 locators
    private final By step1Title = By.xpath("//android.widget.TextView[@text='Step 1']");
    private final By step1DescriptionTitle = By.xpath("//android.widget.TextView[@text='Find an offer']");
    private final By step1DescriptionDetail = By.xpath("//android.widget.TextView[@text='Upto 40% credits up for grabs! Keep a lookout!']");
    private final By step1Dot = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[4]");

    // Step 2 locators
    private final By step2Title = By.xpath("//android.widget.TextView[@text='Step 2']");
    private final By step2DescriptionTitle = By.xpath("//android.widget.TextView[@text='Prepay']");
    private final By step2DescriptionDetail = By.xpath("//android.widget.TextView[@text='Enter any amount and complete payments to get extra credits']");
    private final By step2Dot = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[5]");

    // Step 3 locators
    private final By step3Title = By.xpath("//android.widget.TextView[@text='Step 3']");
    private final By step3DescriptionTitle = By.xpath("//android.widget.TextView[@text='Short Wait']");
    private final By step3DescriptionDetail = By.xpath("//android.widget.TextView[@text='Each restaurant has a short waiting period before your credits become active']");
    private final By step3Dot = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[6]");


    // Step 4 locators
    private final By step4Title = By.xpath("//android.widget.TextView[@text='Step 4']");
    private final By step4DescriptionTitle = By.xpath("//android.widget.TextView[@text='Check your wallet']");
    private final By step4DescriptionDetail = By.xpath("//android.widget.TextView[@text='Open your wallet to confirm your funds are there and ready to use']");
    private final By step4Dot = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[7]");

    // Step 5 locators
    private final By step5Title = By.xpath("//android.widget.TextView[@text='Step 5']");
    private final By step5DescriptionTitle = By.xpath("//android.widget.TextView[@text='Pay your bill']");
    private final By step5DescriptionDetail = By.xpath("//android.widget.TextView[@text='Open the restaurant wallet and click on pay bill, choose amount to pay and complete']");
    private final By step5Dot = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[8]");

    // Step 6 locators
    private final By step6Title = By.xpath("//android.widget.TextView[@text='Step 6']");
    //private final By step6DescriptionTitle = By.xpath("//android.widget.TextView[@text='That's it!']");
    private final By step6DescriptionTitle = By.xpath("//android.widget.TextView[@text=\"That's it!\"]");

    private final By step6DescriptionDetail = By.xpath("//android.widget.TextView[@text='Happy saving on your meals at your favourite spot']");
    private final By step6Dot = By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[9]");

    //Close icon locator
    private final By closeIcon = By.xpath("//android.view.ViewGroup[@resource-id=\"tray.learnMoreTray.closeBtnId\"]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView");



    public HowAppWorksPopupPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Utility wait + visibility check
    private boolean isElementVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Step 1 methods
    public boolean isStep1PopupVisible() {
        return isElementVisible(step1Title);
    }

    public String getStep1TitleText() {
        return driver.findElement(step1Title).getText();
    }

    public String getStep1DescriptionTitleText() {
        return driver.findElement(step1DescriptionTitle).getText();
    }

    public String getStep1DescriptionDetailText() {
        return driver.findElement(step1DescriptionDetail).getText();
    }

    public boolean isStep1DotVisible() {
        return isElementVisible(step1Dot);
    }

    //Step 2 methods
    public boolean isStep2Visible() {
        return isElementVisible(step2Title);
    }

    public String getStep2TitleText() {
        return driver.findElement(step2Title).getText();
    }

    public String getStep2DescriptionTitleText() {
        return driver.findElement(step2DescriptionTitle).getText();
    }

    public String getStep2DescriptionDetailText() {
        return driver.findElement(step2DescriptionDetail).getText();
    }

    public boolean isStep2DotVisible() {
        return isElementVisible(step2Dot);
    }

    //Step 3 methods

    public boolean isStep3Visible() {
        return isElementVisible(step3Title);
    }

    public String getStep3TitleText() {
        return driver.findElement(step3Title).getText();
    }

    public String getStep3DescriptionTitleText() {
        return driver.findElement(step3DescriptionTitle).getText();
    }

    public String getStep3DescriptionDetailText() {
        return driver.findElement(step3DescriptionDetail).getText();
    }

    public boolean isStep3DotVisible() {
        return isElementVisible(step3Dot);
    }



    // Step 4 methods
    public boolean isStep4Visible() {
        return isElementVisible(step4Title);
    }

    public String getStep4TitleText() {
        return driver.findElement(step4Title).getText();
    }

    public String getStep4DescriptionTitleText() {
        return driver.findElement(step4DescriptionTitle).getText();
    }

    public String getStep4DescriptionDetailText() {
        return driver.findElement(step4DescriptionDetail).getText();
    }

    public boolean isStep4DotVisible() {
        return isElementVisible(step4Dot);
    }

    // Step 5 methods
    public boolean isStep5Visible() {
        return isElementVisible(step5Title);
    }

    public String getStep5TitleText() {
        return driver.findElement(step5Title).getText();
    }

    public String getStep5DescriptionTitleText() {
        return driver.findElement(step5DescriptionTitle).getText();
    }

    public String getStep5DescriptionDetailText() {
        return driver.findElement(step5DescriptionDetail).getText();
    }

    public boolean isStep5DotVisible() {
        return isElementVisible(step5Dot);
    }

    // Step 6 methods
    public boolean isStep6Visible() {
        return isElementVisible(step6Title);
    }

    public String getStep6TitleText() {
        return driver.findElement(step6Title).getText();
    }

    public String getStep6DescriptionTitleText() {
        return driver.findElement(step6DescriptionTitle).getText();
    }

    public String getStep6DescriptionDetailText() {
        return driver.findElement(step6DescriptionDetail).getText();
    }

    public boolean isStep6DotVisible() {
        return isElementVisible(step6Dot);
    }



    //Close icon click
    public void clickCloseIcon() {
        driver.findElement(closeIcon).click();
    }


    //click outside of Popup when it is opened
    public void clickOutsidePopupWithCoordinates() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        // Example: top-left corner or any area you know is outside popup
        new TouchAction((PerformsTouchActions) driver)
                .tap(PointOption.point(50, 50))  // adjust if needed!
                .perform();
    }


    // Scroll method for step by step
    public void scrollOnStepByStep() {
        int startX = 406;
        int startY = 869;
        int endX = (int) (startX * 0.4);
        int endY = startY;

        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }
}
