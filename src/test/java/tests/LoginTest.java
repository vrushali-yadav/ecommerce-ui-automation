package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() throws InterruptedException {
        String validUsername = "standard_user";
        String validPassword = "secret_sauce";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(validUsername,validPassword);
        Thread.sleep(1000);
    }

}
