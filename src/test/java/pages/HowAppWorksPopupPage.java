package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HowAppWorksPopupPage {

    private AppiumDriver driver;

    public HowAppWorksPopupPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public boolean isStep1PopupVisible() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='Step 1']")).isDisplayed();
    }

    public String getStep1TitleText() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='Step 1']")).getText();
    }

    public String getStep1DescriptionTitleText() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='Find an offer']")).getText();
    }

    public String getStep1DescriptionDetailText() {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='Upto 40% credits up for grabs! Keep a lookout!']")).getText();
    }

    /*public boolean isStep1DotVisible() {
        return driver.findElement("00000000-0000-05cc-ffff-ffff00000216").isDisplayed();
    }*/
}
