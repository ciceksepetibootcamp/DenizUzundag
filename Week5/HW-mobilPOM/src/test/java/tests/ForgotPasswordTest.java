package tests;

import Pages.ForgotPasswordPage;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends  BaseTest {
    @Test
    public void WrongforgotPass(){

        ForgotPasswordPage loginPage=new ForgotPasswordPage(driver);
        loginPage.forgottPass("deefdsf");
        loginPage.checkErrorMessage("Please check the e-mail address you entered.");

    }
    @Test
    public void forgotPass(){

        ForgotPasswordPage loginPage=new ForgotPasswordPage(driver);
        loginPage.forgottPass("uzundagdeniz@gmail.com");
        loginPage.checkMessage("Password reset link has been sent to you.");

    }



}
