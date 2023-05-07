package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@class='level0 has-children' and text()='Accessories']")
    private WebElement accessoriesLink;
    @FindBy(xpath = "//span[contains(text(), 'Eyewear')]")
    private WebElement eyewearLink;
    @FindBy(xpath = "//button[@title='Add to Cart']")
    private WebElement addToCartButton;

    @Step("Se clikea en el elemento del catalogo")
    public void selectCatalog(){
        accessoriesLink.click();
    }

    @Step("Se clikea en el elemento del item")
    public void selectItems(){
        eyewearLink.click();
    }

    @Step("Se agrega al carrito")
    public void clickAddToCartButton() {
        addToCartButton.click();
        new CartPage(driver);
    }

}
