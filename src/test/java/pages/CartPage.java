package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "success-msg")
    private WebElement successMessage;

    //@Step("Se verifica el texto de bienvenida.")
    public String getTextFromElement(){
        return successMessage.getText();
    }
}
