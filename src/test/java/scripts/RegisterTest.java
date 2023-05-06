package scripts;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.RegisterPage;

import static org.testng.Assert.assertEquals;

public class RegisterTest extends BaseTest{

    @Parameters({"name","lastname","email","password", "confirm"})

    @Test
    public void test(String name, String lastname, String email, String password, String confirm){


        driver.get("http://magento-demo.lexiconn.com/");
        MainPage home = new MainPage(driver);
        RegisterPage registerPage = home.enterRegisterPage();
        registerPage.register(name, lastname, email,password, confirm);
        String actualAdvice = registerPage.assertAdvice();
        String expectedAdvice = "This is a required field.";
        Assert.assertEquals(actualAdvice, expectedAdvice);

    }
}
