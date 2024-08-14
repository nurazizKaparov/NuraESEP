package ui.pages.adminPanel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class AdminPanelPages extends BasePage {
    @FindBy(xpath = "//span[text()='Зарегистрировать НП']")
    public WebElement btnRegistrationNP;
    @FindBy(xpath = "//span[text()='Добавить существующего НП']")
    public WebElement btnRegistrationExistingNP;
    @FindBy(xpath = "(//div[@title='Подробнее'])[1]")
    public WebElement btnOpenInfoNP;


    public AdminPanelPages clickRegistrationNP() {
        webElementHelper.click(btnRegistrationNP);
        return this;
    }

    public AdminPanelPages clickRegistrationExistingNP() {
        webElementHelper.click(btnRegistrationExistingNP);
        return this;
    }

    public AdminPanelPages clickOpenInfoNP(){
        webElementHelper.click(btnOpenInfoNP);
        return this;
    }
}
