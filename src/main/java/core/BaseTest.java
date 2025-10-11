package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


public class BaseTest {

    public WebDriver driver;

    DriverManager driverManager = new DriverManager();

    @BeforeMethod
    public void setUp() {
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driverManager.quitDriver();
    }
}
