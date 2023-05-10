package pages;

import io.qameta.allure.Step;
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

    @FindBy(xpath = "//option[contains(text(), 'English')]")
    private WebElement englishLanguageOption;
    @FindBy(xpath = "//option[contains(text(), 'German')]")
    private WebElement germanLanguageOption;
    @FindBy(xpath="//label[text()='Votre Langue:']")
    private WebElement labelLangue;



    @Step("Se hace clic en lenguages.")
    public void changeLanguage(){
        languageDropbox.click();
    }


    @Step("Se selecciona el idioma .")
    public void selectLanguage(String language) {
        switch (language) {
            case "French":
                frenchLanguageOption.click();
                break;
            case "English":
                englishLanguageOption.click();
                break;
            case "German":
                germanLanguageOption.click();
                break;
            default:
                englishLanguageOption.click();
        }
    }

    @Step("Se verifica el lenguaje.")
    public String getElementText() {
        return labelLangue.getText();
    }


}
