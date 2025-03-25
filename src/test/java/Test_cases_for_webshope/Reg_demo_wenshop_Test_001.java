package Test_cases_for_webshope;

import POM_pages.Home_page;
import POM_pages.Reg_page;
import TestBase_demo_webshop.Base_class;
import org.testng.annotations.Test;

import java.time.Duration;

public class Reg_demo_wenshop_Test_001  extends Base_class {
    static String fn,ln,email,pwd,cpwd;
    @Test
    public void TestCases1() {
        fn = "abc";
        ln = "x";
        email = "abc@gmail.com";
        pwd = "abc@123";
        cpwd = "abc@123";
        logger.info(" **************        Reg_demo_wenshop_Test_001 Test Started *************************");
        Home_page hp = new Home_page(driver, 20);
        logger.info("navigate to Home page");
        hp.click_on_register_link();
        logger.info("click on the reg Link");
        Reg_page rp = new Reg_page(driver, 20);
        rp.enter_the_fn(fn);
        logger.info("enter the First name  = " + fn);
        rp.enter_the_ln(ln);
        logger.info("enter the last name = " + ln );
        rp.enter_the_email_id(email);
        logger.info("enter the enter the email id  = " + email);
        rp.enter_the_pwd(pwd);
        logger.info("enter the pwd = " + pwd);
        rp.enter_the_cpwd(cpwd);
        logger.info("enter the cpwd = " + cpwd);
    }
//    @Test
//    public void Test1(){
//        System.out.println("Test1");
//    }
//
//    @Test
//    public void Test2(){
//        System.out.println("Test2");
//    }
//
//    @Test
//    public void Test3(){
//        System.out.println("Test3");
//    }
}

//TestNG xml file
