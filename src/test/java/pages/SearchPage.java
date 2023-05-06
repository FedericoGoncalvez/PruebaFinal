package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class SearchPage extends MainPage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "note-msg")
    private WebElement searchResult;

    public String getText() {
        return searchResult.getText();
    }
}
