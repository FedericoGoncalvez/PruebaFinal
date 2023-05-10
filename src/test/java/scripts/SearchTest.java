package scripts;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SearchTest {
    public static WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception{

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Parameters({"textSearch", "textResult"})

    @Test(description = "[CP-Search-01] Search item test")
    public void Test(String textSearch, String textResult){

        driver.get("http://magento-demo.lexiconn.com/");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.setSearch(textSearch);
        String result = searchPage.getText();
        assertEquals(result, textResult);
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
