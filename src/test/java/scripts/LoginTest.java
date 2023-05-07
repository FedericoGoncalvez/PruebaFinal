package scripts;


import dataProviders.userData;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.AccountPage;

import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest{
    @Test(dataProvider = "userData", dataProviderClass = userData.class)
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

}