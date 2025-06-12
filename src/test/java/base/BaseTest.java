package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver driver;

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
        driver = new AndroidDriver(appiumServerUrl, caps);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🔚 Driver session ended.");
        }
    }
}
