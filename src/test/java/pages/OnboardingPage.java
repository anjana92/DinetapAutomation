package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OnboardingPage {
    AppiumDriver driver;

    public OnboardingPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // --- Screen 1 ---
    By screen1Title = By.xpath("//android.widget.TextView[contains(@text, 'Prepay any amount')]");
    By screen1Description = By.xpath("//android.widget.TextView[contains(@text, 'Prepay to restaurant-specific wallets')]");
    By screen1Arrow = By.xpath("//android.view.ViewGroup[@content-desc='Get Started']");

    // --- Screen 2 ---
    By screen2Title = By.xpath("//android.widget.TextView[contains(@text, 'Separate wallets')]");
    By screen2Description = By.xpath("//android.widget.TextView[contains(@text, 'Easily track and manage your prepayments')]");
    By screen2Arrow = screen1Arrow;

    // --- Screen 3 ---
    By screen3Title = By.xpath("//android.widget.TextView[contains(@text, 'Settle bills')]");
    By screen3Description = By.xpath("//android.widget.TextView[contains(@text, 'Enter the bill amount, select how much')]");
    By screen3Arrow = screen1Arrow;

    // --- Screen 4 ---
    By screen4Title = By.xpath("//android.widget.TextView[contains(@text, 'Your credits')]");
    By screen4Description1 = By.xpath("//android.widget.TextView[contains(@text, 'Use any amount')]");
    By screen4Description2 = By.xpath("//android.widget.TextView[contains(@text, 'Unlike vouchers')]");
    private final By getStartedButton = By.xpath("//android.widget.TextView[@text='Get Started']");
    //private final By loginHeaderText = By.xpath("//android.widget.TextView[contains(@text, 'Prepay and get')]");
    //By loginHeaderText = By.xpath("//android.widget.TextView[normalize-space(.)='Prepay and get extra credits to dine']");
    //private final By loginHeaderText = By.xpath("//android.widget.TextView[@text='Prepay and get extra credits to dine']");
    private final By loginHeaderText = By.xpath("//android.widget.TextView[contains(@text, 'Prepay and get')]");


    // Utility Methods (common)
    private String getText(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    // --- Screen 1 methods ---
    public String getScreen1TitleText() {
        return getText(screen1Title);
    }

    public String getScreen1DescriptionText() {
        return getText(screen1Description);
    }

    public void clickScreen1Arrow() {
        driver.findElement(screen1Arrow).click();
    }

    // --- Screen 2 methods ---
    public boolean isScreen2TitleDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(screen2Title));
            return true;
        } catch (Exception e) {
            System.out.println("❌ Screen 2 title not found.\n" + driver.getPageSource());
            return false;
        }
    }

    public String getScreen2TitleText() {
        return getText(screen2Title);
    }

    public String getScreen2DescriptionText() {
        return getText(screen2Description);
    }

    public void clickScreen2Arrow() {
        driver.findElement(screen2Arrow).click();
    }

    // --- Screen 3 methods ---
    public boolean isScreen3TitleDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(screen3Title));
            return true;
        } catch (Exception e) {
            System.out.println("❌ Screen 3 title not found.\n" + driver.getPageSource());
            return false;
        }
    }

    public String getScreen3TitleText() {
        return getText(screen3Title);
    }

    public String getScreen3DescriptionText() {
        return getText(screen3Description);
    }


    public boolean isScreen4TitleDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(screen4Title));
            return true;
        } catch (Exception e) {
            System.out.println("❌ Screen 4 title not found.\n" + driver.getPageSource());
            return false;
        }
    }

    public String getScreen4TitleText() {
        return getText(screen4Title);
    }

    public String getScreen4Description1Text() {
        return getText(screen4Description1);
    }

    public String getScreen4Description2Text() {
        return getText(screen4Description2);
    }



    public void swipeLeft() {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        int startX = (int) (width * 0.9);
        int endX = (int) (width * 0.1);
        int y = height / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        driver.perform(List.of(swipe));
    }

    public void swipeRight() {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        int startX = (int) (width * 0.1);
        int endX = (int) (width * 0.9);
        int y = height / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(swipe));
    }


//    public String getLoginHeaderText() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeaderText));
//        return title.getText().replaceAll("\\s+", " ").trim();
//        //return headerElement.getText();
//    }

    public String getLoginHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeaderText));
        return title.getText().replaceAll("\\s+", " ").trim();  // very important
    }

    public String getGetStartedText() {
        return driver.findElement(getStartedButton).getText();
    }

    public void clickGetStartedButton() {
        driver.findElement(getStartedButton).click();
    }



}
