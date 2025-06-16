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
    private Object Duration;

    public SplashScreenPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public String getSplashText() {
        WebElement element = driver.findElement(splashElement);
        return element.getText();
    }








}
