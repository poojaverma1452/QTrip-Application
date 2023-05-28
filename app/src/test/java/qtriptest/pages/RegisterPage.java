package qtriptest.pages;

import java.util.UUID;
import org.apache.logging.log4j.core.layout.SyslogLayout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    public String lastGeneratedUsername = "";
    public WebDriver driver;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(name = "email")
    WebElement emailID;

    @FindBy(name="password")
    WebElement userPws;
    
    @FindBy(name="confirmpassword")
    WebElement userConfirmPws;

    @FindBy(xpath="//button[@type='submit']")
    public 
    WebElement regButton;

    String test_data_username;
    public void RegisterNewUser(String userName, String password, boolean generateRandomUsername) throws InterruptedException {
        
        if(generateRandomUsername == true){
            test_data_username = userName + UUID.randomUUID().toString();
        }else{
            test_data_username = userName;
        }
        // WebDriverWait wait = new WebDriverWait(driver, 30);
        // wait.until(ExpectedConditions.invisibilityOf(emailID));
        emailID.sendKeys(test_data_username);
        Thread.sleep(100);
        // wait.until(ExpectedConditions.invisibilityOf(userPws));
        userPws.sendKeys(password);
        Thread.sleep(100);
        // wait.until(ExpectedConditions.invisibilityOf(userConfirmPws));
        userConfirmPws.sendKeys(password);
        Thread.sleep(100);

        lastGeneratedUsername = test_data_username;
        Thread.sleep(100);
        // wait.until(ExpectedConditions.elementToBeClickable(regButton));
        regButton.click();
        System.out.println("Clicked on reg button to reg the qtrip");
    }

}
