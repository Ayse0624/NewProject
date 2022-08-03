package cucumberframework;

import frondenduser.BasePage;
import frondenduser.LoginWithAccount;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class multipleLogin extends BasePage {
    LoginWithAccount loginWithAccount;
    private String userName;
    private String password;

    @When("enter {string}{string}on the filed")
    public void enterOnTheFiled(String arg0, String arg1) {
        loginWithAccount=new LoginWithAccount(driver);
        userName=arg0;
        password=arg1;
        loginWithAccount.multipleLogin(userName,password);
    }

    @Then("login success")
    public void loginSuccess() {
    }
}
