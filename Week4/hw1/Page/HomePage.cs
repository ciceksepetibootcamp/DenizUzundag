using System;
using OpenQA.Selenium;
using SeleniumExtras.PageObjects;

namespace hw1
{
    public class HomePage:BasePage
    {
        public HomePage(IWebDriver driver)
        {
            HomePage.driver = driver;
            Console.WriteLine("hi");
            PageFactory.InitElements(driver,this);
          
        }
        [FindsBy(How = How.Id, Using = "TripTypeOneway")]
        private IWebElement oneWay;

        [FindsBy(How = How.Id, Using = "departureOneway")]
        private IWebElement city1;

        [FindsBy(How = How.Id, Using = "arrivalOneway")]
        private IWebElement city2;

        [FindsBy(How = How.Id, Using = "departureDateOneway")]
        private IWebElement dateInput;

        [FindsBy(How = How.CssSelector, Using = ".ui-datepicker-today")]
        private IWebElement date;

        [FindsBy(How = How.CssSelector, Using = ".btn.qsf-search.transaction")]
        private IWebElement search;

        [FindsBy(How = How.CssSelector, Using = "esky-body-cell:nth-of-type(2) > .ng-star-inserted")]
        private IWebElement flight;

     
        public void SearchFlight()
        {
            oneWay.Click();
            city1.Click();
            city1.SendKeys("İzmir");
            city2.Click();
            city2.SendKeys("Ankara");
            dateInput.Click();
            date.Click();
            search.Click();
            
        }

        
    }
}