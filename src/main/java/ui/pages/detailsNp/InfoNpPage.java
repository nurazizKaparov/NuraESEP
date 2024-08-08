package ui.pages.detailsNp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class InfoNpPage extends BasePage {
    @FindBy(xpath = "//span[text()='Регистрация кассы']")
    WebElement btnRegistrationKKM;
    @FindBy(xpath = "//div[text()='ККМ']")
    WebElement btnKkmPage;

    public InfoNpPage clickBntRegistrationKKM(){
        webElementHelper
                .click(btnRegistrationKKM);
        return this;
    }

    public InfoNpPage clickKkmPage(){
        webElementHelper
                .click(btnKkmPage);
        return this;
    }
}
