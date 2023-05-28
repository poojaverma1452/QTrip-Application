package qtriptest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
   public WebDriver driver;
   public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
   }

   @FindBy(id="floatingInput")
   WebElement username;

   @FindBy(id="floatingPassword")
   WebElement pws;

   @FindBy(xpath="//button[@type='submit']")
   public WebElement logButton;

   public void PerformLogin(String userName,String password) throws InterruptedException {
      Thread.sleep(1000);
      username.sendKeys(userName);
      Thread.sleep(200);
      pws.sendKeys(password);
      logButton.click();
      Thread.sleep(1000);
      System.out.println("click on the login button to logIn the Qkart");
   }

   
}
