package qtriptest.tests;

import org.openqa.selenium.WebDriver;

public class BaseClass {

    String url="https://qtripdynamic-qa-frontend.vercel.app/";

    public void navigateToHome(WebDriver driver){
        System.out.println("Navigate to Home Page of QTrip");
        driver.get(url);
    }
}
