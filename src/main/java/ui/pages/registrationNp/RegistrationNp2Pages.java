package ui.pages.registrationNp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class RegistrationNp2Pages extends BasePage {
    @FindBy(id = "phone")
    public WebElement fieldNumberPhone;
    @FindBy(xpath = "//span[text()='СНО']")
    public WebElement fieldCHO;
    @FindBy(xpath = "//div[text()='Налог на деятельность в сфере электронной торговли']")
    public WebElement selectCHO;
    @FindBy(xpath = "//div[@class=\"ant-picker-input\"]")
    public WebElement fieldDate;
    @FindBy(xpath = "//td[@title='2024-08-01']")
    public WebElement btnFirstDateInCalendar;
    @FindBy(xpath = "//a[@class='ant-picker-today-btn']")
    public WebElement btnToday;
    @FindBy(xpath = "(//span[@class=\"color-primary-brand pointer\"])[1]")
    public WebElement btnDownloadFile;
    @FindBy(xpath = "(//span[@class=\"color-primary-brand pointer\"])[2]")
    public WebElement btnDownloadFileInRuKg;
    @FindBy(xpath = "//span[text()='Сохранить']")
    public WebElement btnSave;
    @FindBy(xpath = "//span[text()='На главную']")
    public WebElement btnMoveToAdminPanel;

    public RegistrationNp2Pages inputNumberPhone() {
        webElementHelper
                .click(fieldNumberPhone)
                .sendKeys(fieldNumberPhone, "555111222");
        return this;
    }

    public RegistrationNp2Pages clickCHO() {
        webElementHelper
                .click(fieldCHO);
        return this;
    }

    public RegistrationNp2Pages inputCHO() {
        webElementHelper
                .click(selectCHO);
        return this;
    }

    public RegistrationNp2Pages inputFirstDateInCalendar() throws InterruptedException {
        webElementHelper
                .click(fieldDate)
                .click(btnFirstDateInCalendar);
        Thread.sleep(3000);
        return this;
    }

    public void inputTodayDate() {
        webElementHelper
                .click(fieldDate)
                .click(btnToday);
    }

    public RegistrationNp2Pages downloadFile() {
        webElementHelper
                .click(btnDownloadFile);
        return this;
    }

    public RegistrationNp2Pages downloadFileInRuKg() {
        webElementHelper
                .click(btnDownloadFileInRuKg);
        return this;
    }

    public RegistrationNp2Pages clickBtnSave() {
        webElementHelper
                .click(btnSave);
        return this;
    }

    public RegistrationNp2Pages clickBtnMoveToAdminPanel() {
        webElementHelper
                .click(btnMoveToAdminPanel);
        return this;
    }
}

