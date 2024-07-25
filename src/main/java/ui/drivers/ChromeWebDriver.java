package ui.drivers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
public class ChromeWebDriver {
    public static WebDriver driver;
    public static WebDriver loadChromeDriver(){
    WebDriverManager.chromedriver().setup();
    ChromeOptions options =new ChromeOptions();
    options.addArguments("--start-maximized");
    options.addArguments("--disable-extension");
    options.addArguments("--windows=size-1980,1080");

    WebDriver driver =new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    return driver;
    };

}
