package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Log Out']")
    private WebElement logout;

    @FindBy(className = "hello")
    private WebElement loginName;



    @Step("Se extrae la bienvenida.")
    public String getTextToDashboard(){
        return loginName.getText();
    }
    @Step("Se hace Logout.")
    public void logoutClick(){
        logout.click();
    }
}
