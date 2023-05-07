package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguagePage extends BasePage {

    public LanguagePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "select-language")
    private WebElement languageDropbox;
    @FindBy(xpath = "//option[contains(text(), 'French')]")
    private WebElement frenchLanguageOption;

    @FindBy(xpath="//label[text()='Votre Langue:']")
    private WebElement labelLangue;

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
