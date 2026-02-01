package pageobjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    
    //constructor
    public HomePage(WebDriver driver){
        super(driver);
        
    }

    //Locators
    /*By txt_username_loc = By.xpath("//input[@placeholder='Username']");
    By txt_password_loc = By.xpath("//input[@placeholder='Password']");
    By btn_loginButton_loc = By.xpath("//button[@type='submit']");
    */
    @FindBy(how=How.XPATH, using="//input[@placeholder='Username']")
    WebElement txt_username;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement txt_password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btn_loginButton;

    //username action
    public void setUserName(String uname){
        txt_username.sendKeys(uname);
    }
    
    //password action
    public void setPassword(String pwd){
        txt_password.sendKeys(pwd);
    }
    
    //Login action
    public void clickLogin(){
        btn_loginButton.click();

    }


}
