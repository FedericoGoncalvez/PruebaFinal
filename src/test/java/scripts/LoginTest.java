package scripts;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountLoginPage;
import pages.LoginPage;
import pages.MyAccountPage;

import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest{

    @Parameters({"emailAccount","passAccount"})

    @Test
    public void test(String emailAccount, String passAccount){

        driver.get("http://magento-demo.lexiconn.com/");
        LoginPage loginPage = new LoginPage(driver);
        AccountLoginPage accountLoginPage = loginPage.enterLoginPage();
        MyAccountPage myAccountPage = accountLoginPage.enterMyAccount(emailAccount,passAccount);
        String getTitle = myAccountPage.assertLoginPage();
        String title = myAccountPage.titlePage();
        assertEquals(title,getTitle);
        myAccountPage.returnHomePage();


    }

}