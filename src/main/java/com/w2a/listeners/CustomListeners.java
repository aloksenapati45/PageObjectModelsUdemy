package com.w2a.listeners;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.Page;
import com.w2a.utilites.Utilites;
import org.testng.*;

import java.io.IOException;

public class CustomListeners extends Page implements ITestListener {


    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = rep.startTest(iTestResult.getName().toUpperCase());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(LogStatus.PASS,iTestResult.getName().toUpperCase()+" PASS");
        rep.endTest(test);
        rep.flush();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        System.setProperty("org.uncommons.reportng.escape-output","false");
        try {
            Utilites.captureScreenshot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.log(LogStatus.FAIL,iTestResult.getName().toUpperCase()+" Failed");
        test.log(LogStatus.FAIL,test.addScreenCapture(Utilites.screenShotName));
        Reporter.log(
                "<a target='_blank' href='C:\\Users\\ALOK\\OneDrive\\Desktop\\Udemy\\DataDrivenFramework\\test-output\\html\\"
                        +Utilites.screenShotName+"'><img src='C:\\Users\\ALOK\\OneDrive\\Desktop\\Udemy\\DataDrivenFramework\\test-output\\html\\"
                        +Utilites.screenShotName+"' height='100' width='100'/> Screenshot</a>");
        rep.endTest(test);
        rep.flush();

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.log(LogStatus.SKIP,iTestResult.getName().toUpperCase()+" Skipped");
        rep.endTest(test);
        rep.flush();

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
