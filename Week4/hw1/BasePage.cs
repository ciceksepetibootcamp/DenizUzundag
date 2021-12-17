using System;
using System.IO;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace hw1
{
    public class BasePage
    {
         public static IWebDriver driver;
        public void Initialize()
        {

            ChromeOptions chromeOptions= new ChromeOptions();
            string path = Directory.GetParent(Environment.CurrentDirectory).Parent.Parent.FullName;
            driver = new ChromeDriver(path + @"\driver\");
            driver.Url = "https://atlasglb.esky.com.tr/";
        }
    }
}