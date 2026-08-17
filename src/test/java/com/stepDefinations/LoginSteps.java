package com.stepDefinations;

import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.base.BaseClass;
import com.pages.LoginPage;
import com.utility.ScreenshotUtility;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass {

	LoginPage lp;

	@When("User enters username {string}")
	public void user_enters_username(String username) {

		lp = new LoginPage(driver);

		lp.enterUsername(username);

		test.info("Entered Username : " + username);

	}

	@When("User enters password {string}")
	public void user_enters_password(String passwordType) {

		if (passwordType.equalsIgnoreCase("valid")) {

			lp.enterPassword(rc.getPassword());

			test.info("Entered Valid Password");

		} else {

			lp.enterPassword(rc.getInvalidPassword());

			test.info("Entered Invalid Password");

		}
	}

	@When("User clicks Login Button")
	public void user_clicks_login_button() {

		lp.clickLogin();

		test.info("Clicked Login Button");

	}

	@Then("User should see {string}")
	public void user_should_see(String expectedResult) {

		try {

			if (expectedResult.equals("Logged In Successfully")) {

				String actualMessage =
						lp.getSuccessMessage();

				Assert.assertEquals(
						actualMessage,
						expectedResult);

			} else {

				String actualError =
						lp.getErrorMessage();

				Assert.assertTrue(
						actualError.contains(
								expectedResult));

			}

			if (rc.isScreenshotEnabled()) {

				String path =
						ScreenshotUtility.takeScreenshot(
								driver,
								"ScenarioPass",
								rc.getScreenshotPath());

				test.pass(
						"Scenario Passed",
						MediaEntityBuilder
								.createScreenCaptureFromPath(path)
								.build());

			} else {

				test.pass("Scenario Passed");

			}

		} catch (Exception e) {

			test.fail(
					"Scenario Failed : "
							+ e.getMessage());

			throw e;

		}
	}
}