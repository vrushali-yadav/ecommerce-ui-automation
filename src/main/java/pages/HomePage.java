package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inventory_item")
    List<WebElement> productList;

    By addToCartButton = By.xpath("//button[contains(@id,'add-to-cart')]");

    public WebElement getProductByName(String productName){
        WebElement prod = productList.stream()
                .filter(product -> product.findElement(By.className("inventory_item_name")).getText().equals(productName))
                .findFirst()
                .orElse(null);
        return prod;
    }

    public void addProductToCart(String productName){
        WebElement product = getProductByName(productName);
        product.findElement(addToCartButton).click();
    }

}
