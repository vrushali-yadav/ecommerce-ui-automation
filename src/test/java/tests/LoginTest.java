package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {

    @Test
    public void testLoginWithValidCredentials(){
        String validUsername = "standard_user";
        String validPassword = "secret_sauce";
        LoginPage loginPage = new LoginPage(new ChromeDriver());
        loginPage.launchPage();
        loginPage.loginToApplication(validUsername,validPassword);
    }

}
