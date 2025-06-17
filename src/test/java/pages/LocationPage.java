package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LocationPage {

    private AppiumDriver driver;

    private final By searchPlaceholder = By.xpath("//android.widget.EditText[@text=\"Search for an area or street name\"]");
    private final By useDefaultLocationTitle = By.xpath("//android.widget.TextView[@text=\"Use default location\"]");
    private final By actualDefaultLocation = By.xpath("(//android.widget.TextView[@text=\"5 Empress Pl, Singapore\"])[1]");

    public LocationPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public String getSearchPlaceholderText() {
        return driver.findElement(searchPlaceholder).getText();
    }

    public boolean isUseDefaultLocationVisible() {
        return driver.findElement(useDefaultLocationTitle).isDisplayed();
    }

    public String getActualDefaultLocationText() {
        return driver.findElement(actualDefaultLocation).getText();
    }
}

