package loginPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.TestUtility;

import java.util.List;

public class DashboardPage {
    WebDriver driver;
    TestUtility utility;
    CheckOutPage checkOutPage;
    CartPage cartPage;
    CreateAnAccount createAnAccount;


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        utility=new TestUtility(driver);
        checkOutPage=new CheckOutPage(driver);
        cartPage=new CartPage(driver);
        createAnAccount=new CreateAnAccount(driver);
    }

    @FindBy (css="#nav > ol > li.level0.nav-3.parent > a")
    WebElement homeBUTTON;

    @FindBy(xpath = "//*[@id=\"nav\"]/ol/li[3]/ul/li[2]/a")
    WebElement bookMusic;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[3]/ul/li[2]/div/div[2]/a")
    WebElement viewDetalisButton;

    @FindBy(css = "#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button")
    WebElement addToCart;

    @FindBy(id = "links_21")
    WebElement linkCheckBox;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[1]/div/div[2]/ul/li[4]")
    WebElement myOrderLink;

    @FindBy(xpath = "//*[@id=\"header-account\"]/div/ul/li[1]/a")
    WebElement myAccount;

    @FindAll(
            @FindBy(xpath = "//*[@id=\"my-orders-table\"]/tbody/tr")

    )
    List<WebElement>OrderList;

    @FindBy(xpath = "//*[@id=\"my-orders-table\"]")
    WebElement Table;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[1]/div/div[2]/ul/li[12]/a")
    WebElement downloadable;

    @FindAll(
            @FindBy(xpath = "//*[@id=\"my-downloadable-products-table\"]/tbody/tr")

    )
    List<WebElement>downloadableOrderList;

    @FindBy(xpath = "//*[@id=\"my-downloadable-products-table\"]/tbody")
    WebElement downloadableTable;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[1]/div/div[2]/ul/li[9]/a")
    WebElement myWishListLink;

    @FindBy(xpath = "//*[@id=\"item_178\"]/td[2]/h3/a")
    WebElement wishListList;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[1]/div/div[2]/ul/li[3]/a")
    WebElement adressBookLink;

    @FindBy(xpath = "//*[@class='my-account']")
    WebElement adreesBookView;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/ol/li[1]/p/a")
    WebElement changeAddressLink;

    @FindBy(xpath = "//*[@id=\"form-validate\"]/div[3]/button/span/span")
    WebElement saveAddressLink;

    @FindBy(xpath = "//*[@class=\"my-account\"]/ul/li/ul/li/span")
    WebElement updateSuccessMsg;

    @FindBy(xpath = "//*[@class='col-left sidebar col-left-first']/div/div[2]/ul/li[2]/a")
    WebElement accountInformationLink;

    @FindBy(xpath = "//*[@class='my-account']/div/h1")
    WebElement EditInformationText;

    @FindBy(xpath = "//*[@class='buttons-set']/button")
    WebElement EditInformationSaveButton;

    @FindBy(id = "current_password")
    WebElement confirmPassword;

    @FindBy(id = "change_password")
    WebElement changePasswordCheckBox;

    @FindBy(id = "password")
    WebElement newPasswordButton;

    @FindBy(id = "confirmation")
    WebElement newPasswordConfirmButton;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div[2]/div[2]/div/div[2]/div[2]/div/ul/li/ul/li/span")
    WebElement changePasswordSuccess;

    @FindBy(xpath = "//*[@class=\"block block-account\"]/div[2]/ul/li[7]/a")
    WebElement myProductReviwLink;

    @FindBy(xpath = "//*[@class=\"my-account\"]/div/h1")
    WebElement productContains;

    @FindBy(xpath = "//*[@class=\"block block-account\"]/div[2]/ul/li[11]/a")
    WebElement newsLetterLink;

    @FindBy(xpath = "//*[@class=\"my-account\"]/div/h1")
    WebElement newsletterContains;

    @FindBy(xpath = "//*[@class='my-account']/div/div/h1")
    WebElement viewWishList;

    @FindBy(xpath = "//*[@id=\"header\"]/div/a")
    WebElement magentoPage;






    public void addProduct(){
        Actions actions=new Actions(driver);
        //actions.moveToElement(SaleBUTTON).build().perform();
        actions.moveToElement(homeBUTTON).build().perform();
        utility.waitForElementPresent(bookMusic);
        bookMusic.click();
        utility.waitForElementPresent(viewDetalisButton);
        viewDetalisButton.click();
        utility.waitForElementPresent(linkCheckBox);
        linkCheckBox.click();
        utility.waitForElementPresent(addToCart);
        addToCart.click();


    }
    public void addProductSuccess(){
        utility.waitForElementPresent(cartPage.successMsg);
        if (cartPage.successMsg.isDisplayed())
            System.out.println("add product success");
    }

    public void viewOrders() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        utility.waitForElementPresent(checkOutPage.AccountLink);
        checkOutPage.AccountLink.click();
        utility.waitForElementPresent(myAccount);
        myAccount.click();
        utility.waitForElementPresent(myOrderLink);
        myOrderLink.click();
        utility.waitForElementPresent(Table);
        if (OrderList.size() > 1)
            System.out.println("view Success");



    }
    public void myDownloadable(){
        utility.waitForElementPresent(downloadable);
        downloadable.click();
        utility.waitForElementPresent(downloadableTable);
        if (downloadableOrderList.size() > 1)
            System.out.println("downloadable View Success");
    }



    public void viewWishList(){
        utility.waitForElementPresent(myWishListLink);
        myWishListLink.click();
        utility.waitForElementPresent(wishListList);
        wishListList.isDisplayed();
    }

    public void viewWishListSuccess(){
        utility.waitForElementPresent(viewWishList);
        viewWishList.isDisplayed();
    }

    public  Boolean viewAdressBook(){
        utility.waitForElementPresent(adressBookLink);
        adressBookLink.click();
        utility.waitForElementPresent(adreesBookView);
        return adreesBookView.isDisplayed();
    }

    public void Update(){
        utility.waitForElementPresent(changeAddressLink);
        changeAddressLink.click();
        utility.waitForElementPresent(createAnAccount.firstName);
        createAnAccount.firstName.clear();
        System.out.println();
        createAnAccount.firstName.sendKeys(utility.FakeString());
        utility.waitForElementPresent(saveAddressLink);
        saveAddressLink.click();

    }
    public void updateSuccess(){
        utility.waitForElementPresent(updateSuccessMsg);
        updateSuccessMsg.isDisplayed();
        //System.out.println(updateSuccessMsg.getText());
    }

    public void editInformationView(){
        utility.waitForElementPresent(accountInformationLink);
        accountInformationLink.click();
        utility.waitForElementPresent(EditInformationText);
        EditInformationText.isDisplayed();
        System.out.println(EditInformationText.getText());
        utility.waitForElementPresent(createAnAccount.lastName);
        createAnAccount.lastName.clear();
        createAnAccount.lastName.sendKeys(utility.FakeString());
        utility.waitForElementPresent(confirmPassword);
        confirmPassword.sendKeys(createAnAccount.Password);
        utility.waitForElementPresent(EditInformationSaveButton);
        EditInformationSaveButton.click();
    }

    public void changePassword(){
        utility.waitForElementPresent(accountInformationLink);
        accountInformationLink.click();
        utility.waitForElementPresent(confirmPassword);
        confirmPassword.sendKeys(createAnAccount.Password);
        utility.waitForElementPresent(changePasswordCheckBox);
        changePasswordCheckBox.click();
        utility.waitForElementPresent(newPasswordButton);
        newPasswordButton.sendKeys(createAnAccount.Password);
        utility.waitForElementPresent(newPasswordConfirmButton);
        newPasswordConfirmButton.sendKeys(createAnAccount.Password);
        utility.waitForElementPresent(EditInformationSaveButton);
        EditInformationSaveButton.click();
        utility.waitForElementPresent(changePasswordSuccess);
        changePasswordSuccess.isDisplayed();
        System.out.println(changePasswordSuccess.getText());
    }
    public void viewMyProduct(){
        utility.waitForElementPresent(myProductReviwLink);
        myProductReviwLink.click();
        utility.waitForElementPresent(productContains);
        productContains.isDisplayed();
        System.out.println(productContains.getText());
    }

    public void viewNewsLetter(){
        utility.waitForElementPresent(newsLetterLink);
        newsLetterLink.click();
        utility.waitForElementPresent(newsletterContains);
        newsletterContains.isDisplayed();
        System.out.println(newsletterContains.getText());
    }
    public void userOnMagentoPage(){
        utility.waitForElementPresent(magentoPage);
        magentoPage.isDisplayed();
    }



}

