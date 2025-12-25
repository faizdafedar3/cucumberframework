package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getExtent() {
        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("target/ExtentReport.html");

            reporter.config().setReportName("Automation Test Report");
            reporter.config().setDocumentTitle("Cucumber Selenium Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Framework", "Cucumber TestNG");
            extent.setSystemInfo("Author", "Faiz");
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }
}
