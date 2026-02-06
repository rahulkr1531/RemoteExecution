package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotFactory {

    public static String attachScreenshot(WebDriver driver){

        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/screenshot.png";
        File dest = new File(path);
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }
}
