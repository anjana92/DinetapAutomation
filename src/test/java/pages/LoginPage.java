package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.time.Instant;

public class LoginPage {

    AppiumDriver driver;
    WebDriverWait wait;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private final By skipButton = By.xpath("//android.widget.TextView[@text='Skip']");
    private final By homeWalletHeader = By.xpath("//android.widget.TextView[contains(@text, 'Your Wallets')]");
    private final By bottomText1 = By.xpath("//android.widget.TextView[@text='By continuing, you agree to our']");
    private final By bottomText2 = By.xpath("//android.widget.TextView[@text='Terms of Service']");
    private final By bottomText3 = By.xpath("//android.widget.TextView[@text='Privacy Policy']");
    private final By bottomText4 = By.xpath("//android.widget.TextView[@text='Content Policy']");
    private final By locationPermissionPopupTitle = By.xpath("//android.widget.TextView[@resource-id='com.android.permissioncontroller:id/permission_message']");
    private final By locationPermissionDenyButton = By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button']");



    public String getSkipButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(skipButton));
        return element.getText();
    }

    public void clickSkipButton() {
        driver.findElement(skipButton).click();
    }

    public boolean isHomeWalletTextDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homeWalletHeader));
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    public String getBottomText1() {
       // Instant wait;
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(bottomText1));
        return element.getText();
    }

    public String getBottomText2() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(bottomText2));
        return element.getText();
    }

    public String getBottomText3() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(bottomText3));
        return element.getText();
    }

    public String getBottomText4() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(bottomText4));
        return element.getText();
    }

    public String getLocationPermissionPopupText() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locationPermissionPopupTitle));
        return element.getText();
    }

}
