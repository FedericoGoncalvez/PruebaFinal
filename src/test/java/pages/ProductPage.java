package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends MainPage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='level0 has-children' and text()='Accessories']")
    private WebElement accessoriesLink;


    @FindBy(xpath = "//span[contains(text(), 'Eyewear')]")
    private WebElement eyewearLink;

    @FindBy(xpath = "//button[@title='Add to Cart']")
    private WebElement addToCartButton;

    public void selectCatalog(){
        accessoriesLink.click();
    }
    public void selectItems(){
        eyewearLink.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
        new CartPage(driver);
    }

}
