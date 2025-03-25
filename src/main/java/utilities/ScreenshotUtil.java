package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {
    public static String takeScreenshot(WebDriver driver, String testName) {
        // Create a timestamp to avoid duplicate filenames
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png";

        // Take the screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(screenshotPath);

        try {
            // Copy file to the target location
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }

        return screenshotPath; // Returning the screenshot path
    }

////    public static void main(String[] args) {
////        // Setup WebDriver
////        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
////        WebDriver driver = new ChromeDriver();
////
////        try {
////            driver.get("https://example.com");
////            String path = takeScreenshot(driver, "TestScreenshot");
////            System.out.println("Screenshot saved at: " + path);
////        } finally {
////            driver.quit();
////        }
//    }
}
