package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.JsonReader;

public class EndToEndTest extends BaseTest {

    String username = JsonReader.getTestData("username");
    String password = JsonReader.getTestData("password");
    String product = JsonReader.getTestData("product");

    @Test
    public void testEndToEndPurchaseFlow() {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(username,password);

        HomePage homePage = new HomePage(driver);
        homePage.addProductToCart(product);
        homePage.gotToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.verifyCartProduct(product));
        cartPage.goToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterFirstName(JsonReader.getTestData("firstName"));
        checkoutPage.enterLastName(JsonReader.getTestData("lastName"));
        checkoutPage.enterPostalCode(JsonReader.getTestData("postalCode"));
        checkoutPage.goToOrderPage();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.completeOrder();

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String message = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(message.equalsIgnoreCase("Thank you for your order!"));
    }

}
