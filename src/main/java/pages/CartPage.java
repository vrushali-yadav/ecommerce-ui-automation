package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cart_item_label .inventory_item_name")
    List<WebElement> cartItems;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public boolean verifyCartProduct(String product) {
        return cartItems.stream().anyMatch(item -> item.getText().equals(product));
    }

    public void goToCheckout() {
        checkoutButton.click();
    }

}
