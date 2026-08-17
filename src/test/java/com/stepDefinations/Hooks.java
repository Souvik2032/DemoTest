package com.stepDefinations;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	@Before
	public void beforeScenario(Scenario scenario) {

		setup();

		test = extent.createTest(
				scenario.getName());

	}

	@After
	public void afterScenario() {

		tearDown();

	}
}