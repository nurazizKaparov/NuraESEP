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

    public AllPages allPages;

    @Test(description = "Заполнение полей и даты подписания", groups = "test1", dependsOnMethods = "inputFieldsAndClickNextTest")
    void inputFieldAndDateTest() throws InterruptedException {
        allPages = new AllPages();
        allPages.initPage();
        driver = Driver.getDriver();

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

    }


    @Test(description = "Скачивание фала", groups = "test1")
    void downloadFileTest() throws InterruptedException {
        try {
            String downloadFilePath = "\"C:\\Users\\nkaparov\\Documents\\Файлы из авто\"";
            allPages.registrationNp2Pages.downloadFile();
            Thread.sleep(2000);
            File file = new File(downloadFilePath + "Контракт " + getProperty("innForRegistrationNP") + ".docx");
            if (file.exists()) {
                log.info("Файл успешно скачан!");
            } else {
                log.error("Не удалось найти файл в папке!");
            }
        } catch (Exception e) {
            log.error("ОШИБКА: " + e);
        }
    }

    @Test(description = "Скачивание файла на Кг,Ру", groups = "test1")
    void downloadFileInKgRuTest() throws InterruptedException {
        try {
            String downloadFilePath = "\"C:\\Users\\nkaparov\\Documents\\Файлы из авто\"";
            allPages.registrationNp2Pages.downloadFileInRuKg();
            Thread.sleep(2000);
            File file = new File(downloadFilePath + "Контракт" + getProperty("innForRegistrationNP"));
            if (file.exists()) {
                log.info("Файл на РУ и КГ успешно скачан!");
            } else {
                log.error("Не удалось найти файл на РУ и КГ в папке!");
            }
        } catch (Exception e) {
            log.error("ОШИБКА " + e);
        }
    }

    @Test(description = "Сохранение данных при регистрации НП", groups = "test1")
    void clickBtnSaveTest() {

        allPages.registrationNp2Pages.clickBtnSave();
        String textCompletedSave = driver.findElement(By.xpath("//p[@class='mt-24 mb-24']")).getText();
        assertEquals(textCompletedSave, "Успешно добавлено");
        allPages.registrationNp2Pages.clickBtnMoveToAdminPanel();
        WebElement inn = driver.findElement(By.xpath("(//td[@class='ant-table-cell'][2])[1]"));
        assertEquals(getProperty("innForRegistrationNP"), inn.getText());
        log.info("СОЗДАНИЕ НП ПРОШЛО УСПЕШНО!!!");
    }
}