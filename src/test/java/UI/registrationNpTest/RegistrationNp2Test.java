package UI.registrationNpTest;

import UI.AllPages;
import UI.BaseTest;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import ui.drivers.Driver;
import ui.pages.registrationKKM.RegistrationKkmPage;
import ui.pages.registrationNp.RegistrationNp2Pages;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DecimalStyle;
import java.util.HashMap;
import java.util.Map;

import static ui.dataProvider.ConfigReader.getProperty;

public class RegistrationNp2Test extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(RegistrationNp2Test.class);


    // ------------------------------------------------------
//    private static final Logger log = LoggerFactory.getLogger(RegistrationNpTest.class);

    @Test(description = "Нажатие на кнопку зарегестрировать НП", groups = "test1")
    void clickRegistrationNpTest() {
        try {
            allPages.adminPanelPages.clickRegistrationNP();
            String massageRegistrationNP = driver.findElement(By.xpath("//h2[@class='subtitle-18-bold']")).getText();
            assertEquals(massageRegistrationNP, "Регистрация НП");
            log.info("Пользователь находится на первой шаге Регистрации НП");
        } catch (Exception e) {
            log.error("Вышла ошибка по причине:" + e.getMessage());
        }
    }


    @Test(description = "Заполнение полей и нажатие на кнопку Далее", groups = "test1")
    void inputFieldsAndClickNextTest() {
        try {
            allPages.registrationNpPages.inputFieldsAndClickNext();
            String innNp = driver.findElement(By.xpath("//input[@id='tin']")).getAttribute("value");
            assertEquals(innNp, getProperty("innForRegistrationNP"));
            log.info("Пользователь находится на втором шаге Регистрации НП");
        } catch (Exception e) {
            log.error("Ошибка на втором шаге вышла про причине:" + e.getMessage());
        }
    }
    //---------------------------------------------

    @Test(description = "Заполнение полей и даты подписания", groups = "test1")
    void inputFieldAndDateTest() throws InterruptedException {
        try {
            allPages.registrationNp2Pages.inputNumberPhone();
            log.info("Номер заполнен!");

            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.TAB).perform();
            actions.sendKeys(Keys.ENTER).perform();
            allPages.registrationNp2Pages.inputCHO();

            allPages.registrationNp2Pages.inputFirstDateInCalendar();
            String firstDateInCalendar = driver.findElement(By.id("contractDate")).getAttribute("value");
            assertEquals(firstDateInCalendar, "01.08.2024");
            log.info("Дата первого числа введена удачно");
            allPages.registrationNp2Pages.inputTodayDate();
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            String formattedDateToday = today.format(formatter);
            String todayDateInCalendar = driver.findElement(By.id("contractDate")).getAttribute("value");
            assertEquals(todayDateInCalendar, formattedDateToday);
            log.info("Указанно " + formattedDateToday + " дата");
//            allPages.registrationNp2Pages.clickCHO();
//            log.info("CHO выбран");
//            allPages.registrationNp2Pages.inputCHO();
//            log.info("Выбран СНО");
        } catch (Exception e) {
            log.error("Заполнение полей и даты во втором шаге выдала ошибку:" + e);
        }
    }


    @Test(description = "Скачивание фала", groups = "test1")
    void downloadFileTest() throws InterruptedException {
        String downloadFilePath = "\"C:\\Users\\nkaparov\\Documents\\Файлы из авто\"";
        allPages.registrationNp2Pages.downloadFile();
        Thread.sleep(2000);
        File file = new File(downloadFilePath + "Контракт " + getProperty("innForRegistrationNP") + ".docx");
        if (file.exists()) {
            log.info("Файл успешно скачан!");
        } else {
            log.error("Не удалось найти файл в папке!");
        }
    }

    @Test(description = "Скачивание файла на Кг,Ру", groups = "test1")
    void downloadFileInKgRuTest() throws InterruptedException {
        String downloadFilePath = "\"C:\\Users\\nkaparov\\Documents\\Файлы из авто\"";
        allPages.registrationNp2Pages.downloadFileInRuKg();
        Thread.sleep(2000);
        File file = new File(downloadFilePath + "Контракт" + getProperty("innForRegistrationNP"));
        if (file.exists()) {
            log.info("Файл на РУ и КГ успешно скачан!");
        } else {
            log.error("Не удалось найти файл на РУ и КГ в папке!");
        }
    }

    @Test(description = "Сохранение данных при регистрации НП", groups = "test1")
    void clickBtnSaveTest() {
        try {
            allPages.registrationNp2Pages.clickBtnSave();
            String textCompletedSave = driver.findElement(By.xpath("//p[@class='mt-24 mb-24']")).getText();
            assertEquals(textCompletedSave, "Успешно добавлено");
            allPages.registrationNp2Pages.clickBtnMoveToAdminPanel();
            WebElement inn = driver.findElement(By.xpath("(//td[@class='ant-table-cell'][2])[1]"));
            assertEquals(getProperty("innForRegistrationNP"), inn.getText());
            log.info("СОЗДАНИЕ НП ПРОШЛО УСПЕШНО!!!");
        } catch (Exception e) {
            log.error("Пользотель не на главной странице Админ Панель");
        }
    }

    @Test(description = "Открытие страницы информации о НП", groups = "test1")
    void clickOpenInfoNpTest() {
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
    }

    @Test(description = "Сохранение данных ККМ")
    void saveKkmTest() {
        allPages.registrationKkmPage.clickSaveKkm();
        assertEquals(driver.findElement(By.xpath("//span[text()='Редактировать']")).getText(), "Редактировать");
        log.info("Регистрация ККМ прошла успешно");
    }

    @Test(description = "Скачка файла с инфрмацией ККМ")
    void downloadFileInfoKkm(){
        allPages.kkmInfoPage.clickBtnDownloadContract();

    }
}