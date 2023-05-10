package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
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

    }
    @Parameters({"language","text"})

    @Test(description = "[CP-ChangeLanguage-01] Change Languague test")
    public void Test(String language, String text){

        driver.get("http://magento-demo.lexiconn.com/");

        LanguagePage languagePage = new LanguagePage(driver);
        languagePage.changeLanguage();
        languagePage.selectLanguage(language);
        String pageLanguage = languagePage.getElementText();
        assertEquals(text,
                pageLanguage.toLowerCase());
    }

}

