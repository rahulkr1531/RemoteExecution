package Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

// if test passes in 1st run itself, retry is never called.
public class RetryAnalyzer implements IRetryAnalyzer {

    int count = 0, retryLimit = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        String retryFlag = System.getProperty("enableRetry", "false");
        System.out.println("Retry Flag: " + retryFlag);
        if (!Boolean.parseBoolean(retryFlag))
            return Boolean.parseBoolean(retryFlag);
        if (count < retryLimit) {
            count++;
            return true;
        }
        return false;
    }

}
