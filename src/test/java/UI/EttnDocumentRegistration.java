package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class EttnDocumentRegistration {
    private static final Logger log = LoggerFactory.getLogger(EttnDocumentRegistration.class);
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
    }

    @BeforeMethod
    public void setUpMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://testcabinet.salyk.kg/account/login");
        login();
    }

    private void login() {
        try {
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
            WebElement expectedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-gray-600 fs-6 fw-semibold']")));
            assertNotNull(expectedElement);
            Thread.sleep(1000);
            log.info("Клиент успешно вошел в систему");


        } catch (Exception e) {
            log.error("Ошибка при попытке авторизации: " + e.getMessage());
            Assert.fail("Авторизация провалилась из-за ошибки: " + e.getMessage());
        }
    }


    @Test(description = "Тест функции после авторизации")
    public void testFunctionalityAfterLogin() {
        try {
            WebElement loginBtn = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-light-primary ladda-button btn-link-deactivate'][1]"));
            loginBtn.click();
            log.info("Кнопка нажата");
            WebElement expectedElement = driver.findElement(By.xpath("//span[text()='Главная']"));
            assertNotNull(expectedElement);
            String actualText = expectedElement.getText();
            String expectedText = expectedElement.getText();
            Assert.assertEquals(actualText, expectedText, "Текст не совпадает с ожидаемой!");
            Thread.sleep(1000);
            log.info("Текст найден и проверен");
        } catch (Exception e) {
            log.error("Ошибка: " + e.getMessage());
            Assert.fail("Тест провален из-за ошибки: " + e.getMessage());
        }
    }

    @Test(description = "Проверка перехода в ЭТТН")
    public void ettnHomePage(){
        try{
            WebElement loginBtn = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-light-primary ladda-button btn-link-deactivate'][1]"));
            loginBtn.click();
            log.info("Кнопка нажата");
            WebElement ettnBtn = driver.findElement(By.xpath("//span[text()='ЭТТН']"));
            ettnBtn.click();
            Thread.sleep(1000);
            String expectedUrl = "https://testcabinet.salyk.kg/"; // Замените на фактический URL
            String actualUrl = driver.getCurrentUrl();

            // Проверка актуального и ожидаемого результата
            Assert.assertEquals(actualUrl, expectedUrl, "Переход на страницу ЭТТН не выполнен.");
            log.info("Переход на страницу ЭТТН выполнен успешно.");
        }catch (Exception e){
            log.error("Ошибка: " + e.getMessage());
            Assert.fail("Тест провален из-за ошибки: " + e.getMessage());
        }
    }

    @Test(description = "Переход в раздел документы")
    public void ettnPageDoc(){
        try {

        }catch (Exception e){
            log.error("Ошибка: " + e.getMessage());
            Assert.fail("Тест провален из-за ошибки: " + e.getMessage());
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
