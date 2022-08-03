import frondenduser.BasePage;
import frondenduser.LoginWithAccount;
import loginPage.CheckOutPage;
import loginPage.DashboardPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.ReadFromFiles;
import utility.TestUtility;


    public class UserStoreRunner extends BasePage {

        static LoginWithAccount loginWithAccount;
        static String url= ReadFromFiles.readConfigProperties("magentoLoginUrl");
        static DashboardPage dashboardPage;
        static TestUtility utility;
        static CheckOutPage checkOutPage;

        @BeforeClass(alwaysRun = true)
        public static void SetBrowser(){
            setUpBrowser(url);
            loginWithAccount=new LoginWithAccount(driver);
            dashboardPage=new DashboardPage(driver);
            utility=new TestUtility(driver);
            checkOutPage=new CheckOutPage(driver);
        }

        @Test(priority = 1)
        public static void login(){
            loginWithAccount.LoginFunction();
        }

        @Test(priority = 2)
        public static void addProduct(){
            dashboardPage.addProduct();
            dashboardPage.addProductSuccess();

        }

        @Test(priority = 3)
        public static void checkOut(){
            checkOutPage.checkOut();
            checkOutPage.checkOutSuccessMessege();
        }

        @Test(priority = 4)
        public static void viewOrder(){
            dashboardPage.viewOrders();
        }

        @Test(priority = 5)
        public static void myDownloadableOrder(){
            dashboardPage.myDownloadable();
        }

        @Test(priority = 6)
        public static void myWishList(){
            dashboardPage.viewWishList();
        }
        @Test(priority = 7)
        public static void viewAndUpdateAddressBook(){
            dashboardPage.viewAdressBook();
            dashboardPage.Update();
        }
        @Test(priority = 8)
        public static void ViewAndEditInformation(){
            dashboardPage.editInformationView();
        }
        @Test(priority = 9)
        public static void ChangePassword(){
            dashboardPage.changePassword();
        }
        @Test(priority = 10)
        public static void myProductReviewAndContains(){
            dashboardPage.viewMyProduct();
        }
        @Test(priority = 11)
        public static void newsLetterViewAndContains(){
            dashboardPage.viewNewsLetter();
        }







    }


