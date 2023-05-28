
package qtriptest.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HistoryPage {
    
    public WebDriver driver;
    public HistoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//*[@id='reserved-banner']/a/strong") 
    WebElement historyPagelink;

    @FindBy(xpath= "//*[@id='reservation-table-parent']/table/tbody/tr/th//following-sibling::td//preceding-sibling::th")
    List<WebElement> transactionIdRow;

    @FindBy(xpath="//*[@id='reservation-table-parent']/table/tbody/tr/th//following-sibling::td[1]")
    List<WebElement> nameTransectionId;

    @FindBy(xpath="//*[@id='reservation-table-parent']/table/tbody/tr/th//following-sibling::td[8]")
    List<WebElement> cancelButton;

    public void GetReservations() throws InterruptedException{
        try {
            historyPagelink.click();
            System.out.println("Clicked on the reservation checking link");
            Thread.sleep(10000);
            // System.out.println("TransactionId of the reservation :" + transactionId.getText());
            
        } catch(Exception e) {
            System.out.println("There is no booked reservation");
        }
    }
    
    public void transectionId(){
        try{
            for(WebElement row :transactionIdRow){
                row.getText();
                System.out.println(row.getText());
            }
        }catch(Exception e){
            System.out.println("not displaying transectionId");
        }
    }

    public void CancelReservation() throws InterruptedException{
        try{
            for(WebElement button:cancelButton){
                button.click();
                System.out.println("cancel button has been clicked");
            }
        }catch(Exception e){
            System.out.println("There is no reservation cancel button for this city");
        }
    }
}