package scripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.SearchPage;

import static org.testng.Assert.assertEquals;

public class SearchTest extends BaseTest{

    @Parameters({"textSearch", "textResult"})

    @Test
    public void Test(String textSearch, String textResult){

        driver.get("http://magento-demo.lexiconn.com/");

        MainPage home = new MainPage(driver);
        home.setSearch(textSearch);
        SearchPage searchPage = new SearchPage(driver);
        String result = searchPage.getText();
        assertEquals(result, textResult);
    }
}
