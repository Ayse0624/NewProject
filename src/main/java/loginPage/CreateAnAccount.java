package loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ReadFromFiles;
import utility.TestUtility;


public class CreateAnAccount {
    WebDriver driver;
    TestUtility utility;
    String Password= ReadFromFiles.readConfigProperties("password");

    public CreateAnAccount(WebDriver driver) {
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

    public void createAnAccountEnter(){
        utility.waitForElementPresent(firstName);
        firstName.sendKeys(utility.FakeString());
        utility.waitForElementPresent(lastName);
        lastName.sendKeys(utility.FakeString());
        utility.waitForElementPresent(email);
        email.sendKeys(utility.randomEmail());
        utility.waitForElementPresent(PasswordFiled);
        PasswordFiled.sendKeys(Password);
        utility.waitForElementPresent(ConfirmPassword);
        ConfirmPassword.sendKeys(Password);
        utility.waitForElementPresent(Button);
        Button.click();
    }
    public void succesCreateMassage(){
        utility.waitForElementPresent(CreateSuccsufuly);
        if (CreateSuccsufuly.isDisplayed());
        System.out.println("success ");
        //return  CreateSuccsufuly.isDisplayed();
    }

}

