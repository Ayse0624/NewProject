package cucumberframework;

import frondenduser.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import loginPage.DashboardPage;

public class userStoreStepDefination extends BasePage {
    DashboardPage dashboardPage;


    @Given("user already on the magento page")
    public void user_already_on_the_magento_page() {
        dashboardPage=new DashboardPage(driver);
    }

    @When("enter my wishlist link")
    public void enter_my_wishlist_link() {
        dashboardPage.viewWishList();
    }

    @Then("user should be see wishlist")
    public void user_should_be_see_wishlist() {
        dashboardPage.viewWishListSuccess();
    }
    @When("enter address book link view and update")
    public void enter_address_book_link_view_and_update() {
        dashboardPage.viewAdressBook();
        dashboardPage.Update();
    }

    @Then("user update successfully")
    public void user_update_successfully() {
        dashboardPage.updateSuccess();

    }


}
