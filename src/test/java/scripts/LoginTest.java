package scripts;


import dataProviders.userData;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AccountPage;

import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest{
    @Test(dataProvider = "userData", dataProviderClass = userData.class)
    public void test(String email, String password, String title){


        driver.get("http://magento-demo.lexiconn.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.accountClick();
        loginPage.loginClick();

        AccountPage accountPage = loginPage.enterMyAccount(email,password);
        if(loginPage.isPresent()){
        String getTitle = accountPage.getTextToDashboard();
        assertEquals(getTitle, title);
        loginPage.accountClick();
        accountPage.logoutClick();
        }
        else{
            String getError = loginPage.getErrorText();
            assertEquals(getError, title);
        }




    }

}