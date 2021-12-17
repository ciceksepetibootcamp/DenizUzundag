using NUnit.Framework;

namespace hw1
{

    public class Test : BasePage
    {
        HomePage home;
        [OneTimeSetUp]
        public void Setup()
        {
            Initialize();
            home = new HomePage(driver);

        }

        [Test]
        public void test1()
        {
            home.SearchFlight();
            Assert.AreNotEqual("flights", driver.Title);

        }



    }


}