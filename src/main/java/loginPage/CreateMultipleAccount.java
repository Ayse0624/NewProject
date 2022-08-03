package loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ReadFromFiles;
import utility.TestUtility;


public class CreateMultipleAccount {
    WebDriver driver;
    TestUtility utility;
    static String Password= ReadFromFiles.readConfigProperties("password");

    public CreateMultipleAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility =new TestUtility(driver);

    }
    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(id = "lastname")
    WebElement lastName;

    @FindBy(id="email_address")
    WebElement email;

    @FindBy(id = "password")
    WebElement PasswordFiled;

    @FindBy(id = "confirmation")
    WebElement ConfirmPassword;

    @FindBy(css = "#form-validate > div.buttons-set > button")
    WebElement Button;

    @FindBy(xpath = "//*[contains(text(),'Thank you for registering with eCommerce Shopping.')]")
    WebElement CreateSuccsufuly;

    @FindBy(css = "#header > div > div.skip-links > div > a > span.label")
    WebElement AccountButton;

    @FindBy(css = "#header-account > div > ul > li.last > a")
    WebElement LogoutButton;

    public void createMultipleAccountEnter(String FirstName,String LastName,String EmailAddress,String password){
        utility.waitForElementPresent(firstName);
        firstName.sendKeys(FirstName);
        utility.waitForElementPresent(lastName);
        lastName.sendKeys(LastName);
        utility.waitForElementPresent(email);
        email.sendKeys(EmailAddress);
        utility.waitForElementPresent(PasswordFiled);
        PasswordFiled.sendKeys(password);
        utility.waitForElementPresent(ConfirmPassword);
        ConfirmPassword.sendKeys(password);
        utility.waitForElementPresent(Button);
        Button.click();
        /*utility.waitForElementPresent(AccountButton);
        AccountButton.click();
        utility.waitForElementPresent(LogoutButton);
        LogoutButton.click();*/
    }
    public boolean succesCreateMassage(){
        utility.waitForElementPresent(CreateSuccsufuly);
        return  CreateSuccsufuly.isDisplayed();

    }

}

