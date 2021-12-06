package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    private By email= By.cssSelector("input[name='email']");
    private By passWord= By.cssSelector("input[name='password']");
    private By loginButton= By.cssSelector(".login-btn-menu.ng-binding");
    private By forgotPasswordButton=By.cssSelector(".forgot-link-text.ng-binding.ng-scope");
    private By forgotEmail=By.cssSelector("form[name='forgotPasswordForm1'] input[name='email']");
    private By sendButton = By.xpath("//form[@name='forgotPasswordForm1']//button[@type='submit']");
    private By topMatch = By.xpath("//ul[@id='top-left-nav']/li[3]/a");


    public void url() { driver.get("https://www.tipster.de/"); }
    public void loginButton()
    {
        driver.findElement(loginButton).click();
    }
    public void forgotPass(){driver.findElement(forgotPasswordButton).click();}
    public void sendButtonClick(){
        driver.findElement(sendButton).click();
    }
    public void email(String emaill)
    {
        WebElement emailInput= driver.findElement(email);
        emailInput.click();
        emailInput.sendKeys(emaill);
    }
    public void password(String passw)
    {
        WebElement paswdInput= driver.findElement(passWord);
        paswdInput.click();
        paswdInput.sendKeys(passw);
    }
    public void forgotPassEmail(String emaill){
        WebElement input = driver.findElement(forgotEmail);
        input.click();
        input.sendKeys(emaill);
    }
    public void Sporttwetten(){driver.findElement(topMatch).click();}

}
