package Test_cases_for_webshope;

import POM_pages.Home_page;
import POM_pages.Reg_page;
import TestBase_demo_webshop.Base_class;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Reg_demo_wenshop_Test_001 extends Base_class {
    static String fn, ln, email, pwd, cpwd;
    public ExtentTest test;

    @BeforeMethod
    public void setupTest() {
        if (extent == null) {
            throw new IllegalStateException("ExtentReports is not initialized! Check Base_class.");
        }
        test = extent.createTest("Registration Test").info("Starting Test_001");
    }

    @Test
    public void TestCases1() {
        fn = "abc";
        ln = "x";
        email = "abc@gmail.com";
        pwd = "abc@123";
        cpwd = "abc@123";

        logger.info("************** Registration Test Started **************");

        test.log(Status.INFO, "Navigating to Home Page");
        Home_page hp = new Home_page(driver, 20);
        hp.click_on_register_link();

        test.log(Status.INFO, "Navigating to Registration Page");
        Reg_page rp = new Reg_page(driver, 20);

        rp.enter_the_fn(fn);
        test.log(Status.INFO, "Entered First Name: " + fn);

        rp.enter_the_ln(ln);
        test.log(Status.INFO, "Entered Last Name: " + ln);

        rp.enter_the_email_id(email);
        test.log(Status.INFO, "Entered Email: " + email);

        rp.enter_the_pwd(pwd);
        test.log(Status.INFO, "Entered Password");

        rp.enter_the_cpwd(cpwd);
        test.log(Status.INFO, "Entered Confirm Password");

        test.log(Status.PASS, "Registration Test Completed Successfully");
    }
}
