package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SplashScreenPage {
    private AppiumDriver driver;

    private By splashElement = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']");
    private final By homePageIdentifier = By.xpath("//android.widget.TextView[@text='Your Wallets']");

    public SplashScreenPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public String getSplashText() {
        WebElement element = driver.findElement(splashElement);
        return element.getText();
    }




    public void waitForHomePageAfterSplash() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePageIdentifier));
    }



}
