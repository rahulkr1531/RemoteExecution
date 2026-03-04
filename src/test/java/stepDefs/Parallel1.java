package stepDefs;

import Hooks.Hooks;
import io.cucumber.java.en.Given;

public class Parallel1 {

    private Hooks hooks;

    public Parallel1(Hooks hooks) {
        this.hooks = hooks;

//        System.out.println(">>> Constructor of Feature1Steps");
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

    @Given("I run feature 1 step")
    public void runFeature1Step() {
        printThreadDetails("Feature1 Step Execution");
    }
}