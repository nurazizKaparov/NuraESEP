package ui.pages.registrationKKM;

import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import org.checkerframework.framework.qual.FieldInvariant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;
import ui.pages.registrationNp.RegistrationNp2Pages;

public class RegistrationKkmPage extends BasePage {
    @FindBy(xpath = "//input[@id='entrepreneurshipObjectCode']")
    public WebElement fieldEntrepreneurshipObject;
    @FindBy(xpath = "//div[@class='ant-select-item ant-select-item-option' and @title='Павильон/Контейнер/Киоск (с площадью более до 50 кв.м.)']")
    public WebElement btnSelectEntrepreneurshipObject;
    @FindBy(xpath = "//input[@id='businessActivityCode']")
    public WebElement fieldBusinessActivity;
    @FindBy(xpath = "//div[@class='ant-select-item ant-select-item-option' and @title='Розничная торговля авиабилетами']")
    public WebElement btnSelectBusinessActivity;
    @FindBy(xpath = "//div[@class='ant-select-selection-overflow']")
    public WebElement fieldCalculationItemAttribute;
    @FindBy(xpath = "//div[@class='ant-select-item-option-content'] //div[text()='Товар']")
    public WebElement btnSelectCalculationItemAttributeProduct;
    @FindBy(xpath = "//div[@class='ant-select-item-option-content'] //div[text()='Услуги или работы']")
    public WebElement btnCalculationItemAttributeServiceOrWork;
    @FindBy(xpath = "//input[@id=\"taxAuthorityDepartmentCode\"]")
    public WebElement fieldUGNS;
    @FindBy(xpath = "//div[@class='ant-select-item-option-content'] //div[text()='г. Каракол']")
    public WebElement btnSelectUGNS;
    @FindBy(xpath = "//label[@for='taxAuthorityDepartmentCode']")
    public WebElement textUGNS;
    @FindBy(xpath = "//input[@id='address_name']")
    public WebElement fieldAddressNameCompany;
    @FindBy(xpath = "//input[@id=\"address_salesPointType\"]")
    public WebElement fieldAddressSalesPoint;
    @FindBy(xpath = "//div[@class='ant-select-item-option-content' and text()='Выездная торговля']")
    public WebElement btnSelectAddressSalesPoint;
    @FindBy(xpath = "//input[@id='address_regionCode']")
    public WebElement fieldRegion;
    @FindBy(xpath = "//div[@class='ant-select-item-option-content'] //div[text()='Иссык-Кульская область']")
    public WebElement btnSelectRegion;
    @FindBy(xpath = "//input[@id='address_locality']")
    public WebElement fieldCity;
    @FindBy(xpath = "//input[@id='address_postalCode']")
    public WebElement fieldIndex;
    @FindBy(xpath = "//input[@id='address_street']")
    public WebElement fieldStreet;
    @FindBy(xpath = "//input[@id='address_houseNumber']")
    public WebElement fieldHouseNumber;
    @FindBy(xpath = "//input[@id='address_latitude']")
    public WebElement fieldLatitude;
    @FindBy(xpath = "//input[@id='address_longitude']")
    public WebElement fieldLongitude;
    @FindBy(xpath = "//input[@id='serialNumberOfPos']")
    public WebElement fieldSerialNumberOfPost;
    @FindBy(xpath = "//span[text()='Пробить кассу с этим серийным номером']")
    public WebElement btnUseCurrentSerialNumber;
    @FindBy(xpath = "//input[@id='simCardNumber']")
    public WebElement fieldPhoneNumber;
    @FindBy(xpath = "//span[text()='Сохранить']")
    public WebElement btnSaveKKM;
    @FindBy(xpath = "//span[text()='Закрыть']")
    public WebElement bntClosePop_apSuccessfullySaved;

    protected WebDriver driver;

    public RegistrationKkmPage selectAllFields() throws InterruptedException {
        webElementHelper
                .click(fieldEntrepreneurshipObject)
                .click(btnSelectEntrepreneurshipObject)
                .click(fieldBusinessActivity)
                .click(btnSelectBusinessActivity)
                .click(fieldCalculationItemAttribute)
                .click(btnSelectCalculationItemAttributeProduct)
                .click(btnCalculationItemAttributeServiceOrWork)
                .click(textUGNS)
                .sendKeys(fieldUGNS, "Кара")
                .scrollToElement(btnSelectUGNS)
                .click(btnSelectUGNS)
                .sendKeys(fieldAddressNameCompany, "Ак-Тилек 2");
        return this;
    }

    public RegistrationKkmPage selectAllFields2() {
        webElementHelper
                .click(btnSelectAddressSalesPoint)
                .click(fieldRegion)
                .click(btnSelectRegion)
                .sendKeys(fieldCity, "Каракол")
                .sendKeys(fieldIndex, "72500")
                .sendKeys(fieldStreet, "Абдрахманова")
                .sendKeys(fieldHouseNumber, "99")
                .sendKeys(fieldLatitude, "42,492456")
                .sendKeys(fieldLongitude, "78,393317");
        return this;
    }

    public RegistrationKkmPage selectSerialNumberOfPost() {
        webElementHelper
                .sendKeys(fieldSerialNumberOfPost, "2222222222222222")
                .click(btnUseCurrentSerialNumber);
        return this;
    }

    public RegistrationKkmPage selectPhoneNumber() {
        webElementHelper
                .click(fieldPhoneNumber)
                .sendKeys(fieldPhoneNumber, "555111999");
        return this;
    }

    public RegistrationKkmPage clickSaveKkm() throws InterruptedException {
        webElementHelper
                .click(btnSaveKKM);
        Thread.sleep(3000);
        webElementHelper
                .click(bntClosePop_apSuccessfullySaved);
        return this;
    }

}

