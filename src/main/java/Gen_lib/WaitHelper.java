package Gen_lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitHelper {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize WebDriverWait
    public WaitHelper(WebDriver driver,int duration) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(duration)); // Default wait time
    }

    // Wait for element to be present in the DOM
    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait for element to be visible
    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait for element to be clickable
    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
