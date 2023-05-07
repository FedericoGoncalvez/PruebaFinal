package scripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LanguagePage;

import static org.testng.Assert.assertEquals;
public class ChangeLanguageTest extends BaseTest{
    @Parameters({"language","text"})

    @Test
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

