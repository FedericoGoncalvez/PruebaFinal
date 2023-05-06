package pages;

//import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement emailForm;

    @FindBy(id = "pass")
    WebElement passwordForm;

    @FindBy(id = "send2")
    WebElement loginButton;

    //@Step("Se ingresan los datos del Login.")
    public MyAccountPage enterMyAccount(String emailAccount, String passAccount){
        emailForm.sendKeys(emailAccount);
        passwordForm.sendKeys(passAccount);
        loginButton.click();
        return new MyAccountPage(driver);
    }


}