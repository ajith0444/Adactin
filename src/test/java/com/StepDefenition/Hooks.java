package com.StepDefenition;

import java.io.File;

import com.BaseClass.BaseClassV2;
import com.cucumber.listener.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseClassV2 {

	@Before //This is cucumber.api.java not the org.junit
	public void beforeHooks() throws Exception {
		System.out.println("Before Hook");
		getUrl("http://adactin.com/HotelApp/index.php");
	}
	
	@After //This is cucumber.api.java not the org.junit
	public void afterHook() {
		System.out.println("After hook");
		Reporter.loadXMLConfig(new File("src\\test\\resources\\extent-config.xml"));
//		Reporter.setSystemInfo("User Name", "AJ");
//		Reporter.setSystemInfo("Application Name", "Test App ");
//		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
//		Reporter.setSystemInfo("Environment", "Production");
//		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
	
}
