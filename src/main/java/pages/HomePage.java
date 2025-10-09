package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    public void launchPage(){
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    public void loginToApplication(String uname, String pwd) {
        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginButton.click();
    }

}
