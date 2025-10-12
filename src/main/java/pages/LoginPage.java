package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PropertyReader;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
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
        String url = PropertyReader.propertyReader("config.properties","url");
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void loginToApplication(String uname, String pwd) {
        launchPage();
        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginButton.click();
    }
}
