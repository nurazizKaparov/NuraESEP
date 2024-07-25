package ui.pages.registrationNp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class RegistrationNpPages2 extends BasePage {
    @FindBy(xpath = "//button[@class='ant-btn css-iuyn2o ant-btn-default sc-eqUzNf gKhIfv']")
    public WebElement btnSave;

    public RegistrationNpPages2 clickBtnSave(){
        webElementHelper.click(btnSave);
        return this;
    }
}

