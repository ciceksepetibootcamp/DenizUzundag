package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    public Helper (AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }
    public void clickElement(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void sendKeysElement(MobileElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }

}
