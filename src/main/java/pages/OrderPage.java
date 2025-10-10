package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
    WebDriver driver;

    public OrderPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
