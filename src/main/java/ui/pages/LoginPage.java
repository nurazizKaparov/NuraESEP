package org.example.pages;

import org.example.drivers.Driver;
import org.example.ui.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    Actions act;

    public LoginPage(){
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "Username")
    public WebElement innInput;
    @FindBy(name = "Password")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[@class='btn btn-primary w-100']")
    public WebElement submitBtn;


    WebElementHelper webElementHelper =new WebElementHelper();
    public LoginPage fullUpInn(String login){
        webElementHelper.sendKeys(innInput, login);
        return this;
    }
    public LoginPage fullUpPassword(String password){
        webElementHelper.sendKeys(passwordInput, password);
        return this;
    }
    public LoginPage clickSubmitBtn(){
        webElementHelper.click(submitBtn);
        return this;
    }

    public boolean isLoggedIn() {
        WebElement welcomeMessage = driver.findElement(By.xpath("//span[@class='text-gray-600 fs-6 fw-semibold']"));
        return welcomeMessage.isDisplayed();
    }
}
