package scripts;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;

import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest{
    @Parameters({"email","password","title", "name"})

    @Test
    public void test(String email, String password, String title, String name){


        driver.get("http://magento-demo.lexiconn.com/");

        MainPage home = new MainPage(driver);
        LoginPage loginPage = home.enterLoginPage();
        MyAccountPage myAccountPage = loginPage.enterMyAccount(email,password);

        String getTitle = myAccountPage.getTextToDashboard();
        String userName = myAccountPage.getName();
        assertEquals(getTitle, title);
        assertEquals(userName,name);



    }

}