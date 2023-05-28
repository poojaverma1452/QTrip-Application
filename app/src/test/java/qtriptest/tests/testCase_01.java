package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import qtriptest.pages.RegisterPage;
import java.net.MalformedURLException;
import com.google.common.net.UrlEscapers;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class testCase_01 {
  WebDriver driver;
  String lastGeneratedUserName = "";

  @BeforeTest(alwaysRun = true)
  public void setUp() throws MalformedURLException {
    driver = DriverSingleton.getInstanceOfSingletonBrowserClass().getDriver();
    BaseClass basetest = new BaseClass();
    basetest.navigateToHome(driver);
  }

  @Test(dataProvider = "data-provider", dataProviderClass = DP.class, description = "TestCase01",
      priority = 0, groups = {"Login Flow"})
  public void TestCase01(String userName, String password) throws InterruptedException{
    boolean status;
    // navigate to home page
    BaseClass baseClass = new BaseClass();
    baseClass.navigateToHome(driver);

    // click on the register page
    HomePage home = new HomePage(driver);
    Thread.sleep(1000);
    home.ClickRegister();

    RegisterPage regPage = new RegisterPage(driver);
    // verify reg page is displayed

    if (regPage.regButton.isEnabled()) {
      System.out.println("Reg-page is displayed");
    }

    // Enter email , Password & Confirm Password & Click on Register Now
    regPage.RegisterNewUser(userName, password, true);

    // verify login page is displayed

    LoginPage logPage = new LoginPage(driver);
    if (logPage.logButton.isEnabled()) {
      System.out.println("login-page is displayed");
    }

    // Enter the created user credentials and click on Login
    lastGeneratedUserName = regPage.lastGeneratedUsername;

    logPage.PerformLogin(lastGeneratedUserName, password);
    Thread.sleep(1000);
    driver.switchTo().alert().accept();
    System.out.println("Alert accepted");
    Thread.sleep(1000);
    // // Verify that the user is Logged in
    status = home.IsUserLogin();
    Assert.assertEquals(status, true);

    Thread.sleep(1000);
    // //Click on the Logout Button
    home.LogoutUser();
    System.out.println("clicked on loggedout");

    // Verify that user is loggedout
    if (home.userLogin.isEnabled()) {
      System.out.println("LoggedOut Successfully");
    }
  }
}

