package scripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SearchPage;

import static org.testng.Assert.assertEquals;

public class SearchTest extends BaseTest{

    @Parameters({"textSearch", "textResult"})

    @Test(description = "[CP-Search-01] Search item test")
    public void Test(String textSearch, String textResult){

        driver.get("http://magento-demo.lexiconn.com/");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.setSearch(textSearch);
        String result = searchPage.getText();
        assertEquals(result, textResult);
    }
}
