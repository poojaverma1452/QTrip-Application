package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.pages.AdventureDetailsPage;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HistoryPage;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import qtriptest.pages.RegisterPage;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testCase_03 {
    WebDriver driver;
    String lastGeneratedUserN="";
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException{
      driver=DriverSingleton.getInstanceOfSingletonBrowserClass().getDriver();
      BaseClass basetest = new BaseClass();
      basetest.navigateToHome(driver);
    }
    
    @Test(dataProvider = "data-provider", dataProviderClass = DP.class, description = "TestCase03", priority = 2, groups = {"Booking and Cancellation Flow"})
    public void TestCase03(String NewUserName, String Password, String SearchCity, String AdventureName, String GuestName, String Date, String count) throws InterruptedException{
      BaseClass bclass = new BaseClass();
      bclass.navigateToHome(driver);
      Thread.sleep(500);
      HomePage home= new HomePage(driver);
      Thread.sleep(500);
      home.ClickRegister();
         
      RegisterPage regPage = new RegisterPage(driver);
      regPage.RegisterNewUser(NewUserName, Password, true);
      Thread.sleep(1000);

      lastGeneratedUserN= regPage.lastGeneratedUsername;
      LoginPage login =  new LoginPage(driver);
      login.PerformLogin(lastGeneratedUserN, Password);
      Thread.sleep(1000);
      driver.switchTo().alert().accept();

      home.SearchCity(SearchCity);
      home.AssertAutoCompleteText(SearchCity);
      home.SelectCity(SearchCity);
      Thread.sleep(1000);

      AdventurePage adPage = new AdventurePage(driver);
      adPage.SetFilterValue();
      adPage.SetCategoryValue();
      Thread.sleep(500);
      adPage.selectAdventure();

      AdventureDetailsPage detailsPage = new AdventureDetailsPage(driver);
      detailsPage.BookAdventure(GuestName, Date, count);

      detailsPage.isBookingSuccessful();

      HistoryPage hisPage = new HistoryPage(driver);
      hisPage.GetReservations();
      Thread.sleep(1000);
      hisPage.transectionId();
      Thread.sleep(1000);

      hisPage.CancelReservation();
      Thread.sleep(1000);
      home.LogoutUser(); 
      
    }
}
