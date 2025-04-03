package Test_cases_for_webshope;

import POM_pages.Login_page;
import TestBase_demo_webshop.Base_class;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.File;
import static utilities.ScreenshotUtil.takeScreenshot;

public class Login_webshop_Test_002 extends Base_class {
    static String email, pwd;
    public ExtentTest test;

    @BeforeMethod
    public void setupTest() {
        if (extent == null) {
            throw new IllegalStateException("ExtentReports is not initialized! Check Base_class.");
        }
        test = extent.createTest("Login Test").info("Starting Test_002");
    }

    @Test
    void Login_test() {
        try {
            email = "kjiabcc@gmail.com";
            pwd = "abc@123";

            logger.info("************** Login Test Started **************");

            test.log(Status.INFO, "Navigating to Login Page");
            Login_page lp = new Login_page(driver, 10);
            lp.click_on_Login_link();

            test.log(Status.INFO, "Entering Email: " + email);
            lp.enter_the_email_id(email);

            test.log(Status.INFO, "Entering Password");
            lp.enter_the_pwd(pwd);

            test.log(Status.INFO, "Clicking Login Button");
            lp.click_on_submit();

            test.log(Status.INFO, "Validating Login...");
            boolean test_res = lp.validating_logged_in_email(email);

            if (!test_res) {
                test.log(Status.FAIL, "Login Failed for email: " + email);
                logger.error("Login validation failed! Expected email: " + email);
                Assert.fail("Login validation failed! Expected email: " + email);
            }

            logger.info("Test Passed! User successfully logged in.");
            test.log(Status.PASS, "Login Test Passed Successfully!");

        } catch (Exception e) {
            logger.error("Test Failed due to exception: ", e);
            test.log(Status.FAIL, "Test failed due to exception: " + e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }


    }
    @AfterMethod
    public void captureFailureScreenshot(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            String screenshotPath = takeScreenshot(driver, result.getName());

            // Print the file path for debugging
            System.out.println("Screenshot saved at: " + screenshotPath);

            test.fail("Test Failed: " + result.getThrowable());

            File screenshotFile = new File(screenshotPath);
            if (screenshotFile.exists()) {
                String absolutePath = screenshotFile.getAbsolutePath();
                test.addScreenCaptureFromPath(screenshotFile.getAbsolutePath());
                logger.error("Test Failed: Screenshot captured at " + absolutePath);
            } else {
                test.fail("Screenshot file not found at: " + screenshotPath);
                logger.error("Screenshot file not found at: " + screenshotPath);
            }
        }
    }

//    @AfterMethod
//    public void captureFailureScreenshot(ITestResult result) {
//        if (ITestResult.FAILURE == result.getStatus()) {
//            String screenshotPath = takeScreenshot(driver, result.getName());
//            test.fail("Test Failed: " + result.getThrowable() + screenshotPath);
//            File screenshotFile = new File(screenshotPath);
//            String absolutePath = screenshotFile.getAbsolutePath();
//            test.addScreenCaptureFromPath(absolutePath);
//            logger.error("Test Failed: Screenshot captured at " + screenshotPath);
//        }
//    }

}
