package cucumberframework;

import frondenduser.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.ReadFromFiles;

public class Hooks extends BasePage {
    String url= ReadFromFiles.readConfigProperties("magentoLoginUrl");

    @Before
    public void setUp() {
        setUpBrowser(url);
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}