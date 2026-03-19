package TestNg;

import Utility.Constants;
import Utility.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class Test {

    @org.testng.annotations.Test
    void remoteTest() throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver();
        driver.get(Constants.url1);
         Actions actions = new Actions(driver);
        List<WebElement> elements = driver.findElements(By.cssSelector("select#country option"));
        WebElement select = driver.findElement(By.cssSelector("select#country"));
//         for (WebElement e: elements) {
//             if (e.getText().equals("India")){
//                 actions.sendKeys(Keys.ENTER).perform();
////                 e.click();
//                 break;
//             }
//             actions.moveToElement(e).sendKeys(Keys.ARROW_DOWN).perform();
//
//         }
         Thread.sleep(5000);

    }
}

class A12 {
    A12(int t1) {
        System.out.println("A");
    }
}

class B1 extends A12 {
    B1(int t) {
        super(2);
        System.out.println("B");
    }

    public static void main(String[] args) {
        new B1(10);

         Actions actions = new Actions(DriverFactory.getDriver());

         HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
//         Map<Object, Object> objectObjectMap = Map.ofEntries(stringIntegerHashMap);
        List<String> list = new ArrayList<>();
        list.add("Java");

        Employee emp = new Employee("Rahul", list);

        emp.getSkills().add("Selenium");

    }

}

final class Employee {

    private final String name;
    private final List<String> skills;

    public Employee(String name, List<String> skills) {
        this.name = name;
        this.skills = new ArrayList<>(skills);  // defensive copy
    }

    public String getName() {
        return name;
    }



    public List<String> getSkills() {
        return new ArrayList<>(skills);         // return copy
    }
}
