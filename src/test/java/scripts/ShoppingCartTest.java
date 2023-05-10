package scripts;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.CartPage;
import pages.ProductPage;


import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ShoppingCartTest {
    public static WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception{

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://magento-demo.lexiconn.com/");

    }
    @Parameters({"textExpected"})

    @Test(description = "[CP-Cart-01] Add item to cart test")
    public void Test(String textExpected){


        ProductPage productPage = new ProductPage(driver);
        productPage.selectCatalog();
        productPage.selectItems();
        productPage.clickAddToCartButton();
        CartPage cartPage = new CartPage(driver);
        String productAdd = cartPage.getTextFromElement();
        assertEquals(productAdd, textExpected);
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
