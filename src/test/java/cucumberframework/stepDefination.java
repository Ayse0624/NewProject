package cucumberframework;

import frondenduser.BasePage;
import frondenduser.LoginWithAccount;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import loginPage.DashboardPage;
import utility.ReadFromFiles;



public class stepDefination extends BasePage {
    LoginWithAccount loginWithAccount;
    DashboardPage dashboardPage;
    static String url= ReadFromFiles.readConfigProperties("magentoLoginUrl");
    private String username;
    private String password;

    @Given("user already on the dashboard page")
    public void user_already_on_the_dashboard_page() {

    }

    @When("click login icon")
    public void click_login_icon() {
        loginWithAccount=new LoginWithAccount(driver);
        loginWithAccount.LoginFunction();
    }

    @Then("successfully")
    public void successfully() {
        System.out.println("success login");
        
    }
    @When("enter wrong username and password")
    public void enter_wrong_username_and_password() {
        loginWithAccount.LoginForInvalid("25642");
    }
    @Then("user can not be login Wrong Masage is displayed")
    public void user_can_not_be_login_Wrong_Masage_is_displayed(){
        loginWithAccount.verifyInvalid();
    }

    @When("user already login")
    public void user_already_login() {
        dashboardPage=new DashboardPage(driver);
        loginWithAccount.LoginFunction();

    }





}
