package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HomePage;
import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testCase_02 {
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException{
      driver=DriverSingleton.getInstanceOfSingletonBrowserClass().getDriver();
      BaseClass basetest = new BaseClass();
      basetest.navigateToHome(driver);
    }
    @Test(dataProvider = "data-provider", dataProviderClass = DP.class, description = "TestCase02", priority = 1, groups = {"Search and Filter flow"})
    public void TestCase02(String CityName, String Category_Filter, String DurationFilter, String ExpectedFilteredResults, String ExpectedUnFilteredResults) throws InterruptedException, MalformedURLException{
        // Navigate to the Home page of QTrip
        BaseClass bclass= new BaseClass();
        bclass.navigateToHome(driver);
        //Search for a city thats not present
        HomePage homePage = new HomePage(driver);
        homePage.SearchCity(CityName);
        homePage.AssertAutoCompleteText(CityName);
        homePage.SelectCity(CityName);
        Thread.sleep(1000);

        AdventurePage adPage = new AdventurePage(driver);
        adPage.SetFilterValue();
        adPage.SetCategoryValue();
        adPage.clearData();
        adPage.getResultCount();//check this
      }
}

