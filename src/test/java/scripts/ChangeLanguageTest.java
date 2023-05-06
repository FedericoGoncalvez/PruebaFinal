package scripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.Assert.assertEquals;
public class ChangeLanguageTest extends BaseTest{
    @Parameters({"language","text"})

    @Test
    public void Test(String language, String text){

        driver.get("http://magento-demo.lexiconn.com/");

        MainPage home = new MainPage(driver);
        home.changeLanguage();
        home.selectLanguage(language);
        String pageLanguage = home.getElementText();
        assertEquals(text,
                pageLanguage.toLowerCase());
    }

}

