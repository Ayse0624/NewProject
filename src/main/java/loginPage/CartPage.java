package loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.TestUtility;

public class CartPage {
    WebDriver driver;
    TestUtility utility;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
    }
    @FindBy(xpath = "//*[@class=\"success-msg\"]")
    WebElement successMsg;
}
