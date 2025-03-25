package POM_pages;
import Gen_lib.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Login_page {

    WebDriver driver;
    WaitHelper whp;
    @FindBy(linkText = "Log in")
    private WebElement login_link;

    @FindBy(id = "Email")
    private WebElement Email_id_tb;
    @FindBy(id = "Password")
    private WebElement Pwd_id_tb;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    private WebElement submit_xpath;

    @FindBy(linkText = "kjiabcc@gmail.com")
    private WebElement Email_link;

    public Login_page(WebDriver driver, int duration) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializing elements
        whp = new WaitHelper(driver, duration);
    }

    public void click_on_Login_link() {
        whp.waitForClickable(login_link);
        login_link.click();
    }
    public void enter_the_email_id(String email){
        whp.waitForVisibility(Email_id_tb);
        Email_id_tb.clear();
        Email_id_tb.sendKeys(email);
    }

    public void enter_the_pwd(String pwd){
        whp.waitForVisibility(Pwd_id_tb);
        Pwd_id_tb.clear();
        Pwd_id_tb.sendKeys(pwd);
    }

    public void click_on_submit() {
        whp.waitForClickable(submit_xpath);
        submit_xpath.click();
    }

    public boolean validating_logged_in_email(String email){
        whp.waitForVisibility(Email_link);
        if(Email_link.getText().equalsIgnoreCase(email)){ // String == String
            System.out.println(Email_link.getText());
            System.out.println("test pass");
            return true;
        }
        else{
            System.out.println("test Fail");
            return false;
        }
    }

}
