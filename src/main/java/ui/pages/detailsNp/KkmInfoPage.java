package ui.pages.detailsNp;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class KkmInfoPage extends BasePage {
    @FindBy(xpath = "//div[@class=\"ant-dropdown-trigger\"]")
    WebElement btnDropdown;
    @FindBy(xpath = "//span[@title='История кассы']")
    WebElement btnKkmHistory;
    @FindBy(xpath = "//span[@title='Подробнее']")
    WebElement btnDetailsInfoKkm;
    @FindBy(xpath = "//span[text()='Редактировать']")
    WebElement btnEditKkm;
    @FindBy(xpath = "//span[text()='Скачать']")
    WebElement btnDownloadContract;

    public KkmInfoPage clickBtnDownloadContract(){
        webElementHelper.click(btnDownloadContract);
        return this;
    }
}

