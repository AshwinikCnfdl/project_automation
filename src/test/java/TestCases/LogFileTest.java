package TestCases;

import POM_pages.Home_page;
import POM_pages.Reg_page;
import Test_Base.Base_class;
import utilities.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.ExcelUtils.get_num_rows_col;

public class LogFileTest extends Base_class {


    @DataProvider(name = "RegTestData")
    public Object[][] getRegData() throws Exception {
        return ExcelUtils.testData_excel("./Test_data/Test_data.xlsx", "Reg");
    }

    @Test(dataProvider = "RegTestData")
    public void Test_Reg_log_001(String firstName, String lastName, String email, String password, String confirmPassword, String v, String st) throws IOException {
        int[] r_c = get_num_rows_col("./Test_data/Test_data.xlsx", "Reg");
        test = extent.createTest("Test_Reg_log_001");
        logger.info("********************* Started test case: Test_Reg_log_001 ******************");
        test.log(Status.INFO, "Started Test Case: Test_Reg_log_001");

        try {
            logger.info("Opening the browser and navigating to the URL");
            test.log(Status.INFO, "Opened the browser and navigated to the application");

            Home_page hp = new Home_page(driver, 20);
            logger.info("****************** Home Page Loaded ******************");
            test.log(Status.INFO, "Navigated to Home Page");

            hp.click_on_register_link();
            logger.info("Clicked on the Register link");
            test.log(Status.INFO, "Clicked on the Register link");

            Reg_page rp = new Reg_page(driver, 20);
            rp.enter_the_fn(firstName);
            rp.enter_the_ln(lastName);
            rp.enter_the_email_id(email);
            rp.enter_the_pwd(password);
            rp.enter_the_cpwd(confirmPassword);
            rp.click_on_reg_button();

            logger.info("Clicked on Register Button");
            test.log(Status.PASS, "Registration Completed Successfully");
            st = "Pass";

        } catch (Exception e) {
            test.log(Status.FAIL, "Test Failed: " + e.getMessage());
            st = "Fail";
        }


        // Update result in Excel
        try {
            ExcelUtils.updateCell("./Test_data/Test_data.xlsx", "Reg",1, r_c[1] , st); // Assuming 6th column holds test result
            logger.info("Updated test result in Excel: " + st);
        } catch (Exception e) {
            logger.error("Failed to update Excel: " + e.getMessage());
        }
    }





}
