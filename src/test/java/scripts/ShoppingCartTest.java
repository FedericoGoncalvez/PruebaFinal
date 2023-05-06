package scripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;


import static org.testng.Assert.assertEquals;

public class ShoppingCartTest extends BaseTest{
    @Parameters({"textExpected"})

    @Test
    public void Test(String textExpected){

        driver.get("http://magento-demo.lexiconn.com/");

        ProductPage productPage = new ProductPage(driver);
        productPage.selectCatalog();
        productPage.selectItems();
        productPage.clickAddToCartButton();
        CartPage cartPage = new CartPage(driver);
        String productAdd = cartPage.getTextFromElement();
        assertEquals(productAdd, textExpected);
    }
}
