package UI.registrationNpTest;

import UI.BaseTest;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegistrationNpTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(RegistrationNpTest.class);

    @Test(description = "Нажатие на кнопку зарегестрировать НП")
    void clickRegistrationNpTest(){
        allPages.adminPanelPages.btnRegistrationNP.click();
        String massageRegistrationNP = driver.findElement(By.xpath("//h2[@class='subtitle-18-bold']")).getText();
        assertEquals(massageRegistrationNP, "Регистрация НП");
    }


    @Test(description = "Заполнение полей и нажатие на кнопку Далее")
    void inputFieldsAndClickNextTest() {
        try{
            allPages.registrationNpPages.inputFieldsAndClickNext();
            String saveBtnName = driver.findElement(By.xpath("//button[@class=\"ant-btn css-iuyn2o ant-btn-default sc-eqUzNf gKhIfv\"]")).getText();
            assertEquals(saveBtnName, "Сохранить");
            log.info("Done");
        }catch (Exception e){
            log.error("Ошибка вышла про причине:" + e.getMessage());
        }
    }
}