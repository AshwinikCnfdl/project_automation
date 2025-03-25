package TestCases;

import POM_pages.Home_page;
import POM_pages.Reg_page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.time.Duration;

public class Test_cases_demo1 {

   @Test
   public void Test_Reg_001(){

       WebDriver driver = new ChromeDriver();
       driver.get("https://demowebshop.tricentis.com/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

       Home_page hp = new Home_page(driver,20);
       hp.click_on_register_link();

       Reg_page rp = new Reg_page(driver,20);
       rp.enter_the_fn("abc");
       rp.enter_the_ln("A");
       rp.enter_the_email_id("abc@gmail.com");
       rp.enter_the_pwd("abc@123");
       rp.enter_the_cpwd("abc@123");
       rp.click_on_reg_button();


   }}

