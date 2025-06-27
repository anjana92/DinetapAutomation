package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    private WebDriverWait wait;
    private AppiumDriver driver;

    // Locators
    private By shortLocation = By.xpath("//android.widget.TextView[contains(@text, 'Empress')]");
    private By fullLocation = By.xpath("//android.widget.TextView[contains(@text, '5 Empress Pl') and contains(@text, 'Singapore')]");
    private By yourWallets = By.xpath("//android.widget.TextView[@text='Your Wallets']");
    private By howAppWorksBanner = By.xpath("//*[contains(@text,'Click! Learn how the app works')]");
    private By letsGoBanner = By.xpath("//*[contains(@text, \"Let's Go\")]");
    private By shortLocation2 = By.xpath("//android.widget.TextView[contains(@text, 'Nike Unite Store')]");
    private final By profileIcon = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.View[5]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView");


    public HomePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public String getShortLocationText() {
        dumpPageSource();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(shortLocation));
        return element.getText();
    }

    public String getFullLocationText() {
        dumpPageSource();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(fullLocation));
        return element.getText();
    }

    public String getYourWalletsText() {
        dumpPageSource();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(yourWallets));
        return element.getText();
    }

    public void waitForHomePageToLoad() {
        dumpPageSource();
        wait.until(ExpectedConditions.visibilityOfElementLocated(shortLocation));
        System.out.println("✅ Home page is loaded. Short location is visible.");
    }


    /*public String getHowAppWorksBannerText() {
        dumpPageSource();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(howAppWorksBanner));
        return element.getText();


    }*/

    public String getHowAppWorksBannerText() {
        dumpPageSource();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(howAppWorksBanner));
        String text = element.getText();
        System.out.println("📌 How App Works Banner Text: " + text);
        return text;
    }

    public String getLetsGoBannerText() {
        dumpPageSource();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(letsGoBanner));
        String text = element.getText();
        System.out.println("📌 Let's Go Banner Text: " + text);
        return text;
    }



    public void clickHowAppWorksBanner() {
        driver.findElement(letsGoBanner).click();
        System.out.println("✅ Clicked on 'Click! Learn how the app works' banner.");
    }




    public boolean isLetsGoBannerVisible() {
        try {
            return driver.findElement(letsGoBanner).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



    public void clickShortLocation() {
        driver.findElement(shortLocation).click();
    }

    public void clickShortLocation2() {
        driver.findElement(shortLocation2).click();
    }


    private void dumpPageSource() {
        try {
            String source = driver.getPageSource();
            // Optionally log or save page source if needed for debugging
        } catch (Exception e) {
            // Handle safely
        }
    }

    public String getTopBarAddressByExactText(String addressText) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[@text='" + addressText + "']")));
        return element.getText();
    }



    public void clickProfileIcon() {
        driver.findElement(profileIcon).click();
        try {
            Thread.sleep(2000); // TEMPORARY for visual transition; better to use explicit wait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
