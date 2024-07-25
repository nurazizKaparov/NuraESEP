package ui.pages.registrationNp;

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
    @FindBy(xpath = "//button[@class='ant-btn css-iuyn2o ant-btn-default sc-eqUzNf beGnDj sc-NxrBK fQdrPg w-half']")
    public WebElement btnPayerNDS_yes;
    @FindBy(xpath = "//button[@class='ant-btn css-iuyn2o ant-btn-default sc-eqUzNf fEfnaF sc-cfxfQh etJKSv w-half']")
    public WebElement btnPayerNDS_no;
    @FindBy(xpath = "//button[@class='ant-btn css-iuyn2o ant-btn-default sc-eqUzNf gKhIfv']")
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
