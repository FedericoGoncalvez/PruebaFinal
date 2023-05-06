package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

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

    public String assertAdvice(){
        String getAdvice= advice.getText();
        return getAdvice;
    }
}


