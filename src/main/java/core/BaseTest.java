package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    public WebDriver driver;

    DriverManager driverManager = new DriverManager();

    @BeforeTest
    public void setUp() {
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driverManager.quitDriver();
    }
}
