package scripts;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LanguagePage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
public class ChangeLanguageTest {
    public static WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception{

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://magento-demo.lexiconn.com/");
    }
    @Parameters({"language","text"})
    @Test(description = "[CP-ChangeLanguage-01] Change Languague test")
    public void Test(String language, String text){

        LanguagePage languagePage = new LanguagePage(driver);
        languagePage.changeLanguage();
        languagePage.selectLanguage(language);
        String newLanguage = languagePage.getElementText();
        assertEquals(text, newLanguage.toLowerCase());
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

