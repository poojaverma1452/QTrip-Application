package qtriptest.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdventurePage {
    public WebDriver driver;
    public AdventurePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//select[@name='duration']")
    WebElement hoursSelect;

    @FindBy(xpath="//select[@id='category-select']")
    WebElement addCategory;

    @FindBy(xpath="//div[@onclick='clearDuration(event)']")
    WebElement durationButton;

    @FindBy(xpath="//div[@onclick='clearCategory(event)']")
    WebElement clearCategory;

    @FindBy(xpath="//*[@id='data']")
    List<WebElement> getResultCount;

    @FindBy(xpath="//h5[text()='Duration']")
    WebElement clickAdventure;

    @FindBy(xpath="//*[@id='data']/div/a/div[2]/div/div[1]/h5")
    List<WebElement> adventureContent;

    public void SetFilterValue() throws InterruptedException{
        Select dropDown = new Select(hoursSelect);
        dropDown.selectByIndex(2);
        System.out.println("selected value by index from hoursSelect");
        Thread.sleep(500);
    }

    

    public void SetCategoryValue() throws InterruptedException{
        Select dropDown = new Select(addCategory);
        dropDown.selectByIndex(1);
        System.out.println("selected value by index for addCategory");
        Thread.sleep(500);
    }
   
    public void clearData() throws InterruptedException{
        durationButton.click();
        Thread.sleep(1000);
        clearCategory.click();
        Thread.sleep(1000);
    }

    public void getResultCount(){
        getResultCount.size();
        System.out.println("Size of the content "+getResultCount.size());
    }
    
    public void selectAdventure() throws InterruptedException{
        try {
            clickAdventure.click();
            Thread.sleep(1000);
        }catch(Exception e){
            System.out.println("There is no adventure displayed");
        }
    }

    public void searchAdvanture(String AdventureName){
        try{
            for(WebElement AdveName:adventureContent){
                if(AdveName.getText().contains(AdventureName)){
                    AdveName.click();
                    Thread.sleep(1000);
                    System.out.println("I have search adventure");
                }
            }
        }catch(Exception e){
            System.out.println("Adventure list are not displaying");
        }

        
    }
}


