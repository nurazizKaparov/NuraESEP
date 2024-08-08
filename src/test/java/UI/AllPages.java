package UI;

import groovy.xml.StreamingDOMBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import ui.pages.LoginPage;
import ui.pages.adminPanel.AdminPanelPages;
import ui.pages.detailsNp.InfoNpPage;
import ui.pages.detailsNp.KkmInfoPage;
import ui.pages.registrationKKM.RegistrationKkmPage;
import ui.pages.registrationKKM.RegistrationKkmPage;
import ui.pages.registrationNp.RegistrationNp2Pages;
import ui.pages.registrationNp.RegistrationNpPages;
import ui.pages.registrationNp.RegistrationNp2Pages;

public class AllPages {
    public LoginPage loginPage;
    public AdminPanelPages adminPanelPages;
    public RegistrationNpPages registrationNpPages;
    public RegistrationNp2Pages registrationNp2Pages;
    public RegistrationKkmPage registrationKkmPage;
    public InfoNpPage infoNpPage;
    public KkmInfoPage kkmInfoPage;
    public InfoNpPage infoNpPage;





    @BeforeMethod(alwaysRun = true)
    public void initPage() {
        loginPage = new LoginPage();
        adminPanelPages = new AdminPanelPages();
        registrationNpPages = new RegistrationNpPages();
        registrationNp2Pages = new RegistrationNp2Pages();
        registrationKkmPage = new RegistrationKkmPage();
        infoNpPage = new InfoNpPage();
        kkmInfoPage = new KkmInfoPage();
        infoNpPage = new InfoNpPage();

    }
}
