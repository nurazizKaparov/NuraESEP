package UI;

import org.example.drivers.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class LoginOfEsi {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://testcabinet.salyk.kg/account/login");
    }

    @Test(description = "Тест для регистрации через ЕСИ")
    public void testLoginEsi(){
        try{
            WebElement buttonEsiField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='ЕСИ-Облако']")));
            assertNotNull(buttonEsiField);
            buttonEsiField.click();
            System.out.println("Переход выполнен");

            WebElement langBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='РУС']")));
            assertNotNull(langBtn);
            langBtn.click();

            WebElement headerText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h5")));
            assertNotNull(headerText);
            System.out.println("Текст найден");

            WebElement loginEsiField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("InputModel.UserName")));
            assertNotNull(loginEsiField);
            System.out.println("Поле найдено");

            loginEsiField.sendKeys("22405200000946");
            loginEsiField.click();
            System.out.println("ИНН введен");

            WebElement nextButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-btn-form")));
            assertNotNull(nextButton);
            nextButton.click();
            System.out.println("Нужно ввести пароль");

            // Проверяем, что сообщение о не регистрации в ЕСИ отображается
            WebElement markerText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='Вы не зарегистрировались в ЕСИ']")));
            assertNotNull(markerText);
            System.out.println("Сообщение о не регистрации в ЕСИ отображается");

            // Проверяем текст сообщения
            String expectedText = "Вы не зарегистрировались в ЕСИ";
            String actualText = markerText.getText();
            System.out.println("Текст сообщения: " + actualText);
            assertTrue(actualText.equals(expectedText), "Сообщение о не регистрации в ЕСИ не соответствует ожидаемому");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            throw e;
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
