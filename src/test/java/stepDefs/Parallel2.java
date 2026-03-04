package stepDefs;

import Hooks.Hooks;
import io.cucumber.java.en.Given;

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
        Thread.sleep(5000);
        printThreadDetails("Feature2 Step Execution");
    }
}