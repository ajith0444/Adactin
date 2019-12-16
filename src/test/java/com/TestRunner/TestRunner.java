package com.TestRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.BaseClass.BaseClassV2;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter: src\\test\\resources\\com\\Reports\\reports.html"},
		features= {"src\\test\\java\\com\\Feature\\Adactin.feature"},
		glue= "com.StepDefenition"
		)

public class TestRunner extends BaseClassV2{
	
	@BeforeClass
	public static void driverInit() throws Throwable {
		getBrowser("chrome");
		
	}
	
	
	
	@AfterClass
	public static void driverQuit() {
		driver.quit();
	}
	
}
