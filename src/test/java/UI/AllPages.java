package UI;

import groovy.xml.StreamingDOMBuilder;
import org.testng.annotations.BeforeTest;
import ui.pages.LoginPage;
import ui.pages.adminPanel.AdminPanelPages;
import ui.pages.registrationNp.RegistrationNpPages;

public class AllPages {
    public LoginPage loginPage;
    public RegistrationNpPages registrationNpPages;
    public AdminPanelPages adminPanelPages;


    @BeforeTest(alwaysRun = true)
    public void initPage(){
        loginPage = new LoginPage();
        registrationNpPages = new RegistrationNpPages();
        adminPanelPages = new AdminPanelPages();
    }
}
