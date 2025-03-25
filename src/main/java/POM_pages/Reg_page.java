package POM_pages;

import Gen_lib.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reg_page {
    WebDriver driver;
    WaitHelper whp;

    @FindBy(id = "FirstName")
    private WebElement FirstName_tb_id;

    @FindBy(id = "LastName")
    private WebElement LastName_tb;

    @FindBy(id = "Email")
    private WebElement Email_id_tb;

    @FindBy(id = "Password")
    private WebElement Password_tb;

    @FindBy(id = "ConfirmPassword")
    private WebElement ConfirmPassword_tb;

    @FindBy(id = "register-button")
    private WebElement register_button;

    @FindBy(xpath = "//li[text()='The specified email already exists']")
    private WebElement error_msg_ele;

    @FindBy(xpath = "(//a[@href='/customer/info'])[1]")
    private WebElement user_login_mail_id;

    // find ele :-- WebDriver
    // constructors
    public Reg_page(WebDriver driver,int duration){
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializing elements
        whp = new WaitHelper(driver,duration);
    }

    // access methods/actions methods
    public void enter_the_fn(String fn){
       whp.waitForVisibility(FirstName_tb_id);
        FirstName_tb_id.clear();
        FirstName_tb_id.sendKeys(fn);
    }
    public void enter_the_ln(String ln){
        whp.waitForVisibility(LastName_tb);
        LastName_tb.clear();
        LastName_tb.sendKeys(ln);
    }

    public void enter_the_email_id(String email){
        whp.waitForVisibility(Email_id_tb);
        Email_id_tb.clear();
        Email_id_tb.sendKeys(email);
    }

    public void enter_the_pwd(String pwd){
        whp.waitForVisibility(Password_tb);
        Password_tb.clear();
        Password_tb.sendKeys(pwd);
    }

    public void enter_the_cpwd( String cpwd){
        whp.waitForVisibility(ConfirmPassword_tb);
        ConfirmPassword_tb.clear();
        ConfirmPassword_tb.sendKeys(cpwd);
    }

    public void click_on_reg_button(){
        whp.waitForVisibility(register_button);
        register_button.click();

    }

    public void validating_getting_error_msg_or_not(String emg){
        whp.waitForVisibility(error_msg_ele);
        if(error_msg_ele.getText().equalsIgnoreCase(emg)){ // String == String
            System.out.println("test pass");
            assert true;
        }
        else{
            System.out.println("test Fail");
            assert false;
        }
    }

    public void validating_reg_user_or_not(String email){
        whp.waitForVisibility(user_login_mail_id);
        if(user_login_mail_id.getText().equalsIgnoreCase(email)){ // String == String
            System.out.println("test pass");
            assert true;
        }
        else{
            System.out.println("test Fail");
            assert false;
        }
    }



}

