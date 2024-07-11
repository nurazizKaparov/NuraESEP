package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class LoginPageTest {

    private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {
        // Укажите путь к вашему драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
    }

    @BeforeMethod
    public void setUpMethod() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Увеличьте время ожидания
        driver.get("https://testcabinet.salyk.kg/account/login"); // Замените на реальный URL страницы
    }

    @Test(description = "Позитивный тест для авторизации")
    public void testLogin() {
        try {
            // Используем WebDriverWait для ожидания появления элементов
            WebElement loginField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username"))); // Найдено по имени поля
            assertNotNull(loginField);
            log.info("ИНН заполнен");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password"))); // Найдено по имени поля
            assertNotNull(passwordField);
            log.info("Пароль прописан");

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary w-100']"))); // Найдено по тексту кнопки
            assertNotNull(loginButton);
            log.info("Кнопка авторизации успешно нажата");

            loginField.sendKeys("22405200000946716");
            passwordField.sendKeys("Linux7788.");
            loginButton.click();

            // Проверьте результат на наличие текста "22405200000946"
            WebElement bodyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-gray-600 fs-6 fw-semibold']")));
            String bodyText = bodyElement.getText();
            assertTrue(bodyText.contains("22405200000946"), "Expected text not found!");

            // Проверьте результат, например, что страница после входа содержит ожидаемый элемент
            WebElement expectedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-gray-600 fs-6 fw-semibold']"))); // Замените на реальный ID ожидаемого элемента
            assertNotNull(expectedElement);
            log.info("Клиент успешно вошел в систему");
        } catch (Exception e) {
            // Логирование ошибки
            System.out.println("Ошибка во время выполнения теста: " + e.getMessage());
            throw e;
        }
    }

    @Test(description = "Негативный тест для авторизации с паролем")
    public void testPasswordWithInvalidCredentials() {
        try {
            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
            assertNotNull(loginInnField);
            log.info("Обязательное поле ИНН");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
            assertNotNull(passwordField);
            log.info("Обязательное поле пароля");

            WebElement clickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100']")));
            assertNotNull(clickBtn);
            log.info("Кнопка входа в систему");

            loginInnField.sendKeys("22405200000946716");
            passwordField.sendKeys("Linux7788");
            clickBtn.click();

            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Неправильный логин или пароль.']")));
            assertNotNull(errorMessage);
            log.info("Сообщение об ошибке авторизации отображается");

            String expectedErrorText = "Неправильный логин или пароль."; // Убедитесь, что это правильный текст ошибки
            String actualErrorText = errorMessage.getText();
            assertTrue(actualErrorText.contains(expectedErrorText), "Неправильный логин или пароль.");
        } catch (Exception e) {
            log.error("Вышла ошибка во время теста: " + e.getMessage());
            throw e;
        }
    }

    @Test(description = "Негативный тест авторизации с ИНН")
    public void testInnWithInvalidCredentials(){
        try{
            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
            assertNotNull(loginInnField);
            log.info("Обязательное поле ИНН");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
            assertNotNull(passwordField);
            log.info("Обязательное поле пароля");

            WebElement clickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100']")));
            assertNotNull(clickBtn);
            log.info("Кнопка входа в систему");

            loginInnField.sendKeys("22405200000946716");
            passwordField.sendKeys("Linux7788");
            clickBtn.click();

            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Неправильный логин или пароль.']")));
            assertNotNull(errorMessage);
            log.info("Сообщение об ошибке авторизации отображается");

            String expectedErrorText = "Неправильный логин или пароль.";
            String actualErrorText = errorMessage.getText();
            assertTrue(actualErrorText.contains(expectedErrorText), "Неправильный логин или пароль.");
        }
        catch (Exception e){
            log.error("Вышла ошибка во время теста: " + e.getMessage());
            throw e;
        }
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }

    @AfterClass
    public void tearDownClass() {
        // Любые действия, которые нужно выполнить после завершения всех тестов
    }
}
