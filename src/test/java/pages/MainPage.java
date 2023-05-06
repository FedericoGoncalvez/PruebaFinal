package pages;

//import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='label' and text()='Account']")
    WebElement accountButton;

    @FindBy(css = "[title='Log In']")
    WebElement loginButton;

    //@Step("Se ingresa a la página de Login.")
    public LoginPage enterLoginPage(){
        accountButton.click();
        loginButton.click();
        return new LoginPage(driver);
    }
}