package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class EndToEndTest extends BaseTest {

    String validUsername = "standard_user";
    String validPassword = "secret_sauce";
    String product = "Sauce Labs Bike Light";


    @Test
    public void testEndToEndPurchaseFlow() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(validUsername,validPassword);

        HomePage homePage = new HomePage(driver);
        homePage.addProductToCart(product);
        homePage.gotToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.verifyCartProduct(product));
        cartPage.goToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterFirstName("Vrushali");
        checkoutPage.enterLastName("Yadav");
        checkoutPage.enterPostalCode("L8T 3A6");
        checkoutPage.goToOrderPage();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.completeOrder();

        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String message = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(message.equalsIgnoreCase("Thank you for your order!"));
    }

}
