
package qtriptest.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
   WebDriver driver;
   // String url="https://qtripdynamic-qa-frontend.vercel.app/";

   public HomePage(WebDriver driver) {
      this.driver = driver;
     
     PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
   }

  

   @FindBy(xpath = "//*[@id='navbarNavDropdown']/ul/li[4]/a")
   WebElement reg_link;

   @FindBy(xpath = "//a[text()='Login Here']")
   public
   WebElement  userLogin;

   @FindBy(xpath = "//div[text()='Logout']")
   public
   WebElement userLogout;

   @FindBy(className = "hero-input")
   WebElement searchCity;

   @FindBy(xpath="//*[@id='results']")
   List<WebElement> selectCityName;

   @FindBy(xpath="//*[@id='results']/h5")
   WebElement cityNotFound;
   
   public void ClickRegister() throws InterruptedException{
      Thread.sleep(1000);
      System.out.println("clicked on reg page");
      try {
         reg_link.click();
      } catch (Exception e) {
         System.out.println("Not getting reg button");
      }
   }

   public boolean IsUserLogin() {
      if(userLogout.getText().equals("Logout")){
         System.out.println("user loggedIn successfully");
         return true;
      }else{
         return false;
      }
    }

   public void LogoutUser(){
    userLogout.click();
   }

   public void SearchCity(String CityName) throws InterruptedException{
      Thread.sleep(1000);
      searchCity.clear();
      searchCity.sendKeys(CityName);
      System.out.println(CityName +" is entered into the text box");
      Thread.sleep(1000);
      
      

      // for(WebElement city : selectCityName){
      //    if(city.getText().contains(CityName)){
      //       city.click();
      //       System.out.println("City name is clicked");
      //    }else{
      //       System.out.println("Unable to click on the city name");
      //    }
      // }

   }
   
   public void AssertAutoCompleteText(String CityName){
      for(WebElement city : selectCityName){
         if(city.getText().contains(CityName)){
            System.out.println("city is displayed on auto complete: "+ CityName);
         }else{
            System.out.println(CityName +":"+ cityNotFound.getText());
         }
      }
   }

   public void SelectCity(String CityName){
      for(WebElement city : selectCityName){
         if(city.getText().contains(CityName)){
           city.click();
           System.out.println(CityName+ " City name is clicked");
         }
      }
   }
}
