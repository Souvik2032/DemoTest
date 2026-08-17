package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "Features/Login.feature",
        glue = "com.stepDefinations",
        tags = "@login",
        plugin = {"pretty"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
}