import frondenduser.BasePage;
import loginPage.CreateMultipleAccount;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.ReadFromFiles;
import utility.TestUtility;

public class CreateMultipleAccountRunnerClass extends BasePage {
    static CreateMultipleAccount createMultipleAnAccount;
    static TestUtility Utility;
    static String url= ReadFromFiles.readConfigProperties("magentoUrl");
    static String password=ReadFromFiles.readConfigProperties("password");

    @BeforeClass(alwaysRun = true)
    public static void setBrowser(){
        //setUpBrowser(url);
        createMultipleAnAccount=new CreateMultipleAccount(driver);
        Utility=new TestUtility(driver);
    }
    @Test(dataProvider = "MultipleUsers")
    public static void createNewAccount(String FirstName,String LastName,String EmailAddress,String password){
        setUpBrowser(url);
        CreateMultipleAccount createMultipleAccount=new CreateMultipleAccount(driver);
        createMultipleAccount.createMultipleAccountEnter(FirstName,LastName,EmailAddress,password);
        createMultipleAccount.succesCreateMassage();
        String text= driver.getTitle();
        System.out.println(text);

    }
    @DataProvider
    public Object[][] MultipleUsers(){
        Object[][]usersData=new Object[][]{
                {Utility.FakeString(),Utility.FakeString(),Utility.randomEmail(),password},
                {Utility.FakeString(),Utility.FakeString(),Utility.randomEmail(),password},
                {Utility.FakeString(),Utility.FakeString(),Utility.randomEmail(),password},
        };
        return usersData;
    }
}

