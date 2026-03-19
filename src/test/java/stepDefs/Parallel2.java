package stepDefs;

import Hooks.Hooks;
import Utility.DriverFactory;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Parallel2 {

    private Hooks hooks;

    public Parallel2(Hooks hooks) {
        this.hooks = hooks;

//        System.out.println(">>> Constructor of Feature2Steps");
//        printThreadDetails("Constructor");
    }

    private void printThreadDetails(String location) {
        System.out.println(
                location +
                        " | Thread ID: " + Thread.currentThread().getId()
                        + " | Scenario Name: "+hooks.getScenarioName()

//                        + " | Thread Name: " + Thread.currentThread().getName()
        );
    }

    @Given("I run feature 2 step")
    public void runFeature2Step() throws InterruptedException {
        Assert.assertTrue(false);
//        Thread.sleep(5000);
        printThreadDetails("Feature2 Step Execution");


    }
}