package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class TestConnection {
    public static void main(String[] args) {
        try {
            System.out.println("=== STARTING GRID TEST ===");

            ChromeOptions options = new ChromeOptions();
            options.setCapability("browserName", "chrome");
            options.setCapability("platformName", "Windows 11");
            options.addArguments(
                    "--start-maximized",
                    "--disable-notifications",
                    "--disable-infobars"
            );

            URL gridUrl = new URL("http://10.120.209.115:4444");
            System.out.println("Connecting to: " + gridUrl);

            WebDriver driver = new RemoteWebDriver(gridUrl, options);
            System.out.println("✅ Remote session created!");

            driver.get("https://www.google.com");
            System.out.println("Page title: " + driver.getTitle());

//            System.out.println("Browser: " + driver.getCapabilitie().getBrowserName());
//            System.out.println("Version: " + driver.getCapabilities().getBrowserVersion());
//            System.out.println("Platform: " + driver.getCapabilities().getPlatformName());

            driver.quit();
            System.out.println("=== TEST PASSED ===");

        } catch (Exception e) {
            System.err.println("=== GRID FAILED ===");
            System.err.println("Error: " + e.getClass().getSimpleName());
            System.err.println("Message: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}