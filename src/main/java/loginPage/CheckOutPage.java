package loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utility.TestUtility;

public class CheckOutPage {
    WebDriver driver;
    TestUtility utility;
    // DashboardPage dashboardPage;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
        //dashboardPage=new DashboardPage(driver);

    }
    @FindBy(css = "a[class=top-link-checkout]")
    WebElement checkOutLink;

    @FindBy(id = "billing:save_in_address_book")
    WebElement checkOutCheckBox;

    @FindBy(css = "button[title=Continue]")
    WebElement continueLink;

    @FindBy(xpath = "//header/div[1]/div[2]/div[1]/a[1]/span[2]")
    WebElement AccountLink;

    @FindBy (id= "billing-address-select")
    WebElement selectLinkInCeckOut;

//    @FindBy(id="s_method_freeshipping_freeshipping")
//    WebElement freeShop;
//
//    @FindBy(css = "#shipping-method-buttons-container > button")
//    WebElement continueButton;

    @FindBy(id = "p_method_cashondelivery")
    WebElement checkMoneyOrder;

    @FindBy(css = "#payment-buttons-container > button")
    WebElement continueCheckOrder;

    @FindBy(css = "button[class='button btn-checkout']")
    WebElement placeOrderButton;

    @FindBy(css = "div[class='page-title']")
    WebElement checkOutSuccessMsg;



    public void checkOut(){
        utility.waitForElementPresent(AccountLink);
        AccountLink.click();
        utility.waitForElementPresent(checkOutLink);
        checkOutLink.click();
        utility.sleep(3);
        //utility.waitForElementPresent(selectLinkInCeckOut);
        //selectLinkInCeckOut.click();
        Select select=new Select(selectLinkInCeckOut);
        select.selectByVisibleText("New Address");
        utility.waitForElementPresent(checkOutCheckBox);
        checkOutCheckBox.click();
        utility.waitForElementPresent(continueLink);
        continueLink.click();
//        utility.waitForElementPresent(freeShop);
//        freeShop.click();
//        utility.waitForElementPresent(continueButton);
//        continueButton.click();
        utility.waitForElementPresent(checkMoneyOrder);
        checkMoneyOrder.click();
        utility.waitForElementPresent(continueCheckOrder);
        continueCheckOrder.click();
        utility.waitForElementPresent(placeOrderButton);
        placeOrderButton.click();
    }
    public void checkOutSuccessMessege(){
        utility.waitForElementPresent(checkOutSuccessMsg);
        if (checkOutSuccessMsg.isDisplayed())
            System.out.println(checkOutSuccessMsg.getText());
    }



}

