
package qtriptest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdventureDetailsPage {
    WebDriver driver;
    public AdventureDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='name']")
    WebElement enterName;

    @FindBy(xpath="//input[@type='date']")
    WebElement date;

    @FindBy(xpath="//input[@type='number']")
    WebElement personNo;

    @FindBy(xpath="//button[@type='submit']")
    WebElement reserveButton;

    @FindBy(xpath = "//*[@id='adventure-subtitle']")
    WebElement successBook;

    public void BookAdventure(String GuestName, String Date, String count) throws InterruptedException{
        try{
         enterName.sendKeys(GuestName);
         Thread.sleep(500);
         date.sendKeys(Date);
         personNo.clear();
         personNo.sendKeys(count);
         Thread.sleep(1000);
         reserveButton.click();
         Thread.sleep(1000);
        }catch(Exception e){
            System.out.println("reservation page is not avilable for this adventure");
        }
    }

    public void isBookingSuccessful(){
        try {
            if(successBook.getText().contains("This is a mind-blowing adventure!")){
           System.out.println("Reservation is Successful");
           Thread.sleep(1000);
            } else{
                System.out.println("Reservation is not successful");
            }
        } catch (Exception e) {
            System.out.println("Reservation Page is not there");
        }
    }
}
