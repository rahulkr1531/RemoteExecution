package pages;

import Utility.Constants;
import Utility.UtilMethods;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Login extends UtilMethods {
    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(name = "username")
    private WebElement username;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement login;
    @FindBy(xpath = "//img[@class='xbh8q5q x1pwv2dq xvlca1e']")
    private WebElement profilePicture;
    @FindBy(xpath = "//a[contains(@href,'logout')]")
    private WebElement logout;
    @FindBy(xpath = "//*[contains(@id,'Wikipedia1_wikipedia-search-input')]")
    private WebElement enterProduct;
    @FindBy(xpath = "//*[contains(@class,'wikipedia-search-button')]")
    private WebElement searchButton;
    @FindBy(xpath = "//*[contains(text(),'Home')]")
    private WebElement homePage;


    public void login() {
        username.sendKeys(Constants.username);
        password.sendKeys(Constants.password);
        login.click();
        profilePicture.click();
        logout.click();
    }

    public void searchPage(DataTable dataTable) {
        Assert.assertTrue(false);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(
                "Thread Name: " + Thread.currentThread().getName()
                        + " | Thread ID: " + Thread.currentThread().getId()
        );
        List<List<String>> dataListOfList = dataTable.asLists();
        for (List<String> list : dataListOfList) {
            enterText(driver,driver.findElement(By.xpath("//*[contains(@id,'Wikipedia1_wikipedia-search-input')]")), list.get(0));
            clickElement(driver,searchButton);
            clickElement(driver,homePage);
        }
//        Assert.assertTrue(driver.getTitle().contains("Automation"));
//        System.getProperty("","");
    }

    public void titleTest() {
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("google"));
    }
}
