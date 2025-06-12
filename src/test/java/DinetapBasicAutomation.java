import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.ExcelUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class DinetapBasicAutomation {

    private AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", "11");
        caps.setCapability("appium:deviceName", "Galaxy Tab A");
        caps.setCapability("appium:udid", "R9WNC1R1P5J");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage", "com.dinetap.app.qa");
        caps.setCapability("appium:appActivity", "com.dinetap.app.MainActivity");
        caps.setCapability("appium:noReset", true);

        URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(appiumServerUrl, caps); // ✅ non-generic constructor
    }

    @Test
    public void launchAppTest() {
        System.out.println("✅ App launched successfully on Galaxy Tab A.");
    }










    //just remove below 2 if any issues occring contnuosly




    @Test(priority = 1)
    public void verifySplashText() {
        try {
            // Update with the actual resource-id or XPath of the splash element
            WebElement splashElement = driver.findElement(
                    By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']")
            );

            String actualText = splashElement.getText();
            String expectedText = ExcelUtils.getExpectedText("splashText");

            System.out.println("🔍 Actual UI text: " + actualText);
            System.out.println("📖 Expected from Excel: " + expectedText);

            Assert.assertEquals(actualText.trim(), expectedText.trim(), "Splash text does not match!");

            System.out.println("✅ Splash screen text verified successfully without POM.");
        } catch (Exception e) {
            System.out.println("❌ Error during splash text validation: " + e.getMessage());
            Assert.fail("Test failed due to exception.");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🔚 Driver session ended.");
        }
    }











}
