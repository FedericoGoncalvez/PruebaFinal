package scripts;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.RegisterPage;

import java.util.concurrent.TimeUnit;

public class RegisterTest {

    public static WebDriver driver;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://magento-demo.lexiconn.com/");
    }

    @Parameters({"name","lastname","email","password", "confirm"})

    @Test(description = "[CP-Register-01] Register with empty field test")
    public void test(String name, String lastname, String email, String password, String confirm){



        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.accountClick();
        registerPage.registerClick();

        registerPage.register(name, lastname, email,password, confirm);
        String actualAdvice = registerPage.assertAdvice();
        String expectedAdvice = "This is a required field.";
        Assert.assertEquals(actualAdvice, expectedAdvice);

    }

    @Attachment(type = "image/png")
    @AfterMethod(alwaysRun = true)
    public byte[] takeScreenshot() {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            byte[] image = screenshot.getScreenshotAs(OutputType.BYTES);
            System.out.println("Successfully captured a screenshot");
            return image;
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
