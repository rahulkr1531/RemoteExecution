package Utility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class ShadowdomUtil {

    public static SearchContext getShadowDom(String cssPath) {

        return DriverFactory.getDriver().findElement(By.cssSelector(cssPath)).getShadowRoot();
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