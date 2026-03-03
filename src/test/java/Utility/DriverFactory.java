package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static DriverFactory instance;

    private DriverFactory() {
    }


    private WebDriver initDriver(String browser) {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setPlatform(Platform.WIN11);
//        desiredCapabilities.setBrowserName("chrome");

//        ChromeOptions options = new ChromeOptions();
//        options.setPlatformName("WINDOWS");
//        if (tlDriver == null) {
//            try {
//                tlDriver = new RemoteWebDriver(new URL("http://10.120.209.115:4444/wd/hub"),options);
//            } catch (MalformedURLException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return tlDriver;


        if (tlDriver.get() == null) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless=new");
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--remote-allow-origins=*");
//           options.addArguments("--window-size=1920,1080");
            tlDriver.set(new ChromeDriver(options));

//            try {
//                tlDriver.set(new RemoteWebDriver(new URL("http://10.161.103.115:4444"), options));
//            } catch (MalformedURLException e) {
//                throw new RuntimeException(e);
//            }
            switch (browser){
                case "CHROME"-> tlDriver.set(new ChromeDriver(options));
                case "EDGE"-> tlDriver.set(new EdgeDriver());
            }
        }
        return tlDriver.get();
    }

    public static WebDriver getDriver() {
        if (instance == null)
            instance = new DriverFactory();
        return instance.initDriver(DataUtil.getPropValue("browser"));
    }

    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }

}
