package frondenduser;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ReadFromFiles;
import utility.TestUtility;

public class LoginWithAccount {
    WebDriver driver;
    TestUtility utility;
    static String Email= ReadFromFiles.readConfigProperties("emailAddress1");
    static String Password=ReadFromFiles.readConfigProperties("password");

    public LoginWithAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }
    @FindBy(id = "email")
    WebElement emailFiled;

    @FindBy(id="pass")
    WebElement passwordFiled;

    @FindBy(id = "send2")
    WebElement loginButton;

    @FindBy(xpath = "//*[@class='account-login']/ul/li/ul/li/span")
    WebElement WrongMsg;


    public void LoginFunction(){
        utility.waitForElementPresent(emailFiled);
        emailFiled.sendKeys(Email);
        utility.waitForElementPresent(passwordFiled);
        passwordFiled.sendKeys(Password);
        utility.waitForElementPresent(loginButton);
        loginButton.click();

    }

    public void LoginForInvalid(String password){
        utility.waitForElementPresent(emailFiled);
        emailFiled.sendKeys(utility.randomEmail());
        utility.waitForElementPresent(passwordFiled);
        passwordFiled.sendKeys(password);
        driver.findElement(By.id("send2"));
        loginButton.click();



    }public void verifyInvalid(){
        utility.waitForElementPresent(WrongMsg);
        WrongMsg.isDisplayed();
    }
    public void multipleLogin(String data1,String data2){
        utility.waitForElementPresent(emailFiled);
        emailFiled.sendKeys(data1);
        utility.waitForElementPresent(passwordFiled);
        passwordFiled.sendKeys(data2);
        utility.waitForElementPresent(loginButton);
        loginButton.click();
    }


}
