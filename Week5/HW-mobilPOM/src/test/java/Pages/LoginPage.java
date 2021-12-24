package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import utils.Helper;

public class LoginPage extends Helper {
    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void login(String email,String password){
        MobileElement el1 =  driver.findElementById("imClose");
        clickElement(el1);
       // MobileElement cancel = driver.findElementById("netmera_web_view_toolbar_cancel");
        // clickElement(cancel);
        MobileElement sign_in= driver.findElementById("tvProfile");
        clickElement(sign_in);
        MobileElement name= driver.findElementById("etUsername");
        sendKeysElement(name,email);
        MobileElement pass= driver.findElementById("etPassword");
        sendKeysElement(pass,password);
        MobileElement btn= driver.findElementById("btnSignIn");
        clickElement(btn);
    }


    public void checkErrorMessage(String textMsg2){
        MobileElement msg= driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.TextView");
        Assert.assertTrue(msg.getText().contains(textMsg2));
    }
}

