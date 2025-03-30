package TestCases;
import POM_pages.Home_page;
import POM_pages.Reg_page;
import Test_Base.Base_class;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
//import static utilities.ScreenshotUtil.takeScreenshot;
public class LogFileTest extends Base_class {
    @Test
    public void Test_Reg_log_001() {
        test = extent.createTest("Test_Reg_log_001"); // Create Extent Report Test
        logger.info("********************* Started test case: Test_Reg_log_001 ******************");
        test.log(Status.INFO, "Started Test Case: Test_Reg_log_001");

        logger.info("Opening the browser and navigating to the URL");
        test.log(Status.INFO, "Opened the browser and navigated to the application");

        Home_page hp = new Home_page(driver, 20);
        logger.info("****************** Home Page Loaded ******************");
        test.log(Status.INFO, "Navigated to Home Page");

        hp.click_on_register_link();
        logger.info("Clicked on the Register link");
        test.log(Status.INFO, "Clicked on the Register link");

        Reg_page rp = new Reg_page(driver, 20);
        rp.enter_the_fn("abc");
        logger.info("Entered First Name");
        test.log(Status.INFO, "Entered First Name: abc");

        rp.enter_the_ln("A");
        logger.info("Entered Last Name");
        test.log(Status.INFO, "Entered Last Name: A");

        rp.enter_the_email_id("abc@gmail.com");
        logger.info("Entered Email ID");
        test.log(Status.INFO, "Entered Email ID: abc@gmail.com");

        rp.enter_the_pwd("abc@123");
        logger.info("Entered Password");
        test.log(Status.INFO, "Entered Password");

        rp.enter_the_cpwd("abc@123");
        logger.info("Entered Confirm Password");
        test.log(Status.INFO, "Entered Confirm Password");

        rp.click_on_reg_button();
        logger.info("Clicked on Register Button");
        test.log(Status.PASS, "Registration Completed Successfully");
    }}

