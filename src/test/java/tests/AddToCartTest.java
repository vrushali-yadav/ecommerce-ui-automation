package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.JsonReader;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddProductToCart() throws InterruptedException {
        String username = JsonReader.getTestData("username");
        String password = JsonReader.getTestData("password");
        String product = JsonReader.getTestData("product");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(username,password);
        HomePage homePage = new HomePage(driver);
        homePage.addProductToCart(product);
        Thread.sleep(1000);
    }

}
