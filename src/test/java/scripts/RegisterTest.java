package scripts;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest{

    @Parameters({"name","lastname","email","password", "confirm"})

    @Test
    public void test(String name, String lastname, String email, String password, String confirm){


        driver.get("http://magento-demo.lexiconn.com/");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.accountClick();
        registerPage.registerClick();

        registerPage.register(name, lastname, email,password, confirm);
        String actualAdvice = registerPage.assertAdvice();
        String expectedAdvice = "This is a required field.";
        Assert.assertEquals(actualAdvice, expectedAdvice);

    }
}
