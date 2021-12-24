package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import utils.Helper;

public class ForgotPasswordPage extends Helper {
    public ForgotPasswordPage(AndroidDriver driver) {
        super(driver);
    }

    public void forgottPass(String email){
        MobileElement el1 =  driver.findElementById("imClose");
        clickElement(el1);
        //MobileElement cancel = driver.findElementById("netmera_web_view_toolbar_cancel");
       // clickElement(cancel);
        MobileElement sign_in= driver.findElementById("tvProfile");
        clickElement(sign_in);
        MobileElement forgotPass= driver.findElementById("tvForgetPassword");
        clickElement(forgotPass);
        MobileElement user_name= driver.findElementById("etUsername");
        sendKeysElement(user_name,email);
        MobileElement btn= driver.findElementById("btnReset");
        clickElement(btn);

    }

    public void checkErrorMessage(String textMsg) {
        MobileElement msg= driver.findElementById("textinput_error");
        Assert.assertTrue(msg.getText().contains(textMsg));
    }

    public void checkMessage(String textMsg2){
        MobileElement msg= driver.findElementByXPath("\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView");
        Assert.assertTrue(msg.getText().contains(textMsg2));
    }


}
