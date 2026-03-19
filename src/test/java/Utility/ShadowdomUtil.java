package Utility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ShadowdomUtil {

    private static WebDriver driver = DriverFactory.getDriver();

    public static WebElement getShadowDom(List<By> shadowDomElementLocators, By targetElement) {
        SearchContext context = driver;
        for (int i = 0; i < shadowDomElementLocators.size(); i++) {
            context = context.findElement(shadowDomElementLocators.get(i)).getShadowRoot();
        }
        return context.findElement(targetElement);
    }
}

class ShadowDomUtil {

    public static WebElement waitForShadowElement(
            WebDriver driver,
            List<By> path,
            Duration timeout) {

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(timeout)
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);

        return wait.until(new Function<>() {
            @Override
            public WebElement apply(WebDriver d) {
                SearchContext context = d;
                WebElement element = null;

                for (By by : path) {
                    element = context.findElement(by);
                    context = element.getShadowRoot();
                }
                return element;
            }
        });
    }
}