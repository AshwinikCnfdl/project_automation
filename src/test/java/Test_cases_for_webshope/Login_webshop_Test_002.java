package Test_cases_for_webshope;
import POM_pages.Login_page;
import TestBase_demo_webshop.Base_class;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Login_webshop_Test_002 extends Base_class {
    static String email, pwd;

    @Test
    void Login_test() {
        try {
            email = "kjiabcc@gmail.com";
            pwd = "abc@123";

            logger.info("************ Login_webshop_Test_002 ************");
            logger.info("Navigating to login page...");

            Login_page lp = new Login_page(driver, 10);

            logger.info("Clicking on the login link...");
            lp.click_on_Login_link();

            logger.info("Entering email: " + email);
            lp.enter_the_email_id(email);

            logger.info("Entering password...");
            lp.enter_the_pwd(pwd);

            logger.info("Clicking on login button...");
            lp.click_on_submit();

            logger.info("Validating login...");
            boolean test_res = lp.validating_logged_in_email("abc@gmail.com");

            if (!test_res) {
                logger.error("Login validation failed! Expected email: " + email);
                Assert.fail("Login validation failed! Expected email: " + email);
            }

            logger.info("Test passed! User successfully logged in.");

        } catch (Exception e) {
            logger.error("Test Failed due to exception: ", e);
            Assert.fail("Test failed due to exception: " + e.getMessage());
        } finally {
            logger.info("Test execution completed.");
            System.out.println("hello");
        }
    }
}

// Data driven :-- static data dynamic data
// fix data  :-- url email pwd
// BDD :-- >

