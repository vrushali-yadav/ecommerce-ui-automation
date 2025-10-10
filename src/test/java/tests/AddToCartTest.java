package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AddToCartTest extends BaseTest {

    String product = "Sauce Labs Bolt T-Shirt";

    @Test
    public void testAddProductToCart(){
        String validUsername = "standard_user";
        String validPassword = "secret_sauce";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(validUsername,validPassword);

    }

}
