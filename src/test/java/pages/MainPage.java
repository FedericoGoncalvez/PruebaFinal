package pages;

//import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "select-language")
    private WebElement languageDropbox;
    @FindBy(xpath = "//option[contains(text(), 'French')]")
    private WebElement frenchLanguageOption;

    @FindBy(xpath="//label[text()='Votre Langue:']")
    private WebElement labelLangue;

    @FindBy(xpath = "//span[@class='label' and text()='Account']")
    private WebElement accountButton;

    @FindBy(css = "[title='Log In']")
    private WebElement loginButton;

    @FindBy(css = "[title='Register']")
    WebElement registerButton;

    //@Step("Se ingresa a la página de Login.")
    public LoginPage enterLoginPage(){
        accountButton.click();
        loginButton.click();
        return new LoginPage(driver);
    }
    //@Step("Se ingresa a la página de Registro.")
    public RegisterPage enterRegisterPage(){
        accountButton.click();
        registerButton.click();
        return new RegisterPage(driver);
    }

    public void changeLanguage(){
        languageDropbox.click();
    }

    public void selectLanguage(String language) {
        if (language.equals("French")) {
            frenchLanguageOption.click();
        }
    }
    public String getElementText() {
        return labelLangue.getText();
    }
}