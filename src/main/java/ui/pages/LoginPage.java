package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static ui.dataProvider.ConfigReader.getProperty;
import java.util.Properties;

public class LoginPage extends BasePage{
    @FindBy(id = "emailPasswordForm_email")
    public WebElement fieldLogin;
    @FindBy(id = "emailPasswordForm_password")
    public  WebElement fieldPassword;
    @FindBy(xpath = "//button[@class='ant-btn css-iuyn2o ant-btn-default sc-ikkyvV tNSuC sc-iMTngq lnsZfT']")
    public  WebElement btnAuth;
    @FindBy(xpath = "//h1[@class=\"text-medium-16 mv-12\"]")
    public WebElement messageKKM;

    public LoginPage doLogin(){
        webElementHelper
                .sendKeys(fieldLogin, getProperty("loginUserAdmin"))
                .sendKeys(fieldPassword, getProperty("passwordUser"))
                .click(btnAuth);
        return this;
    }
}