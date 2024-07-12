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
import static org.testng.AssertJUnit.assertEquals;

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
        driver.manage().window().maximize();
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

    @Test(description = "Тест для проверки авторизации с некорректным паролем")
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

    @Test(description = "Тест для проверки авторизации с некорректным ИНН")
    public void testInnWithInvalidCredentials() {
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

            loginInnField.sendKeys("22405200000946");
            passwordField.sendKeys("Linux7788.");
            clickBtn.click();

            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Неправильный логин или пароль.']")));
            assertNotNull(errorMessage);
            log.info("Сообщение об ошибке авторизации отображается");

            String expectedErrorText = "Неправильный логин или пароль.";
            String actualErrorText = errorMessage.getText();
            assertTrue(actualErrorText.contains(expectedErrorText), "Неправильный логин или пароль.");
        } catch (Exception e) {
            log.error("Вышла ошибка во время теста: " + e.getMessage());
            throw e;
        }
    }

    @Test(description = "Тест для проверки входа с пустыми учетными данными")
    public void testWithInvalidCredentials() {
        try {
            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
            assertNotNull(loginInnField);
            log.info("Обязательное поле для заполнения");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
            assertNotNull(passwordField);
            log.info("Обязательное поле для заполнения");

            WebElement clickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100']")));
            assertNotNull(clickBtn);
            log.info("Кнопка входа в систему");

            loginInnField.sendKeys("");
            passwordField.sendKeys("");
            clickBtn.click();

            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Поле является обязательным к заполнению']")));
            assertNotNull(errorMessage);
            log.info("Поля не заполнены");

            String expectedErrorText = "Поле является обязательным к заполнению";
            String actualErrorText = errorMessage.getText();
            assertTrue(actualErrorText.contains(expectedErrorText), "Поле является обязательным к заполнению");
        } catch (Exception e) {
            log.error("Ошибка во время теста: " + e.getMessage());
            throw e;
        }
    }

    @Test(description = "Тест для проверки авторизации с длинным паролем")
    public void testLongPassword() {
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
            passwordField.sendKeys("Linux77880834250872346587235");
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

    @Test(description = "Проверка входа с пробелами в начале и конце ИНН пользователя")
    public void testLoginWithSpace() {
        try {
            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
            assertNotNull(loginInnField);
            log.info("Поле Логина найдено");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
            assertNotNull(passwordField);
            log.info("Поле ввода пароля найдено");

            WebElement clickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100']")));
            assertNotNull(clickBtn);
            log.info("Кнопка успешно нажата");

            loginInnField.sendKeys(" 2240520000946716 ");
            passwordField.sendKeys("Linux7788.");
            clickBtn.click();

            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Неправильный логин или пароль.']")));
            assertNotNull(errorMessage);
            log.info("Сообщение об ошибке авторизации отображается");

            String expectedErrorText = "Неправильный логин или пароль."; // Убедитесь, что это правильный текст ошибки
            String actualErrorText = errorMessage.getText();
            assertTrue(actualErrorText.contains(expectedErrorText), "Неправильный логин или пароль.");
        } catch (Exception e) {
            log.error("Ошибка: " + e.getMessage());
        }
    }

    @Test(description = "Проверка входа с пробелами в начале и конце пароля пользователя")
    public void testPasswordWithSpace() {
        try {
            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
            assertNotNull(loginInnField);
            log.info("Поле Логина найдено");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
            assertNotNull(passwordField);
            log.info("Поле ввода пароля найдено");

            WebElement clickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100']")));
            assertNotNull(clickBtn);
            log.info("Кнопка успешно нажата");

            loginInnField.sendKeys("2240520000946716");
            passwordField.sendKeys(" Linux7788. ");
            clickBtn.click();

            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Неправильный логин или пароль.']")));
            assertNotNull(errorMessage);
            log.info("Сообщение об ошибке авторизации отображается");

            String expectedErrorText = "Неправильный логин или пароль."; // Убедитесь, что это правильный текст ошибки
            String actualErrorText = errorMessage.getText();
            assertTrue(actualErrorText.contains(expectedErrorText), "Неправильный логин или пароль.");
        } catch (Exception e) {
            log.error("Ошибка: " + e.getMessage());
        }
    }

    @Test(description = "Проверка входа с действительным именем пользователя и пустым полем пароля")
    public void testLoginWithEmptyPassword() {
        try {
            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
            assertNotNull(loginInnField);
            log.info("Поле логина найдено");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
            assertNotNull(passwordField);
            log.info("Поле ввода пароля найдено");

            WebElement clickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100']")));
            assertNotNull(clickBtn);
            log.info("Кнопка успешно нажата");

            loginInnField.sendKeys("22405200000946716");
            passwordField.sendKeys("");
            clickBtn.click();

            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Поле является обязательным к заполнению']")));
            assertNotNull(errorMessage);
            log.info("Сообщение об ошибке авторизации отображается");

            String expectedErrorText = "Поле является обязательным к заполнению";
            String actualErrorText = errorMessage.getText();
            assertTrue(actualErrorText.contains(expectedErrorText), "Сообщение об ошибке не отображается правильно.");
        } catch (Exception e) {
            log.error("Ошибка: " + e.getMessage());
            throw e;
        }
    }

    @Test(description = "Проверка сохранения имени пользователя и пароля при нажатии кнопки Запомнить меня")
    public void testLoginWithRememberMe() {
        try {
            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
            assertNotNull(loginInnField);
            log.info("Поле логина найдено");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
            assertNotNull(passwordField);
            log.info("Поле ввода пароля найдено");

            WebElement rememberMeCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("RememberMe")));
            assertNotNull(rememberMeCheckbox);
            log.info("Чекбокс 'Запомнить меня' найден");

            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100']")));
            assertNotNull(loginButton);
            log.info("Кнопка входа найдена");

            // Ввод данных
            String username = "22405200000946716";
            String password = "Linux7788.";
            loginInnField.sendKeys(username);
            passwordField.sendKeys(password);
            rememberMeCheckbox.click();
            loginButton.click();

            // Закрываем браузер
            driver.quit();

            // Открываем браузер снова
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Увеличьте время ожидания
            driver.get("https://testcabinet.salyk.kg/account/login"); // Замените на реальный URL страницы

            // Проверка, что поля заполнены
            loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
            passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
            assertEquals(loginInnField.getAttribute("value"), username, "Имя пользователя не сохранилось");
            assertEquals(passwordField.getAttribute("value"), password, "Пароль не сохранился");

            log.info("Имя пользователя и пароль успешно сохранены при нажатии кнопки 'Запомнить меня'");
        } catch (Exception e) {
            log.error("Ошибка: " + e.getMessage());
            throw e;
        }
    }

    @Test(description = "")
    public void testWithForgotPassword(){
//a[text()='Забыли пароль?']
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
