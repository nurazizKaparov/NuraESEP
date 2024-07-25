package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.drivers.Driver;
import ui.helpers.WebElementHelper;
import static org.testng.Assert.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ui.dataProvider.ConfigReader.getProperty;

public class BaseTest {
    protected WebDriver driver;
    protected WebElementHelper webElementHelper;
    public AllPages allPages;


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = Driver.getDriver();
        webElementHelper = new WebElementHelper();
        allPages = new AllPages();
        allPages.initPage();
        driver.get(getProperty("url"));
        allPages.loginPage.doLogin();
        try{
            assertEquals(allPages.loginPage.messageKKM.getText().toLowerCase(), "ККМ");
        }catch (Exception e){
            System.out.println("Ошибка");
        }
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
//        Driver.closeDriver();
    }
}
