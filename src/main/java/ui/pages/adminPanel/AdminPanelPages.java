package ui.pages.adminPanel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class AdminPanelPages extends BasePage {
    @FindBy(xpath = "//button[@class=\"ant-btn css-iuyn2o ant-btn-default sc-eqUzNf vkuEH\"]")
    public WebElement btnRegistrationNP;
    @FindBy(xpath = "//button[@class='ant-btn css-iuyn2o ant-btn-default sc-eqUzNf cmXNAZ mr-20']")
    public WebElement btnRegistrationExistingNP;

    public AdminPanelPages clickRegistrationNP() {
        webElementHelper.click(btnRegistrationNP);
        return this;
    }

    public AdminPanelPages clickRegistrationExistingNP() {
        webElementHelper.click(btnRegistrationExistingNP);
        return this;
    }
}
