package pages;

//import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "button[title='Search']")
    private WebElement searchButton;
    @FindBy(id="search")
    private WebElement searchInput;
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

    public void setSearch(String text) {
        searchInput.sendKeys(text);
        searchButton.click();
    }


}