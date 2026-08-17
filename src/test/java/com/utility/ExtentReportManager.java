package com.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	public static ExtentReports getReport() {

		String timeStamp =
				new SimpleDateFormat("yyyyMMdd_HHmmss")
						.format(new Date());

		String reportPath =
				"./ExtentReports/LoginReport_"
						+ timeStamp
						+ ".html";

		ExtentSparkReporter spark =
				new ExtentSparkReporter(reportPath);

		spark.config().setReportName(
				"Login Automation Report");

		spark.config().setDocumentTitle(
				"Automation Test Report");

		ExtentReports extent =
				new ExtentReports();

		extent.attachReporter(spark);

		extent.setSystemInfo(
				"Tester",
				"Souvik");

		extent.setSystemInfo(
				"Browser",
				"Chrome");

		return extent;
	}
}

