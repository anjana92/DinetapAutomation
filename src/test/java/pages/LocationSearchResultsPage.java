package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class LocationSearchResultsPage {

    private AppiumDriver driver;

    // Locators
    private final By searchBox = By.xpath("//android.widget.EditText");
    private final By mallsSection = By.xpath("//android.widget.TextView[@text='Malls']");
    private final By addressesSection = By.xpath("//android.widget.TextView[@text='Addresses']");
    private final By filteredResult = By.xpath("//android.widget.TextView[@text='Bayfront Avenue, Marina Bay Sands Hotel Tower 1, Singapore']");
    private final By noResultsText = By.xpath("//android.widget.TextView[@text='No results found']");

    /*private final By mallResults = By.xpath(
            "//android.widget.TextView[@text='Malls']/following-sibling::android.view.ViewGroup//android.widget.TextView[not(@text='Malls') and not(@text='Addresses')]"
    );

    private final By addressResults = By.xpath(
            "//android.widget.TextView[@text='Addresses']/following-sibling::android.view.ViewGroup//android.widget.TextView[not(@text='Malls') and not(@text='Addresses')]"
    );*/


    private final By mallResults = By.xpath(
            "//android.view.ViewGroup[preceding-sibling::android.widget.TextView[@text='Malls']]//android.widget.TextView"
    );

    private final By addressResults = By.xpath(
            "//android.view.ViewGroup[preceding-sibling::android.widget.TextView[@text='Addresses']]//android.widget.TextView"
    );



    public LocationSearchResultsPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void enterSearchTerm(String term) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(term);
    }

    public boolean isMallsSectionPresent() {
        return !driver.findElements(mallsSection).isEmpty();
    }

    public boolean isAddressesSectionPresent() {
        return !driver.findElements(addressesSection).isEmpty();
    }

    public List<WebElement> getMallResults() {
        return driver.findElements(mallResults);
    }

    public List<WebElement> getAddressResults() {
        return driver.findElements(addressResults);
    }







    public String getFilteredResultTextContaining(String partialTerm) {
        String xpath = "//android.widget.TextView[contains(@text, \"" + partialTerm + "\")]";
        System.out.println("👉 Using XPath: " + xpath);  // Debug log

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return result.getText();
    }





    public boolean isNoResultsFoundTextVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement noResultsElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(noResultsText)
            );
            return noResultsElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
