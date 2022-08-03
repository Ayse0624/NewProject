package utility;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestUtility {

    WebDriver driver;
    private int timeOut=Integer.parseInt(ReadFromFiles.readConfigProperties("timeout"));

    public TestUtility(WebDriver driver) {
        this.driver = driver;
    }
    public void sleep(int seconds){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForElementPresent(WebElement element) {
        WebDriverWait wait=new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForAlertPresent(){
        WebDriverWait wait=new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public String FakeString(){
        Faker faker=new Faker();
        return faker.name().name();
    }
    public String randomEmail(){
        String random= RandomStringUtils.randomAlphabetic(4);
        return random+"@gmail.com";
    }




}

