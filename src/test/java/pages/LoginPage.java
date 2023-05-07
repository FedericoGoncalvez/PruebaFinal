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



    public String getErrorText(){
        return errorMsg.getText();
    }
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

    public boolean isPresent() {
        try {
            logout.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


}