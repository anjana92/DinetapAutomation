package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static AppiumDriver driver;

    @BeforeSuite
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
        //caps.setCapability("appium.autoGrantPermissions", false);
        //caps.setCapability("appium.appWaitActivity", "*");


        URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(appiumServerUrl, caps);

    }

    /*@AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🔚 Driver session ended.");
        }
    }*/



    public String captureScreenshot(String testName) {
        String screenshotDir = "test-output/screenshots/";
        String fileName = testName + "_" + System.currentTimeMillis() + ".png";
        String fullPath = screenshotDir + fileName;

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(fullPath);
        destFile.getParentFile().mkdirs();

        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ✅ Return relative path so ExtentReports can resolve it
        return "screenshots/" + fileName;
    }


    public static AppiumDriver getDriver() {
        return driver;
    }







}
