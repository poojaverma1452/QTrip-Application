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
import java.rmi.registry.Registry;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testCase_04 {
  WebDriver driver;
  String lastGeneratedUserN = "";

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws MalformedURLException {
    driver = DriverSingleton.getInstanceOfSingletonBrowserClass().getDriver();
    BaseClass basetest = new BaseClass();
    basetest.navigateToHome(driver);
  }

  @Test(dataProvider = "data-provider", dataProviderClass = DP.class, description = "TestCase04",
      priority = 3, groups = {"Reliability Flow"})
  public void TestCase04(String NewUserName, String Password, String dataset1, String dataset2,String dataset3) throws InterruptedException {
    String[] allDetails1 = dataset1.split(";");
    String CityName1 = allDetails1[0];
    String AdventureName1 = allDetails1[1];
    String GuestName1 = allDetails1[2];
    String date1 = allDetails1[3];
    String count1 = allDetails1[4];

    String[] allDetails2 = dataset2.split(";");
    String CityName2 = allDetails2[0];
    String AdventureName2 = allDetails2[1];
    String GuestName2 = allDetails2[2];
    String date2 = allDetails2[3];
    String count2 = allDetails2[4];

    String[] allDetails3 = dataset3.split(";");
    String CityName3 = allDetails3[0];
    String AdventureName3 = allDetails3[1];
    String GuestName3 = allDetails3[2];
    String date3 = allDetails3[3];
    String count3 = allDetails3[4];


    BaseClass bclass = new BaseClass();
    bclass.navigateToHome(driver);

    Thread.sleep(500);
    HomePage home = new HomePage(driver);
    Thread.sleep(500);
    home.ClickRegister();

    RegisterPage regPage = new RegisterPage(driver);
    regPage.RegisterNewUser(NewUserName, Password, true);
    Thread.sleep(1000);

    lastGeneratedUserN= regPage.lastGeneratedUsername;
    LoginPage login = new LoginPage(driver);
    login.PerformLogin(lastGeneratedUserN, Password);
    Thread.sleep(1000);
    driver.switchTo().alert().accept();



    home.SearchCity(CityName1);
    home.AssertAutoCompleteText(CityName1);
    home.SelectCity(CityName1);
    Thread.sleep(1000);


    AdventurePage adPage = new AdventurePage(driver);
    AdventureDetailsPage detailsPage = new AdventureDetailsPage(driver);

    adPage.searchAdvanture(AdventureName1);
    Thread.sleep(1000);


    detailsPage.BookAdventure(GuestName1, date1, count1);
    detailsPage.isBookingSuccessful();


    bclass.navigateToHome(driver);

    home.SearchCity(CityName2);
    home.AssertAutoCompleteText(CityName2);
    home.SelectCity(CityName2);
    Thread.sleep(1000);


    adPage.searchAdvanture(AdventureName2);
    Thread.sleep(1000);


    detailsPage.BookAdventure(GuestName2, date2, count2);
    detailsPage.isBookingSuccessful();

    bclass.navigateToHome(driver);

    home.SearchCity(CityName3);
    home.AssertAutoCompleteText(CityName3);
    home.SelectCity(CityName3);
    Thread.sleep(1000);


    adPage.searchAdvanture(AdventureName3);
    Thread.sleep(1000);

    detailsPage.BookAdventure(GuestName3, date3, count3);
    detailsPage.isBookingSuccessful();

    HistoryPage hisPage = new HistoryPage(driver);
    hisPage.GetReservations();

    home.LogoutUser();

  }
}
