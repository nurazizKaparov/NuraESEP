package UI.registrationNpTest;

import UI.AllPages;
import UI.BaseTest;
import lombok.extern.java.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import ui.drivers.Driver;

import static org.testng.Assert.assertEquals;
import static ui.dataProvider.ConfigReader.getProperty;

public class RegistrationKkmTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(RegistrationNp2Test.class);

    @Test(description = "Открытие страницы информации о НП", groups = "test1")
    void clickOpenInfoNpTest() {
        allPages = new AllPages();
        allPages.initPage();
        driver = Driver.getDriver();

        allPages.adminPanelPages.clickOpenInfoNP();
        String innNP = driver.findElement(By.xpath("//input[@id=\"tin\"]")).getAttribute("value");
        assertEquals(innNP, getProperty("innForRegistrationNP"));
        log.info("Пользователь находится на странице Инфорамация НП");
    }

    @Test(description = "Нажатие на кнопку Регистрация ККМ")
    void clickRegistrationKkmTest() {

        allPages.infoNpPage.clickBntRegistrationKKM();
        assertEquals(driver.findElement(By.xpath("//h2[@class='subtitle-18-bold']")).getText(), "Регистрация кассы");
        log.info("Пользователь находится на странице Регистрации ККМ");
    }

    @Test(description = "Заполнение всех полей на странице регистрации ККМ")
    void selectAllFieldsTest() throws InterruptedException {

        allPages.registrationKkmPage.selectAllFields();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(Keys.ENTER).perform();
        allPages.registrationKkmPage.selectAllFields2();
        allPages.registrationKkmPage.selectSerialNumberOfPost();
        allPages.registrationKkmPage.selectPhoneNumber();
        log.info("Поля в регистрации ККМ заполнены");
    }

    @Test(description = "Сохранение данных ККМ")
    void saveKkmTest() throws InterruptedException {

        allPages.registrationKkmPage.clickSaveKkm();
        assertEquals(driver.findElement(By.xpath("//span[text()='Редактировать']")).getText(), "Редактировать");
        log.info("Регистрация ККМ прошла успешно");
    }
}
