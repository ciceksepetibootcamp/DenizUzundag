package tests;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class Test {
    WebDriver driver;
    HomePage homePage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("Kullanici anasayfayi ziyaret eder")
    public void kullaniciAnasayfayiZiyaretEder() {
        homePage.url();
    }

    @When("email kutusuna {string} bilgisini  Password kutusuna {string} bilgisini girer")
    public void emailKutusunaBilgisiniPasswordKutusunaBilgisiniGirer(String arg0, String arg1) {
        homePage.email(arg0);
        homePage.password(arg1);
    }

    @And("login butona tıklar")
    public void butonaTıklar() {
        homePage.loginButton();
    }

    @Then("kullanıcı login olur ve {string} görür")
    public void kullaniciLoginOlurVeGorur(String arg0) {
        String element= ".user > a > .ng-binding[contains(text(),'"+arg0+"')]";
        Assert.assertTrue(driver.findElement(By.cssSelector(element)).getText().contains(arg0));

    }

    @When("forgotPassword butonuna tiklar")
    public void forgotpasswordButonunaTiklar() { homePage.forgotPass(); }

    @And("acilanan popupa {string} adresini girer")
    public void acilananPopupaAdresiniGirer(String arg0) { homePage.forgotPassEmail(arg0); }

    @Then("send butonuna tiklar")
    public void sendButonunaTiklar() { homePage.sendButtonClick(); }


    @When("Sportwetten kategorisini secer")
    public void SportwettenKategorisiniSecer() {

        homePage.Sporttwetten();
    }

    @Then("{string} listesini gorur")
    public void topMatchesListesiniGorur(String arg0) {
        String list= ".section-title > div[contains(text(),'"+arg0+"')]";
        Assert.assertTrue(driver.findElement(By.cssSelector(list)).getText().contains(arg0));
    }
}
