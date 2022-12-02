package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    static {
        WebDriverManager.chromedriver().setup();
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    private static void setDriver() {
        ChromeOptions options = new ChromeOptions().addArguments("headless");
        driver = new ChromeDriver(options);
        driver.manage().window().minimize();
    }

    private  static void setDriver(String arguments) {
        ChromeOptions options = new ChromeOptions().addArguments(arguments);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public void quitDriver(){

        driver.quit();
        driver = null;
    }



}
