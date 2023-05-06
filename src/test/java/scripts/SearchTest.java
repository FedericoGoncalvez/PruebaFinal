package scripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;

import static org.testng.Assert.assertEquals;

public class SearchTest extends BaseTest{

    @Parameters({"text"})

    @Test
    public void Test(String text){

        driver.get("http://magento-demo.lexiconn.com/");

        MainPage home = new MainPage(driver);
        home.setSearch(text);
        /*home.selectLanguage(language);
        String pageLanguage = home.getElementText();
        assertEquals(text,
                pageLanguage.toLowerCase());
    */}
}
