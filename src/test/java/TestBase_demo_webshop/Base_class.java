package TestBase_demo_webshop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class Base_class{

    public WebDriver driver ;
    public Logger logger;
    @BeforeClass
    @Parameters({"os","browser"})
    public void set_up(String os, String browser){
        logger = LogManager.getLogger(this.getClass());
        switch (browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                logger.info("open the ChromeBrowser");
                break;
            case "firefox":
                driver = new FirefoxDriver();
                logger.info("open the FireFox browser");
                break;
            case "edge":
                driver = new EdgeDriver();
                logger.info("open the Edge Browser");
                break;
            default:
                System.out.println("invalid browser");
                return;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demowebshop.tricentis.com/");
    }


    @AfterClass
    public void trad_down(){
        driver.quit();
    }


}
