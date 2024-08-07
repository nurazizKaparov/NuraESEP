//package UI;

import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

//public class LoginPageTest {
//
//    private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);
//    private WebDriver driver;
//    private WebDriverWait wait;
//
//    @BeforeClass
//    public void setUpClass() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
//    }
//
//    @BeforeMethod
//    public void setUpMethod() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        driver.get("https://testcabinet.salyk.kg/account/login");
//    }
//
//    @Test(description = "Позитивный тест для авторизации")
//    public void testLogin() {
//        try {
//            // Используем WebDriverWait для ожидания появления элементов
//            WebElement loginField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username"))); // Найдено по имени поля
//            assertNotNull(loginField);
//            log.info("ИНН заполнен");
//
//            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password"))); // Найдено по имени поля
//            assertNotNull(passwordField);
//            log.info("Пароль прописан");
//
//            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary w-100']"))); // Найдено по тексту кнопки
//            assertNotNull(loginButton);
//            log.info("Кнопка авторизации успешно нажата");
//
//            loginField.sendKeys("22405200000946716");
//            passwordField.sendKeys("Linux7788.");
//            loginButton.click();
//
//            // Проверьте результат на наличие текста "22405200000946"
//            WebElement bodyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-gray-600 fs-6 fw-semibold']")));
//            String bodyText = bodyElement.getText();
//            assertTrue(bodyText.contains("22405200000946"), "Expected text not found!");
//
//            // Проверьте результат, например, что страница после входа содержит ожидаемый элемент
//            WebElement expectedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-gray-600 fs-6 fw-semibold']")));
//            assertNotNull(expectedElement);
//            log.info("Клиент успешно вошел в систему");
//        } catch (Exception e) {
//            // Логирование ошибки
//            System.out.println("Ошибка во время выполнения теста: " + e.getMessage());
//            throw e;
//        }
//    }
//
//    @Test(description = "Тест для проверки авторизации с некорректным паролем")
//    public void testPasswordWithInvalidCredentials() {
//        try {
//            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
//            assertNotNull(loginInnField);
//            log.info("Обязательное поле ИНН");
//
//            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
//            assertNotNull(passwordField);
//            log.info("Обязательное поле пароля");
//
//            WebElement clickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100']")));
//            assertNotNull(clickBtn);
//            log.info("Кнопка входа в систему");
//
//            loginInnField.sendKeys("22405200000946716");
//            passwordField.sendKeys("Linux7788");
//            clickBtn.click();
//
//            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Неправильный логин или пароль.']")));
//            assertNotNull(errorMessage);
//            log.info("Сообщение об ошибке авторизации отображается");
//
//            String expectedErrorText = "Неправильный логин или пароль."; // Убедитесь, что это правильный текст ошибки
//            String actualErrorText = errorMessage.getText();
//            assertTrue(actualErrorText.contains(expectedErrorText), "Неправильный логин или пароль.");
//        } catch (Exception e) {
//            log.error("Вышла ошибка во время теста: " + e.getMessage());
//            throw e;
//        }
//    }
//
//    @Test(description = "Тест для проверки авторизации с некорректным ИНН")
//    public void testInnWithInvalidCredentials() {
//        try {
//            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
//            assertNotNull(loginInnField);
//            Thread.sleep(1000);
//            log.info("Обязательное поле ИНН");
//
//            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
//            assertNotNull(passwordField);
//            Thread.sleep(1000);
//            log.info("Обязательное поле пароля");
//
//            WebElement clickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100']")));
//            assertNotNull(clickBtn);
//            Thread.sleep(1000);
//            log.info("Кнопка входа в систему");
//
//            loginInnField.sendKeys("22405200000946123");
//            passwordField.sendKeys("Linux7788.");
//            clickBtn.click();
//            Thread.sleep(1000);
//
//            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Неправильный логин или пароль.']")));
//            assertNotNull(errorMessage);
//            Thread.sleep(1000);
//            log.info("Сообщение об ошибке авторизации отображается");
//
//            String expectedErrorText = "Неправильный логин или пароль.";
//            String actualErrorText = errorMessage.getText();
//            assertTrue(actualErrorText.contains(expectedErrorText), "Неправильный логин или пароль.");
//            Thread.sleep(1000);
//        } catch (Exception e) {
//            log.error("Вышла ошибка во время теста: " + e.getMessage());
//        }
//    }
//
//    @Test(description = "Тест для проверки входа с пустыми учетными данными")
//    public void testWithInvalidCredentials() {
//        try {
//            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
//            assertNotNull(loginInnField);
//            log.info("Обязательное поле для заполнения");
//
//            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
//            assertNotNull(passwordField);
//            log.info("Обязательное поле для заполнения");
//
//            WebElement clickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100']")));
//            assertNotNull(clickBtn);
//            log.info("Кнопка входа в систему");
//
//            loginInnField.sendKeys("");
//            passwordField.sendKeys("");
//            clickBtn.click();
//
//            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Поле является обязательным к заполнению']")));
//            assertNotNull(errorMessage);
//            log.info("Поля не заполнены");
//
//            String expectedErrorText = "Поле является обязательным к заполнению";
//            String actualErrorText = errorMessage.getText();
//            assertTrue(actualErrorText.contains(expectedErrorText), "Поле является обязательным к заполнению");
//        } catch (Exception e) {
//            log.error("Ошибка во время теста: " + e.getMessage());
//            throw e;
//        }
//    }
//
//    @Test(description = "Тест для проверки авторизации с длинным паролем")
//    public void testLongPassword() {
//        try {
//            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
//            assertNotNull(loginInnField);
//            log.info("Обязательное поле ИНН");
//
//            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
//            assertNotNull(passwordField);
//            log.info("Обязательное поле пароля");
//
//            WebElement clickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100']")));
//            assertNotNull(clickBtn);
//            log.info("Кнопка входа в систему");
//
//            loginInnField.sendKeys("22405200000946716");
//            passwordField.sendKeys("Linux77880834250872346587235");
//            clickBtn.click();
//
//            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Неправильный логин или пароль.']")));
//            assertNotNull(errorMessage);
//            log.info("Сообщение об ошибке авторизации отображается");
//
//            String expectedErrorText = "Неправильный логин или пароль."; // Убедитесь, что это правильный текст ошибки
//            String actualErrorText = errorMessage.getText();
//            assertTrue(actualErrorText.contains(expectedErrorText), "Неправильный логин или пароль.");
//        } catch (Exception e) {
//            log.error("Вышла ошибка во время теста: " + e.getMessage());
//            throw e;
//        }
//    }
//
//    @Test(description = "Проверка входа с пробелами в начале и конце ИНН пользователя")
//    public void testLoginWithSpace() {
//        try {
//            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
//            assertNotNull(loginInnField);
//            log.info("Поле Логина найдено");
//
//            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
//            assertNotNull(passwordField);
//            log.info("Поле ввода пароля найдено");
//
//            WebElement clickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100']")));
//            assertNotNull(clickBtn);
//            log.info("Кнопка успешно нажата");
//
//            loginInnField.sendKeys(" 2240520000946716 ");
//            passwordField.sendKeys("Linux7788.");
//            clickBtn.click();
//
//            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Неправильный логин или пароль.']")));
//            assertNotNull(errorMessage);
//            log.info("Сообщение об ошибке авторизации отображается");
//
//            String expectedErrorText = "Неправильный логин или пароль."; // Убедитесь, что это правильный текст ошибки
//            String actualErrorText = errorMessage.getText();
//            assertTrue(actualErrorText.contains(expectedErrorText), "Неправильный логин или пароль.");
//        } catch (Exception e) {
//            log.error("Ошибка: " + e.getMessage());
//        }
//    }
//
//    @Test(description = "Проверка входа с пробелами в начале и конце пароля пользователя")
//    public void testPasswordWithSpace() {
//        try {
//            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
//            assertNotNull(loginInnField);
//            log.info("Поле Логина найдено");
//
//            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
//            assertNotNull(passwordField);
//            log.info("Поле ввода пароля найдено");
//
//            WebElement clickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100']")));
//            assertNotNull(clickBtn);
//            log.info("Кнопка успешно нажата");
//
//            loginInnField.sendKeys("2240520000946716");
//            passwordField.sendKeys(" Linux7788. ");
//            clickBtn.click();
//
//            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Неправильный логин или пароль.']")));
//            assertNotNull(errorMessage);
//            log.info("Сообщение об ошибке авторизации отображается");
//
//            String expectedErrorText = "Неправильный логин или пароль."; // Убедитесь, что это правильный текст ошибки
//            String actualErrorText = errorMessage.getText();
//            assertTrue(actualErrorText.contains(expectedErrorText), "Неправильный логин или пароль.");
//        } catch (Exception e) {
//            log.error("Ошибка: " + e.getMessage());
//        }
//    }
//
//    @Test(description = "Проверка входа с действительным именем пользователя и пустым полем пароля")
//    public void testLoginWithEmptyPassword() {
//        try {
//            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
//            assertNotNull(loginInnField);
//            log.info("Поле логина найдено");
//
//            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
//            assertNotNull(passwordField);
//            log.info("Поле ввода пароля найдено");
//
//            WebElement clickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100']")));
//            assertNotNull(clickBtn);
//            log.info("Кнопка успешно нажата");
//
//            loginInnField.sendKeys("22405200000946716");
//            passwordField.sendKeys("");
//            clickBtn.click();
//
//            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Поле является обязательным к заполнению']")));
//            assertNotNull(errorMessage);
//            log.info("Сообщение об ошибке авторизации отображается");
//
//            String expectedErrorText = "Поле является обязательным к заполнению";
//            String actualErrorText = errorMessage.getText();
//            assertTrue(actualErrorText.contains(expectedErrorText), "Сообщение об ошибке не отображается правильно.");
//        } catch (Exception e) {
//            log.error("Ошибка: " + e.getMessage());
//            throw e;
//        }
//    }
//
//    //TODO: Нужно будет допилить
//    @Test(description = "Проверка сохранения имени пользователя и пароля при нажатии кнопки Запомнить меня")
//    public void testLoginWithRememberMe() {
//        try {
//            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
//            assertNotNull(loginInnField);
//            log.info("Поле логина найдено");
//
//            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
//            assertNotNull(passwordField);
//            log.info("Поле ввода пароля найдено");
//
//            WebElement rememberMeCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("RememberMe")));
//            assertNotNull(rememberMeCheckbox);
//            log.info("Чекбокс 'Запомнить меня' найден");
//
//            WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary w-100']")));
//            assertNotNull(loginButton);
//            log.info("Кнопка входа найдена");
//
//            // Ввод данных
//            String username = "22405200000946716";
//            String password = "Linux7788.";
//            loginInnField.sendKeys(username);
//            passwordField.sendKeys(password);
//            rememberMeCheckbox.click();
//            loginButton.click();
//
//            // Закрываем браузер
//            driver.quit();
//
//            // Открываем браузер снова
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Увеличьте время ожидания
//            driver.get("https://testcabinet.salyk.kg/account/login"); // Замените на реальный URL страницы
//
//            // Проверка, что поля заполнены
//            loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
//            passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
//            assertEquals(loginInnField.getAttribute("value"), username, "Имя пользователя не сохранилось");
//            assertEquals(passwordField.getAttribute("value"), password, "Пароль не сохранился");
//
//            log.info("Имя пользователя и пароль успешно сохранены при нажатии кнопки 'Запомнить меня'");
//        } catch (Exception e) {
//            log.error("Ошибка: " + e.getMessage());
//            throw e;
//        }
//    }
//
//
//    @Test(description = "Проверка сообщения об ошибке при несовпадении паролей")
//    public void testPasswordMismatchError() {
//        try {
//            WebElement forgotPasswordBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Забыли пароль?']")));
//            assertNotNull(forgotPasswordBtn);
//            forgotPasswordBtn.click();
//            log.info("Кнопка 'Забыли пароль?' успешно нажата");
//
//            WebElement resetPasswordTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Забыли пароль?']")));
//            assertNotNull(resetPasswordTitle);
//            log.info("Страница восстановления пароля открылась успешно.");
//
//            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
//            assertNotNull(loginInnField);
//            log.info("Поле ввода ИНН найдено.");
//
//            WebElement resetPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
//            assertNotNull(resetPasswordField);
//            log.info("Поле ввода нового пароля найдено.");
//
//            WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ConfirmPassword")));
//            assertNotNull(confirmPasswordField);
//            log.info("Поле повторного ввода пароля найдено.");
//
//            WebElement resetPasswordBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Сбросить']")));
//            assertNotNull(resetPasswordBtn);
//            log.info("Кнопка 'Сбросить' найдена.");
//
//            // Тестирование случая, когда пароли не совпадают
//            loginInnField.sendKeys("22905200300907523");
//            resetPasswordField.sendKeys("YameteKudasai");
//            confirmPasswordField.sendKeys("YameteKudasa"); // Несовпадающий пароль
//            resetPasswordBtn.click();
//
//            // Убедиться, что система отображает сообщение об ошибке "Пароли не совпадают"
//            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Пароли не совпадают']")));
//            assertNotNull(errorMessage);
//            log.info("Сообщение об ошибке 'Пароли не совпадают' отображается");
//
//            String expectedErrorText = "Пароли не совпадают"; // Убедитесь, что это правильный текст сообщения
//            String actualErrorText = errorMessage.getText();
//            assertTrue(actualErrorText.contains(expectedErrorText), "Сообщение об ошибке 'Пароли не совпадают' отображается правильно.");
//        } catch (Exception e) {
//            log.error("Ошибка: " + e.getMessage());
//            throw e;
//        }
//    }
//
//    //TODO: Нужно будет допилить
//    @Test(description = "Проверка успешного сброса пароля")
//    public void testSuccessfulPasswordReset() {
//        try {
//            WebElement forgotPasswordBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Забыли пароль?']")));
//            assertNotNull(forgotPasswordBtn);
//            forgotPasswordBtn.click();
//            log.info("Кнопка 'Забыли пароль?' успешно нажата");
//
//            WebElement resetPasswordTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Забыли пароль?']")));
//            assertNotNull(resetPasswordTitle);
//            log.info("Страница восстановления пароля открылась успешно.");
//
//            WebElement loginInnField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
//            assertNotNull(loginInnField);
//            log.info("Поле ввода ИНН найдено.");
//
//            WebElement resetPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
//            assertNotNull(resetPasswordField);
//            log.info("Поле ввода нового пароля найдено.");
//
//            WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("ConfirmPassword")));
//            assertNotNull(confirmPasswordField);
//            log.info("Поле повторного ввода пароля найдено.");
//
//            WebElement resetPasswordBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Сбросить']")));
//            assertNotNull(resetPasswordBtn);
//            log.info("Кнопка 'Сбросить' найдена.");
//
//            // Тестирование случая, когда пароли совпадают
//            loginInnField.sendKeys("22905200300907523");
//            resetPasswordField.sendKeys("YameteKudasai");
//            confirmPasswordField.sendKeys("YameteKudasai"); // Совпадающий пароль
//            Thread.sleep(1000);
//            resetPasswordBtn.click();
//
//            // Убедиться, что система отображает сообщение об успешном сбросе пароля
//            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='notyf__message']")));
//            assertNotNull(successMessage);
//            log.info("Сообщение об успешном сбросе отображается");
//            Thread.sleep(1000);
//
//            String expectedSuccessText = "Пароль успешно сброшен"; // Убедитесь, что это правильный текст сообщения
//            String actualSuccessText = successMessage.getText();
//            assertTrue(actualSuccessText.contains(expectedSuccessText), "Сообщение об успешном сбросе отображается правильно.");
//            Thread.sleep(1000);
//        } catch (Exception e) {
//            log.error("Ошибка: " + e.getMessage());
//
//        }
//    }
//
//    //TODO: Нужно будет допилить
//    @Test(description = "Проверка отображения символов пароля")
//    public void testPasswordDisplay() {
//        try {
//            // Находим поле пароля
//            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
//            assertNotNull(passwordField);
//
//            // Вводим пароль
//            String password = "12334";
//            passwordField.sendKeys(password);
//            log.info("Этап ввода пароля: " + password);
//
//            // Ждем небольшую задержку для корректного отображения звездочек или точек
//            Thread.sleep(1000);
//
//            // Получаем введенный пароль с помощью JavaScript
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            String enteredPassword = (String) js.executeScript("return arguments[0].value;", passwordField);
//
//            // Проверяем, что введенные символы пароля отображаются в виде звездочек или точек
//            assertTrue(enteredPassword.matches("[\\*\\●]+"), "Символы пароля отображаются в виде звездочек или точек");
//
//            log.info("Проверка отображения символов пароля выполнена успешно");
//
//        } catch (Exception e) {
//            log.error("Ошибка при проверке отображения символов пароля: " + e.getMessage());
//        }
//    }
//
//    @Test(description = "Проверка работы кнопки для отображения пароля")
//    public void passwordVisibilityTest() {
//        try {
//            // Найти поле для ввода пароля
//            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Password")));
//            assertNotNull(passwordField, "Поле для ввода пароля найдено");
//            log.info("Поле для ввода пароля найдено");
//
//            // Ввести пароль
//            passwordField.sendKeys("Linux7788");
//
//            // Найти кнопку для отображения пароля
//            WebElement showPasswordButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-kt-password-meter-control='visibility']")));
//            assertNotNull(showPasswordButton, "Кнопка для отображения пароля не найдена");
//            Thread.sleep(1000);
//            log.info("Кнопка для отображения пароля найдена");
//
//            // Кликнуть на кнопку для отображения пароля
//            showPasswordButton.click();
//
//            // Проверить, что пароль отображается в виде читаемого текста
//            WebElement visiblePasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text' and @id='Password']")));
//            assertTrue(visiblePasswordField.isDisplayed(), "Пароль не отображается в виде текста");
//            Thread.sleep(1000);
//            log.info("Пароль отображается в виде текста");
//
//            // Кликнуть на кнопку еще раз
//            showPasswordButton.click();
//
//            // Проверить, что пароль снова отображается в виде звездочек или точек
//            WebElement hiddenPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password' and @id='Password']")));
//            assertTrue(hiddenPasswordField.isDisplayed(), "Пароль отображается в виде текста, а не скрыт");
//            Thread.sleep(1000);
//            log.info("Пароль отображается в виде текста, а не скрыт");
//
//        } catch (Exception e) {
//            log.error("Ошибка :" + e.getMessage());
//        }
//    }
//
//    @Test(description = "Проверка наличия логотипа на странице входа")
//    public void mainLogo(){
//        try {
//            WebElement mainLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='ГНС']")));
//            assertTrue(mainLogo.isDisplayed(), "Главный логотип отображается");
//            Thread.sleep(1000);
//            log.info("Лого отображается");
//
//        }catch (Exception e){
//            log.error("Ошибка: " + e.getMessage());
//        }
//    }
//
//    @Test(description = "Проверка наличия и функциональности ссылки Зарегистрируйтесь")
//    public void testRegistrationLinkBtn() {
//        try {
//            WebElement registrationLinkBtn = driver.findElement(By.xpath("//a[contains(@class, 'li-tab') and contains(@class, 'btn-active-color-primary') and @href='/account/register']"));
//            Assert.assertNotNull(registrationLinkBtn, "Элемент 'Зарегистрироваться' не найден");
//            log.info("Элемент 'Зарегистрироваться' найден");
//            Thread.sleep(1000);
//
//            registrationLinkBtn.click();
//            log.info("Переход выполнен");
//
//            WebElement registrationPage = driver.findElement(By.xpath("//p[@class='fw-bold fs-2']"));
//            Assert.assertNotNull(registrationPage, "Элемент на новой странице не найден");
//            log.info("Новая страница найдена");
//            Thread.sleep(1000);
//
//            String expectedText = "Регистрация";
//            String actualText = registrationPage.getText();
//            Assert.assertEquals(actualText, expectedText, "Текст на новой странице не совпадает с ожидаемым");
//            Thread.sleep(1000);
//
//        } catch (Exception e) {
//            log.error("Ошибка: " + e.getMessage());
//        }
//    }
//
//    @Test(description = "Проверка наличия и функциональности ссылки Руководство пользователя")
//    public void userGuideLink() {
//        try {
//            // Поиск элемента ссылки
//            WebElement userGuideLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'd-none') and contains(@class, 'd-lg-inline-block') and contains(@class, 'a-bottom')]")));
//            Assert.assertNotNull(userGuideLink, "Ссылка 'Руководство пользователя' не найдена");
//            log.info("Ссылка найдена");
//
//            // Переход по ссылке
//            userGuideLink.click();
//            log.info("Переход по ссылке выполнен");
//
//            // Ожидание появления нового элемента на новой странице
//            WebElement guideLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='font-weight-bold']")));
//            Assert.assertNotNull(guideLink, "Элемент на новой странице не найден");
//            log.info("Новая страница найдена");
//
//            // Проверка текста на новой странице
//            String expectedText = "Руководство пользователя";
//            String actualText = guideLink.getText();
//            Assert.assertEquals(actualText, expectedText, "Текст на новой странице не совпадает с ожидаемым");
//        } catch (Exception e) {
//            log.error("Ошибка: " + e.getMessage());
//            Assert.fail("Тест провален из-за ошибки: " + e.getMessage());
//        }
//    }
//
//    @Test(description = "Проверка наличия и функциональности ссылки Помощники")
//    public void helperLink(){
//        try {
//            WebElement helperLink = driver.findElement(By.xpath("//a[@class='d-none d-lg-inline-block a-bottom ps-15 ']"));
//            Assert.assertNotNull(helperLink, "Ссылка не найдена");
//            log.info("Ссылка найдена");
//            helperLink.click();
//            log.info("Кнопка нажата");
//
//            Thread.sleep(1000);
//            WebElement helperPage = driver.findElement(By.xpath("//h3[@class='font-weight-bold']"));
//            Assert.assertNotNull(helperPage, "Страница не отображается");
//            log.info("Страница отображается корректно");
//
//            Thread.sleep(1000);
//            String expectedText = "Помощники";
//            String actualText = helperPage.getText();
//            Assert.assertEquals(actualText, expectedText, "Текст на новой странице не совпадает с ожидаемым");
//        }catch (Exception e){
//            log.error("Ошибка: " + e.getMessage());
//            Assert.fail("Тест провален из-за ошибки: " + e.getMessage());
//        }
//    }
//
//    @Test(description = "Проверка наличия и функциональности ссылки Контакт-центр 116")
//    public void contactCenterLink() {
//        try {
//            // Ожидание видимости элемента 'Контакт-центр 116'
//            WebElement contactCenterLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='a-bottom ps-15']")));
//            Assert.assertNotNull(contactCenterLink, "Элемент 'Контакт-центр 116' не найден");
//            log.info("Элемент 'Контакт-центр 116' найден");
//
//            // Переход по ссылке
//            contactCenterLink.click();
//            log.info("Кнопка 'Контакт-центр 116' нажата");
//
//            // Ожидание появления нового элемента на новой странице
//            WebElement contactCenterPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='tel:116' and @class='a-bottom ps-15']")));
//            Assert.assertNotNull(contactCenterPage, "Элемент на новой странице не найден");
//            log.info("Элемент на новой странице найден");
//
//            // Проверка текста на новой странице
//            String expectedText = "Контакт-центр 116";
//            String actualText = contactCenterPage.getText();
//            Assert.assertEquals(actualText, expectedText, "Текст на новой странице не совпадает с ожидаемым");
//
//        } catch (Exception e) {
//            log.error("Ошибка: " + e.getMessage());
//            Assert.fail("Тест провален из-за ошибки: " + e.getMessage());
//        }
//    }
//
//    @Test(description = "Проверка правильности отображения изображений и графических элементов на странице")
//    public void testImagesAndGraphics() {
//        try {
//            // Список XPaths для всех изображений и графических элементов на странице
//            List<String> imageXpaths = List.of(
//                    "//img[@src='images/sliders/topLoginSlider/gns.svg']",
//                    "//img[@src='images/sliders/topLoginSlider/smart.svg']",
//                    "//img[@src='images/sliders/loginSlider/banner1.svg']",
//                    "//img[@src='images/sliders/loginSlider/banner2.png']",
//                    "//img[@src='images/sliders/loginSlider/banner3.png']"
//            );
//
//            // Проверка каждого изображения на корректность отображения
//            for (String xpath : imageXpaths) {
//                WebElement imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//                Assert.assertTrue((Boolean) ((ChromeDriver) driver).executeScript(
//                                "return arguments[0].complete && arguments[0].naturalHeight > 0", imageElement),
//                        "Изображение не отображается корректно: " + xpath);
//                log.info("Изображение отображается корректно: " + xpath);
//            }
//
//        } catch (Exception e) {
//            log.error("Ошибка: " + e.getMessage());
//            Assert.fail("Тест провален из-за ошибки: " + e.getMessage());
//        }
//    }
//
//    @Test(description = "Проверка функциональности кнопки Зарегистрируйтесь для новых пользователей")
//    public void testRegisterBtn(){
//        try {
//            WebElement registrationLinkBtn = driver.findElement(By.xpath("//a[contains(@class, 'li-tab') and contains(@class, 'btn-active-color-primary') and @href='/account/register']"));
//            Assert.assertNotNull(registrationLinkBtn, "Элемент 'Зарегистрироваться' не найден");
//            log.info("Элемент 'Зарегистрироваться' найден");
//            Thread.sleep(500);
//            registrationLinkBtn.click();
//
//            WebElement registerPage = driver.findElement(By.xpath("//p[@class='fw-bold fs-2']"));
//            Assert.assertNotNull(registerPage, "Элемент 'Регистрация' не найден");
//            log.info("Элемент 'Регистрация' найдена");
//
//            WebElement personTypeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='select2-PersonType-container']")));
//            Assert.assertNotNull(personTypeDropdown, "Выплывающий список не отображается");
//            log.info("Выплывающий список отображается корректно");
//
//            WebElement individualOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='select2-selection__rendered']")));
//            Assert.assertNotNull(individualOption, "Опция 'Физическое лицо' не найдена");
//            log.info("Опция 'Физическое лицо' выбрана");
//
//            WebElement innField = driver.findElement(By.xpath("//input[@name='Pin']"));
//            Assert.assertNotNull(innField, "Поле не найдено");
//            innField.sendKeys("22405200000946");
//            log.info("Поле заполнено");
//
//            WebElement searchBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary w-100']"));
//            searchBtn.click();
//            log.info("Кнопка нажата");
//
//            WebElement passwordField = driver.findElement(By.xpath("//input[@id='Password']"));
//            Assert.assertNotNull(passwordField, "Поле не найдено");
//            log.info("Поле отображается корректно");
//            passwordField.sendKeys("Linux7788123");
//            log.info("Пароль введен");
//
//            WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
//            Assert.assertNotNull(confirmPasswordField, "Поле не найдено");
//            log.info("Поле отображается корректно");
//            confirmPasswordField.sendKeys("Linux7788123");
//            log.info("Повторный пароль введен");
//
//            WebElement registerBtn = driver.findElement(By.xpath("//button[@class='btn btn-block btn-secondary w-100']"));
//            Assert.assertNotNull(registerBtn, "Возникла ошибка при нажатии на кнопку");
//            registerBtn.click();
//            log.info("Кнопка нажата");
//
//            WebElement notificationWrapper = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='notyf__wrapper']")));
//            Assert.assertNotNull(notificationWrapper, "Уведомление о регистрации не отображается");
//            String actualNotification = notificationWrapper.getText();
//            String expectedNotification = notificationWrapper.getText();
//            Assert.assertEquals(actualNotification, expectedNotification, "Фактическое уведомление не соответствует ожидаемому");
//            log.info("Уведомление о регистрации отображается корректно: " + actualNotification);
//
//        } catch (Exception e){
//            log.error("Ошибка: " + e.getMessage());
//            Assert.fail("Тест провален из-за ошибки: " + e.getMessage());
//        }
//    }
//
//    @Test(description = "")
//
//    @AfterMethod
//    public void tearDownMethod() {
//        driver.quit();
//    }
//
//    @AfterClass
//    public void tearDownClass() {
//        // Любые действия, которые нужно выполнить после завершения всех тестов
//    }
//}
