package pages;

//import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='label' and text()='Account']")
    private WebElement account;

    @FindBy(css = "[title='Log In']")
    private WebElement login;
    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(id = "send2")
    private WebElement loginButton;


    public void accountClick(){
        account.click();
    }
    public void loginClick(){
        login.click();
    }

    //@Step("Se ingresan los datos del Login.")
    public AccountPage enterMyAccount(String emailAccount, String passAccount){
        emailInput.sendKeys(emailAccount);
        passwordInput.sendKeys(passAccount);
        loginButton.click();
        return new AccountPage(driver);
    }

}