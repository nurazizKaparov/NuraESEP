package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import ui.drivers.Driver;
import ui.helpers.WebElementHelper;
import static org.testng.Assert.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ui.dataProvider.ConfigReader.getProperty;

public class BaseTest {
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;
    protected WebElementHelper webElementHelper;
    public AllPages allPages;


    @BeforeSuite(alwaysRun = true)
    public void setUp() throws InterruptedException {
        driver = Driver.getDriver();
        webElementHelper = new WebElementHelper();
        allPages = new AllPages();
        allPages.initPage();
        driver.get(getProperty("url"));
        allPages.loginPage.doLogin();
        Thread.sleep(1000);
        try{
            assertEquals(allPages.loginPage.messageKKM.getText(), "ККМ");
            log.info("Пользователь на главной странице Админ Панель");
        }catch (Exception e){
            log.error("Не найдена надпись 'ККМ'");
        }
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown() {
//        Driver.closeDriver();
    }
}
