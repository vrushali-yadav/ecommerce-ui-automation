package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null)
            driver = createDriver();
        return driver;
    }

    public WebDriver createDriver() {

        // This setup is for Chrome driver
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("profile.credentials_enable_service", false);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
