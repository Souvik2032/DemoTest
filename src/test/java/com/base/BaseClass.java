package com.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.utility.ExtentReportManager;
import com.utility.ReadConfig;

public class BaseClass {

	public static Logger logger =
			LogManager.getLogger(BaseClass.class);

	public static WebDriver driver;

	public static ExtentReports extent;

	public static ExtentTest test;

	protected ReadConfig rc =
			new ReadConfig();

	public void setup() {

		System.out.println(
				"Project Path: "
						+ System.getProperty("user.dir"));

		System.out.println(
				"Logs Folder Path: "
						+ new java.io.File("Logs")
								.getAbsolutePath());

		extent = ExtentReportManager.getReport();

		driver = new EdgeDriver();

		logger.info(
				"Browser launched successfully");

		driver.manage().window().maximize();

		driver.manage().timeouts()
				.implicitlyWait(
						Duration.ofSeconds(10));

		driver.get(rc.getUrl());

		logger.info(
				"Application URL opened");
	}

	public void tearDown() {

		if (driver != null) {

			driver.quit();

			logger.info(
					"Closing the browser");

		}

		if (extent != null) {

			extent.flush();

		}

		logger.info(
				"Execution Completed");
	}
}