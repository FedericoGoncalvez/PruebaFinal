package scripts;


import dataProviders.userData;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class LoginTest{

    public static WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception{

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test(dataProvider = "userData", dataProviderClass = userData.class, description = "[CP-Login-01] Login Test")

    public void test(String email, String password, String expectedText){


        driver.get("http://magento-demo.lexiconn.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.accountClick();
        loginPage.loginClick();

        AccountPage accountPage = loginPage.enterAccount(email,password);
        if(loginPage.isPresent()){
            String getTitle = accountPage.getTextToDashboard();
            assertEquals(getTitle, expectedText);
            loginPage.accountClick();
            accountPage.logoutClick();
            }
        else{
            String getError = loginPage.getErrorText();
            assertEquals(getError, expectedText);
        }

    }
    @Attachment(type = "image/png")
    @AfterMethod(alwaysRun = true)
    public byte[] takeScreenshot() throws Exception {
        byte[] image = new byte[0];
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            image = screenshot.getScreenshotAs(OutputType.BYTES);
            System.out.println("Successfully captured a screenshot");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
        return image;
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}