package Hooks;

import Utility.Constants;
import Utility.DriverFactory;
import Utility.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;


public class Hooks {



    private static ExtentReports extent = ExtentManager.getExtent();
    private static ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();

    @Before
    public void setUp(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();
        ExtentTest test = extent.createTest(scenario.getName());
        scenarioTest.set(test);
        driver.get(Constants.url3);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
//        if (scenario.isFailed()){
//            scenarioTest.get().log(Status.FAIL,"test failed");
//        }
//        if (scenario.isFailed()) {
//            String path = ScreenshotFactory.attachScreenshot(
//                    DriverFactory.getDriver()
//            );
//            scenarioTest.get()
//                    .fail("Scenario failed")
//                    .addScreenCaptureFromPath(path);
//        }
       DriverFactory.quitDriver();
    }

//    @AfterAll
//    public static void flushReport() {
//        extent.flush();
//    }


}
