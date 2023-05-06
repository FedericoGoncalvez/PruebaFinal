package pages;

//import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class MyAccountPage extends MainPage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(tagName = "h1")
    private WebElement dashboardTitle;
    @FindBy(className = "hello")
    private WebElement loginName;


    //@Step("Se obtiene el título para realizar el assert.")
    public String getTextToDashboard(){
        return dashboardTitle.getText();
    }
    public String getName() {
        return loginName.getText();
    }

}
