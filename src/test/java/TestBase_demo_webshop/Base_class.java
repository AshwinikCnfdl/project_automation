package TestBase_demo_webshop;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base_class {

    public static WebDriver driver;
    public Logger logger;
    Properties p;
    public static ExtentReports extent; // 🔹 Make it static
    public static ExtentSparkReporter sparkReporter; // 🔹 Make it static

    @BeforeSuite
    public void startReport() {
        if (extent == null) {  // Prevent reinitialization
            sparkReporter = new ExtentSparkReporter("./Reports/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
    }

    @BeforeClass
    @Parameters({"os", "browser"})
    public void set_up(String os, String browser) throws IOException {
        p = new Properties();
        FileInputStream file = new FileInputStream("./src/main/resources/config.properties");
        p.load(file);

        logger = LogManager.getLogger(this.getClass());

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                logger.info("Open Chrome Browser");
                break;
            case "firefox":
                driver = new FirefoxDriver();
                logger.info("Open Firefox Browser");
                break;
            case "edge":
                driver = new EdgeDriver();
                logger.info("Open Edge Browser");
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(p.getProperty("app_url"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void closeReport() {
        if (extent != null) {
            extent.flush();
        }
    }



}

