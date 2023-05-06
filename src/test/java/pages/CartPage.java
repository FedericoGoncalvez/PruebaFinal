package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends MainPage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "success-msg")
    private WebElement successMessage;

    public String getTextFromElement(){
        return successMessage.getText();
    }
}
