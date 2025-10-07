package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class StandAloneTest {

    public static void main(String[] args) {
        String url = "https://www.saucedemo.com/";
        String validUsername = "standard_user";
        String validPassword = "secret_sauce";
        String productName = "Sauce Labs Bolt T-Shirt";


        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("profile.credentials_enable_service", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get(url);
        driver.findElement(By.id("user-name")).sendKeys(validUsername);
        driver.findElement(By.id("password")).sendKeys(validPassword);
        driver.findElement(By.id("login-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item")));
        List<WebElement> items = driver.findElements(By.className("inventory_item"));
        WebElement product = items.stream().filter(item ->
                item.findElement(By.cssSelector(".inventory_item_name"))
                        .getText().equals(productName)).findFirst().orElse(null);
        product.findElement(By.cssSelector("[data-test^='add-to-cart']")).click();

        driver.findElement(By.className("shopping_cart_link")).click();
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".cart_item_label .inventory_item_name"));
        boolean isPresent = cartItems.stream().anyMatch(item -> item.getText().equals(productName));
        Assert.assertTrue(isPresent);
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.name("firstName")).sendKeys("Vrushali");
        driver.findElement(By.name("lastName")).sendKeys("Yadav");
        driver.findElement(By.name("postalCode")).sendKeys("L8T 3A6");
        driver.findElement(By.id("continue")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        driver.findElement(By.id("finish")).click();

        String confirmMessage = driver.findElement(By.xpath("//*[@data-test='complete-header']")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thank you for your order!"));

        driver.close();
    }

}
