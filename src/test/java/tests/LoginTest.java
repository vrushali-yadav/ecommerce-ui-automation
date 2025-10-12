package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JsonReader;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginWithValidCredentials() throws InterruptedException {
        String username = JsonReader.getTestData("username");
        String password = JsonReader.getTestData("password");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(username,password);
        Thread.sleep(1000);
    }

}
