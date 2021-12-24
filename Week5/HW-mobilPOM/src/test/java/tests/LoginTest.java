package tests;

import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends  BaseTest {
    @Test
    public void Login() {
        {
            LoginPage loginPage=new LoginPage(driver);
            loginPage.login("uzundagdeniz@gmail.com","Dnz170359");

        }
    }
    @Test
    public void wrongLogin() {
        {
            LoginPage loginPage=new LoginPage(driver);
            loginPage.login("abcdsd@gmail.com","");
            loginPage.checkErrorMessage("Please check the e-mail address you entered.");

        }
    }
}