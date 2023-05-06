package scripts;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountLoginPage;
import pages.MainPage;
import pages.MyAccountPage;

import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest{
    @Parameters({"email","password"})

    @Test
    public void test(String email, String password){


        driver.get("http://magento-demo.lexiconn.com/");
        MainPage loginPage = new MainPage(driver);
        AccountLoginPage accountLoginPage = loginPage.enterLoginPage();
        MyAccountPage myAccountPage = accountLoginPage.enterMyAccount(email,password);
        String getTitle = myAccountPage.assertLoginPage();
        String title = myAccountPage.titlePage();
        assertEquals(title,getTitle);
        myAccountPage.returnHomePage();


    }

}