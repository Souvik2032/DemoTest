package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.base.BaseClass;
import com.pages.LoginPage;
import com.utility.ScreenshotUtility;

public class LoginTest extends BaseClass {

	@Test(priority = 1)
	public void verifyLogin() {

		ExtentTest test = extent.createTest("Valid Login Test");

		LoginPage lp = new LoginPage(driver);

		lp.enterUsername("student");
		test.info("Entered Username");

		lp.enterPassword(rc.getPassword());
		test.info("Entered Password");

		lp.clickLogin();
		test.info("Clicked Login Button");

		String actualMessage = lp.getSuccessMessage();

		Assert.assertEquals(actualMessage, "Logged In Successfully");

		if (rc.isScreenshotEnabled()) {

			String path = ScreenshotUtility.takeScreenshot(
					driver,
					"LoginSuccess",
					rc.getScreenshotPath());

			test.pass(
					"Login Successful",
					MediaEntityBuilder
							.createScreenCaptureFromPath(path)
							.build());

		} else {

			test.pass("Login Successful");

		}

		lp.clickLogout();

		test.info("Logged out Successfully");
	}

	@Test(priority = 2)
	public void verifyInvalidLogin() {

		driver.get(rc.getUrl());

		ExtentTest test = extent.createTest("Invalid Login Test");

		LoginPage lp = new LoginPage(driver);

		lp.enterUsername("student");
		test.info("Entered Username");

		lp.enterPassword(rc.getInvalidPassword());
		test.info("Entered Password");

		lp.clickLogin();
		test.info("Clicked Login Button");

		String actualError = lp.getErrorMessage();

		Assert.assertTrue(
				actualError.contains("Your password is invalid!"));

		if (rc.isScreenshotEnabled()) {

			String path = ScreenshotUtility.takeScreenshot(
					driver,
					"LoginUnSuccess",
					rc.getScreenshotPath());

			test.pass(
					"Invalid Login Verified",
					MediaEntityBuilder
							.createScreenCaptureFromPath(path)
							.build());

		} else {

			test.pass("Invalid Login Verified");

		}
	}
}