package scripts;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountLoginPage;
import pages.LoginPage;
import pages.MyAccountPage;

import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest{
    @Parameters({"email","password"})

    @Test
    public void test(String email, String password){

        String site = "http://magento-demo.lexiconn.com/";
        driver.get(site);
        LoginPage loginPage = new LoginPage(driver);
        AccountLoginPage accountLoginPage = loginPage.enterLoginPage();
        /*MyAccountPage myAccountPage = accountLoginPage.enterMyAccount(email,password);
        String getTitle = myAccountPage.assertLoginPage();
        String title = myAccountPage.titlePage();
        assertEquals(title,getTitle);
        myAccountPage.returnHomePage();*/


    }

}