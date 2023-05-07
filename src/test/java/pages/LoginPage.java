package pages;

//import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[contains(text(), 'Invalid login or password.')]")
    private WebElement errorMsg;
    @FindBy(xpath = "//a[@title='Log Out']")
    private WebElement logout;
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



    //@Step("Se verifica el mensaje de error.")
    public String getErrorText(){
        return errorMsg.getText();
    }
    //@Step("Se hace clic en el boton account.")
    public void accountClick(){
        account.click();
    }
    //@Step("Se hace clic en login.")
    public void loginClick(){
        login.click();
    }
    //@Step("Se hace el ingreso a la pagina.")
    public AccountPage enterAccount(String emailAccount, String passAccount){
        emailInput.sendKeys(emailAccount);
        passwordInput.sendKeys(passAccount);
        loginButton.click();
        return new AccountPage(driver);
    }

    //@Step("Se verifica si un elemento existe.")
    public boolean isPresent() {
        try {
            logout.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}