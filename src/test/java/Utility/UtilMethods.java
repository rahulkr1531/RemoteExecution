package Utility;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

public class UtilMethods {

    public static By getByFromWebElement(WebElement element) {
        String text = element.toString();
        System.out.println(text);
        try {
            String locator = text.substring(text.indexOf("->") + 3, text.lastIndexOf("]")).trim();
            String locatorType = locator.split(": ")[0].trim();
            String locatorValue = locator.split(": ")[1].trim();
            switch (locatorType) {
                case "id":
                    return By.id(locatorValue);
                case "name":
                    return By.name(locatorValue);
                case "xpath":
                    return By.xpath(locatorValue);
                case "css selector":
                    return By.cssSelector(locatorValue);
                case "class name":
                    return By.className(locatorValue);
                case "tag name":
                    return By.tagName(locatorValue);
                case "link text":
                    return By.linkText(locatorValue);
                case "partial link text":
                    return By.partialLinkText(locatorValue);
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to extract locator from WebElement.toString(): " + text);
        }
        return null;
    }

    public static void clickElement(WebDriver driver, String xpath) {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT))
                .pollingEvery(Duration.ofMillis(Constants.POLLING))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
    }
    public static void clickElement(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT))
                .pollingEvery(Duration.ofMillis(Constants.POLLING))
                .ignoreAll(Arrays.asList(NoSuchElementException.class, StaleElementReferenceException.class))
                .until(ExpectedConditions.visibilityOfElementLocated( getByFromWebElement(element))).click();
    }

    public static void enterText(WebDriver driver, String xpath, String value) {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT))
                .pollingEvery(Duration.ofMillis(Constants.POLLING))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).sendKeys(value);
    }
    public static void enterText(WebDriver driver, WebElement element, String value) {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT))
                .pollingEvery(Duration.ofMillis(Constants.POLLING))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(getByFromWebElement(element))).sendKeys(value);
    }

    public static WebElement waitForElementVisible(WebDriver driver, String xpath ) {
        return new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT))
                .pollingEvery(Duration.ofMillis(Constants.POLLING))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static WebElement waitForElementClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT))
                .pollingEvery(Duration.ofMillis(Constants.POLLING))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForElementInvisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT))
                .pollingEvery(Duration.ofMillis(Constants.POLLING))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static WebElement waitForPresence(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT))
                .pollingEvery(Duration.ofMillis(Constants.POLLING))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
