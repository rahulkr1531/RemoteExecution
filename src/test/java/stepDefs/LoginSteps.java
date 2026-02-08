package stepDefs;

import Utility.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.Login;

public class LoginSteps {

    Login login;
    private WebDriver driver = DriverFactory.getDriver();

    @Given("Launch the app")
    public void launchTheApp() throws InterruptedException {
//        driver = DriverFactory.getDriver();
//        driver.get(Constants.url);
//        driver.manage().deleteAllCookies();
//        driver.manage().window().maximize();

    }

    @Given("Login to the app")
    public void logIn() throws InterruptedException {
        Thread.sleep(5000);
        login = new Login(driver);
        login.login();
    }
    @Given("Verify title")
    public void verifyTitle() throws InterruptedException {
        Thread.sleep(5000);
        login = new Login(driver);
        login.login();
    }

    @Given("Search products on page")
    public void searchThePage(DataTable dataTable) {
        login = new Login(driver);
        login.searchPage(dataTable);
    }

    @Given("Navigate to the Site")
    public void navigateToSite() throws InterruptedException {
        login = new Login(driver);
        login.titleTest();
    }
}
