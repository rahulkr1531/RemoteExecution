package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefs", "Hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report-test2.html",
                "json:target/cucumber-test2.json"
        },
        tags = "@Test2"
)
public class TestRunner2 extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


//    @BeforeClass()
//    @Parameters("enableRetry")
//    public void setUpRetryFlag(String enableRetry){
//        System.setProperty("enableRetry", enableRetry);
//    }

}