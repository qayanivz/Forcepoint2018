package com.forcepoint.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {

	static ExtentHtmlReporter reporter;
	static ExtentReports extent;
	
	
	public static ExtentReports getInstance() {

		if (extent == null) {

			reporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//target//Reports//extent.html");			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}

		return extent;

	}

}
