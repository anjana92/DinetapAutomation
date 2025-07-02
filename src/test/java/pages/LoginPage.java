package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage {

    AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    private final By skipButton = By.xpath("//android.widget.TextView[@text='Skip']");
    private final By homeWalletHeader = By.xpath("//android.widget.TextView[contains(@text, 'Your Wallets')]");

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
}
