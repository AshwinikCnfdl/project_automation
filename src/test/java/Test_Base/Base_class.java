package Test_Base;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.time.Duration;

public class Base_class {
    public WebDriver driver;
    public Logger logger;
    public Properties p;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeClass
    @Parameters({"os", "browser"})
    public void setUp(String os, String browser) throws IOException {
        logger = LogManager.getLogger(this.getClass());
        logger.info("Starting test execution on OS: " + os + " | Browser: " + browser);

        // Setup Extent Reports
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./Reports/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Load properties file
        p = new Properties();
        FileInputStream file = new FileInputStream("./src/main/resources/config.properties");
        p.load(file);

        // Browser setup using WebDriverManager
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                logger.info("Launched Chrome Browser");
                break;
            case "firefox":
                driver = new FirefoxDriver();
                logger.info("Launched Firefox Browser");
                break;
            case "edge":
                driver = new EdgeDriver();
                logger.info("Launched Edge Browser");
                break;
            default:
                logger.error("Invalid browser selection: " + browser);
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        // Open the application URL
        driver.get(p.getProperty("app_url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        logger.info("Navigated to application: " + p.getProperty("app_url"));

        test = extent.createTest("Setup Test").info("Browser launched and navigated to the application");
    }

    @AfterMethod
    public void captureFailureScreenshot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            String screenshotPath = takeScreenshot(result.getName());
            test.fail("Test Failed: " + result.getThrowable());
            test.addScreenCaptureFromPath(screenshotPath);
            logger.error("Test Failed: Screenshot captured at " + screenshotPath);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed successfully.");
        }
        extent.flush();
        logger.info("Extent Report Generated.");
    }

    // Method to capture screenshot
    public String takeScreenshot(String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotPath = System.getProperty("user.dir") + "/Screen_shorts/" + testName + "_" + timestamp + ".png";

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(screenshotPath);

        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            logger.error("Failed to save screenshot: " + e.getMessage());
        }

        return screenshotPath;
    }
}
