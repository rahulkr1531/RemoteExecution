package Utility;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestConnection {
    static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

//    public static void main(String[] args) {
//        try {
////            System.out.println("=== STARTING GRID TEST ===");
////
////            ChromeOptions options = new ChromeOptions();
////            options.setCapability("browserName", "chrome");
////            options.setCapability("platformName", "Windows 11");
////            options.addArguments(
////                    "--start-maximized",
////                    "--disable-notifications",
////                    "--disable-infobars"
////            );
////
////            URL gridUrl = new URL("http://10.120.209.115:4444");
////            System.out.println("Connecting to: " + gridUrl);
////
////            WebDriver driver = new RemoteWebDriver(gridUrl, options);
////            System.out.println("✅ Remote session created!");
//            WebDriver driver = new ChromeDriver();
//            driver.get("https://www.google.com");
////            driver.get("https://dev.automationtesting.in/shadow-dom");
////            driver.get("https://text-compare.com/");
////            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList");
//            System.out.println("Page title: " + driver.getTitle());
//            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//
////             SearchContext shadowRoot = driver.findElement(By.id("shadow-root")).getShadowRoot();
////             WebElement element = shadowRoot.findElement(By.id("shadow-element"));
////
////             SearchContext shadowRoot1 = shadowRoot.findElement(By.id("inner-shadow-dom")).getShadowRoot();
////             SearchContext shadowRoot2 = shadowRoot1.findElement(By.id("nested-shadow-dom")).getShadowRoot();
////             WebElement element2 = shadowRoot2.findElement(By.id("multi-nested-shadow-element"));
////            WebElement element1 = shadowRoot1.findElement(By.id("nested-shadow-element"));
////
////            System.out.println(element2.getText());
//
////            System.out.println("Browser: " + driver.getCapabilitie().getBrowserName());
////            System.out.println("Version: " + driver.getCapabilities().getBrowserVersion());
////            System.out.println("Platform: " + driver.getCapabilities().getPlatformName());
//            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
//            Actions actions = new Actions(driver);
////             Thread.sleep(2000);
////            driver.findElement(By.id("inputText1")).sendKeys("whjsbiu");
////             actions.moveToElement(driver.findElement(By.id("inputText1"))).sendKeys("alkfmnaaaaa" +
////                     "sm, ccccccccccccccccccccc,msc       sc,msc ,ms c").perform();
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
////            By dropdownLocator = By.xpath("//label[text()='Job Title']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]");
////
////            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
////            dropdown.click();
////            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='AndroidDeveloper']"))).click();
////            Thread.sleep(5000);
//            driver.findElement(By.name("q")).sendKeys("selenium");
//            Thread.sleep(2000);
//             List<WebElement> elements = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
//
//             for (WebElement element:elements){
//                 System.out.println("S "+element.getText()+" E");
//             }
//            driver.quit();
//            System.out.println("=== TEST PASSED ===");
//
//        } catch (Exception e) {
//
//            System.err.println("=== GRID FAILED ===");
//            System.err.println("Error: " + e.getClass().getSimpleName());
//            System.err.println("Message: " + e.getMessage());
//            e.printStackTrace();
//            System.exit(1);
//        }
//    }

    public static void main(String[] args) {
        try {


            driver.get("https://datatables.net/examples/data_sources/ajax");
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
            List<Map<String, String>> data = new ArrayList<>();

            List<String> dataColumnName = driver.findElements(By.xpath("//table[@id='example']/thead/tr/th"))
                    .stream().map(WebElement::getText).toList();
            List<WebElement> dataRowElement = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id='example']/tbody/tr")));
            HashMap<String, String> dataMap;

            for (int i = 1; i <= dataRowElement.size(); i++) {
                dataMap = new HashMap<>();
                for (int j = 1; j <= dataColumnName.size(); j++) {
                    WebElement cell = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + i + "]/td[" + j + "]"));
                    dataMap.put(dataColumnName.get(j - 1), cell.getText());
                }
                data.add(dataMap);
                System.out.println(data.size() + "=>" + dataMap);
                if (i == dataRowElement.size()) {
                    WebElement nextButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@aria-label='Next']")));
                    if (nextButton.getAttribute("aria-disabled") != null && nextButton.getAttribute("aria-disabled").equals("true")) {
                        break;
                    }
                    nextButton.click();
                    dataRowElement = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id='example']/tbody/tr")));
                    i = 0;
                }
            }

//             for (WebElement element:elements){
//                 System.out.println("S "+element.getText()+" E");
//             }
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