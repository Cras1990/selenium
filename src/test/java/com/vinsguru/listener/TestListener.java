package com.vinsguru.listener;

import com.vinsguru.util.Constants;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        TakesScreenshot attribute = (TakesScreenshot) result.getTestContext().getAttribute(Constants.DRIVER);
        String screenshot = attribute.getScreenshotAs(OutputType.BASE64);
        String htmlImageFormat = "<img width=700px src='data:image/png;base64,%s' />";
        String htmlIMage = String.format(htmlImageFormat, screenshot);
        Reporter.log(htmlIMage);
    }
}
