package Stepdefs;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Test1  {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;


    @Before
    public void setup() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("app", "C:/Users/uzund/Downloads/Starbucks Turkey_v2.3.1_apkpure.com.apk");
        caps.setCapability("devicename", "emulator-5554");

        caps.setCapability("fullReset", "true");
        caps.setCapability("noReset", "false");
        caps.setCapability("autoGrantPermissions", "true");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
    }

    @Given("popup kapatilir ve signin sayfasina girilir.")
    public void popupKapatilirVeSigninSayfasinaGirilir() {
        MobileElement el1 =  driver.findElementById("imClose");
        el1.click();

        MobileElement sign_in= driver.findElementById("tvProfile");
        sign_in.click();

    }

    @When("forgotPassword butonuna tıklanir.")
    public void forgotpasswordButonunaTıklanir() {
        MobileElement forgotPass= driver.findElementById("tvForgetPassword");
        forgotPass.click();
    }

    @And("{string} girilir")
    public void girilir(String arg0) {

        MobileElement user_name= driver.findElementById("etUsername");
        user_name.sendKeys(arg0);

    }

    @And("butona tiklanir")
    public void butonaTiklanir() {
        MobileElement btn= driver.findElementById("btnReset");
        btn.click();
    }


    @Then("message kontrol edilir.")
    public void kontrolEdilir() {
        MobileElement msg= driver.findElementByXPath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView");


        Assert.assertEquals(msg.getText(),"Please check the e-mail address you entered.");
    }

    @Then("{string} kontrol edilir.")
    public void kontrolEdilir(String arg0) {
        MobileElement msg= driver.findElementByXPath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView");
        Assert.assertTrue(msg.getText().contains(arg0));
    }

    @When("{string} ve {string} girilir")
    public void veGirilir(String arg0, String arg1) {
        MobileElement name= driver.findElementById("etUsername");
        name.sendKeys(arg0);
        MobileElement pass= driver.findElementById("etPassword");
        pass.sendKeys(arg1);

    }

    @And("login butona tiklanir")
    public void loginButonaTiklanir() {
        MobileElement btn= driver.findElementById("btnSignIn");
        btn.click();
    }

    @Then("hata {string} kontrol edilir.")
    public void hataKontrolEdilir(String arg0) {
        MobileElement msg= driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView");
        Assert.assertTrue(msg.getText().contains(arg0));
    }

    @When("{string} girilir {string} bos gecilir")
    public void girilirBosGecilir(String arg0, String arg1) {
        MobileElement name= driver.findElementById("etUsername");
        name.sendKeys(arg0);
        MobileElement pass= driver.findElementById("etPassword");
        pass.sendKeys(arg1);
    }
}
