package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class AddToCartTest extends BaseTest {

    String validUsername = "standard_user";
    String validPassword = "secret_sauce";
    String product = "Sauce Labs Bike Light";

    @Test
    public void testAddProductToCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(validUsername,validPassword);
        HomePage homePage = new HomePage(driver);
        homePage.addProductToCart(product);
        Thread.sleep(1000);
    }

}
