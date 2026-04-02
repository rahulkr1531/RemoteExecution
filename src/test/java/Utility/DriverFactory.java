package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static DriverFactory instance;

    private DriverFactory() {
    }

    private WebDriver initDriver() {
        String browser = System.getProperty("browser");
        if (browser == null || browser.isEmpty()) {
            browser = DataUtil.getPropValue("browser");
        }
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(DataUtil.getPropValue("gridRun"))) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
            try {
                tlDriver.set(new RemoteWebDriver(new URL(Constants.gridUrl), options));
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else {
            if (tlDriver.get() == null) {
                switch (browser.toUpperCase()) {
                    case "CHROME" -> {
                        WebDriverManager.chromedriver().setup();
                        tlDriver.set(new ChromeDriver());
                    }
                    case "EDGE" -> {
                        WebDriverManager.edgedriver().setup();
                        tlDriver.set(new EdgeDriver());
                    }
                    default -> throw new IllegalArgumentException("Browser not supported: " + browser);
                }
            }
        }
        return tlDriver.get();
    }

    public static synchronized WebDriver getDriver() {
        if (instance == null)
            instance = new DriverFactory();
        return instance.initDriver();
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
