//package UI.registrationNpTest;
//
//
//import UI.BaseTest;
//import org.openqa.selenium.By;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.Test;
//
//import static ui.dataProvider.ConfigReader.getProperty;
//
//import static org.testng.Assert.assertEquals;
//
//public class RegistrationNpTest extends BaseTest {
//    private static final Logger log = LoggerFactory.getLogger(RegistrationNpTest.class);
//
//    @Test(description = "Нажатие на кнопку зарегестрировать НП", groups = "test1")
//    void clickRegistrationNpTest() {
//        try {
//            allPages.adminPanelPages.clickRegistrationNP();
//            String massageRegistrationNP = driver.findElement(By.xpath("//h2[@class='subtitle-18-bold']")).getText();
//            assertEquals(massageRegistrationNP, "Регистрация НП");
//            log.info("Пользователь находится на первой шаге Регистрации НП");
//        } catch (Exception e) {
//            log.error("Вышла ошибка по причине:" + e.getMessage());
//        }
//    }
//
//
//    @Test(description = "Заполнение полей и нажатие на кнопку Далее", groups = "test1")
//    void inputFieldsAndClickNextTest() {
//        try {
//            allPages.registrationNpPages.inputFieldsAndClickNext();
//            String innNp = driver.findElement(By.xpath("//input[@id='tin']")).getAttribute("value");
//            assertEquals(innNp, getProperty("innForRegistrationNP"));
//            log.info("Пользователь находится на втором шаге Регистрации НП");
//        } catch (Exception e) {
//            log.error("Ошибка на втором шаге вышла про причине:" + e.getMessage());
//        }
//    }
//}