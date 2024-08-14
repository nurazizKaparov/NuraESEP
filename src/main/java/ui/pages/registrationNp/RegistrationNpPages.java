package ui.pages.registrationNp;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.helpers.FakeDataHelper;
import ui.helpers.WebElementHelper;
import ui.pages.BasePage;

import static ui.dataProvider.ConfigReader.*;


public class RegistrationNpPages extends BasePage {
    @FindBy(xpath = "//input[@id='tin']")
    public WebElement fieldINN;
    @FindBy(id = "login")
    public WebElement fieldMail;
    @FindBy(id = "firstName")
    public WebElement fieldFirstName;
    @FindBy(id = "lastName")
    public WebElement fieldLastName;
    @FindBy(id = "middleName")
    public WebElement fieldMiddleName;
    @FindBy(id = "password")
    public WebElement fieldPassword;
    @FindBy(xpath = "//*[text()='Да']")
    public WebElement btnPayerNDS_yes;
    @FindBy(xpath = "//*[text()='Нет']")
    public WebElement btnPayerNDS_no;
    @FindBy(xpath = "//span[text()='Далее']")
    public WebElement btnNext;

    public RegistrationNpPages inputFieldsAndClickNext() {
        webElementHelper
                .sendKeys(fieldINN, getProperty("innForRegistrationNP"))
                .sendKeys(fieldMail, fakeDataHelper.getRandomMail())
                .sendKeys(fieldFirstName, fakeDataHelper.getRandomFirstName())
                .sendKeys(fieldLastName, fakeDataHelper.getRandomLastName())
                .sendKeys(fieldMiddleName, fakeDataHelper.getRandomMiddleName())
                .sendKeys(fieldPassword, "Password123!")
//                .scrollToElement(btnPayerNDS_no).click(btnPayerNDS_no)
                .scrollToElement(btnNext).click(btnNext);
        return this;
    }


}
