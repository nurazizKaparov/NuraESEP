package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.drivers.Driver;
import ui.helpers.FakeDataHelper;
import ui.helpers.WebElementHelper;

import java.time.Duration;

public class BasePage {
    public WebElementHelper webElementHelper = new WebElementHelper();
    public FakeDataHelper fakeDataHelper = new FakeDataHelper();
    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}

