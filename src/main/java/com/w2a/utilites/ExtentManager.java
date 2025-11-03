package com.w2a.utilites;


import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentManager {

    public static ExtentReports extent;
    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = new ExtentReports(
                    "C:\\Users\\ALOK\\OneDrive\\Desktop\\Udemy\\PageObjectModelBasics\\test-output\\html\\extent.html", true,
                    DisplayOrder.OLDEST_FIRST);
            extent.loadConfig(new File(
                    "C:\\Users\\ALOK\\OneDrive\\Desktop\\Udemy\\PageObjectModelBasics\\src\\test\\resources\\com.w2a.extentConfig\\extent-config.xml"));
        }
        return extent;
    }

}
