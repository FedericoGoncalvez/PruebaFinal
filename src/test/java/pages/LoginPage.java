package pages;

//import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='label' and text()='Account']")
    WebElement accountButton;

    @FindBy(css = "[title='Log In']")
    WebElement loginButton;

    //@Step("Se ingresa a la página de Login.")
    public AccountLoginPage enterLoginPage(){
        accountButton.click();
        loginButton.click();
        return new AccountLoginPage(driver);
    }
}