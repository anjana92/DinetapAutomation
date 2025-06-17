package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HowAppWorksPopupPage {

    private AppiumDriver driver;

    // Locators (By objects)
    private By step1Title = By.xpath("//android.widget.TextView[@text='Step 1']");
    private By step1DescriptionTitle = By.xpath("//android.widget.TextView[@text='Find an offer']");
    private By step1DescriptionDetail = By.xpath("//android.widget.TextView[@text='Upto 40% credits up for grabs! Keep a lookout!']");
    // private By step1Dot = By.id("00000000-0000-05cc-ffff-ffff00000216"); // If needed later

    public HowAppWorksPopupPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public boolean isStep1PopupVisible() {
        return driver.findElement(step1Title).isDisplayed();
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

    /*public boolean isStep1DotVisible() {
        return driver.findElement(step1Dot).isDisplayed();
    }*/
}
