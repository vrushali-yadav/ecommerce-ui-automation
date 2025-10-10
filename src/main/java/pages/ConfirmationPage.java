package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    WebDriver driver;

    public ConfirmationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
