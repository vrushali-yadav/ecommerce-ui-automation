package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "lastName")
            WebElement lastName;

    @FindBy(name = "postalCode")
            WebElement postalCode;

    @FindBy(id = "continue")
            WebElement continueOrder;

    public void enterFirstName(String fname){
        firstName.sendKeys(fname);
    }
    public void enterLastName(String lname){
        lastName.sendKeys(lname);
    }

    public void enterPostalCode(String code){
        postalCode.sendKeys(code);
    }

    public void goToOrderPage(){
        continueOrder.click();
    }

}
