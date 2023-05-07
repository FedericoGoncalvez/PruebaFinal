package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[title='Search']")
    private WebElement searchButton;
    @FindBy(id="search")
    private WebElement searchInput;
    @FindBy(className = "note-msg")
    private WebElement searchResult;

    public String getText() {
        return searchResult.getText();
    }

    public void setSearch(String text) {
        searchInput.sendKeys(text);
        searchButton.click();
    }

}
