package POM_pages;

import Gen_lib.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Home_page {

    WebDriver driver;
    WaitHelper whp;

    @FindBy(linkText = "Register")
    private WebElement register_link;

    @FindBy(linkText = "Log in")
    private WebElement log_in_link ;

    @FindBy(linkText =  "Shopping cart")
    private WebElement shopping_cart_link;

    @FindBy(id = "small-searchterms")
    private WebElement searchterms_text_box_id;

    @FindBy(xpath =  "//input[@type='submit']")
    private WebElement serach_button_xpath;

    @FindBy(partialLinkText = "Books")
    private WebElement Books_link;

    @FindBy(partialLinkText = "Computers")
    private WebElement computers;

    @FindBy(xpath = "//li[@class='answer']")
    private List<WebElement> communitypoll;

    // find ele :-- WebDriver
    // constructors
    public Home_page(WebDriver driver,int duration){
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initializing elements
        whp = new WaitHelper(driver,duration);
    }

    // access methods/actions methods
    public void click_on_register_link(){
        whp.waitForClickable(register_link);
        register_link.click();
    }
    public void click_on_Login_link(){
        whp.waitForClickable(log_in_link);
        log_in_link.click();
    }









}
