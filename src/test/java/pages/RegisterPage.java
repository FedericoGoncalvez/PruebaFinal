package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[@class='label' and text()='Account']")
    private WebElement account;
    @FindBy(css = "[title='Register']")
    private WebElement register;
    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameInput;
    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@id='confirmation']")
    private WebElement confirmPasswordInput;
    @FindBy(xpath = "//button[@title='Register']")
    private WebElement registerButton;
    @FindBy(id = "advice-required-entry-email_address")
    private WebElement advice;
    //@Step("Se hace clic en el botón de account.")
    public void accountClick(){
        account.click();
    }
    //@Step("Se hace clic en registrarse.")
    public void registerClick(){
        register.click();
    }
    //@Step("Se llenan los campos de registrar.")
    public void register(String name, String lastname,
                                  String email, String password,
                                  String confirmpassword){

        firstNameInput.sendKeys(name);
        lastNameInput.sendKeys(lastname);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmpassword);

        registerButton.click();

    }
    //@Step("Se retorna el mensaje de alerta del campo.")
    public String assertAdvice(){
        return advice.getText();
    }




}


