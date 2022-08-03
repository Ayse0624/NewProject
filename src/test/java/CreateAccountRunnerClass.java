import frondenduser.BasePage;
import loginPage.CreateAnAccount;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.ReadFromFiles;
import utility.TestUtility;

public class CreateAccountRunnerClass extends BasePage {

    static CreateAnAccount createAnAccount;
    static TestUtility utility;
     static String url=ReadFromFiles.readConfigProperties("config.properties","magentoUrl");

    @BeforeClass(alwaysRun = true)
    public static void setBrowser(){
        setUpBrowser(url);
        createAnAccount=new CreateAnAccount(driver);
        utility=new TestUtility(driver);
    }
    @Test
    public void createNewAccount(){
        createAnAccount.createAnAccountEnter();
        createAnAccount.succesCreateMassage();

    }
//
}