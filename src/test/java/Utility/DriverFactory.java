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

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(Constants.gridUrl), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }

}

//class Parent {
//    void show() throws IOException {
//        System.out.println("Parent");
//    }
//}
//
//class Child extends Parent {
//    void show() {
//        System.out.println("Child");
//    }
//}
//
//class Parent {
//    void show(Object o) {
//        System.out.println("Parent Object");
//    }
//    void show(String s) {
//        System.out.println("Parent String");
//    }
//}
//
//class Child extends Parent {
//    void show(String s) {
//        System.out.println("Child String");
//    }
//
//    void show(Integer i) {
//        System.out.println("Child Integer");
//    }
//}
//
// class Test1 {
//    public static void main(String[] args) {
//        Child obj = new Child();
////        obj.show(null);
//    }
//}

interface IA {
    default void show() { System.out.println("IA"); }
}

class Parent {
    void show() { System.out.println("Parent"); }
}

//class Child extends Parent implements IA {
//    public static void main(String[] args) {
//        new Child().show();
//    }
//}