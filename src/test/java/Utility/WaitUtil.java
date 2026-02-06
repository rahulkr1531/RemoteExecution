package Utility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utility.DriverFactory.getDriver;

public class WaitUtil {

    public void explicitWait() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(40));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("x")));

        wait.until(driver -> {
            try {
                driver.findElement(By.cssSelector("css")).click();
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        });
    }

    public void fluentWait() {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofDays(500))
                .ignoring(ElementClickInterceptedException.class);

        WebElement element = fluentWait.until(driver -> {
            return driver.findElement(By.id("x"));
        });
    }

}
