package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefs", "Hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report-test1.html",
                "json:target/cucumber-test1.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
//                "rerun:target/failed_scenarios.txt"
        },
        tags = "@Test1"
)

public class TestRunner1 extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

//    @BeforeClass()
//    public void setUpRetryFlag(ITestContext context) {
//        String enableRetry = context.getCurrentXmlTest().getParameter("enableRetry");
//        if (enableRetry == null)
//            enableRetry = "false";
//        System.setProperty("enableRetry", (context.getCurrentXmlTest().getParameter("enableRetry") == null ?"false":"true"));
//
//    }

}