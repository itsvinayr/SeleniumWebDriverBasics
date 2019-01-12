package com.learning.selenium.seleniumWebDriverBasics.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.learning.selenium.seleniumWebDriverBasics.log4j.UsingLog4J;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class ReportsAndAssertions {
	
	private static Logger Log = Logger.getLogger(UsingLog4J.class.getName());
	
	/*
	 * Log 4j used for low level logging
	 * Reporter used for high level logging
	 */
	
	@Test
	public void checkLoggerParameters() {
		DOMConfigurator.configure("log4j.xml");
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\vinay\\Downloads\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://google.com");
		Log.info("Web Application Launched succesfully");
		Reporter.log("Application launched successfully");
		Reporter.log("Identified table and printed all the data");
		driver.quit();
		Log.info("Browser closed");
	}
	
	@Test
	public void testAssertions() {
		Assert.assertTrue(true,"Failure");
		Assert.assertFalse(false,"Success");
		Assert.assertEquals(true, false, "Not equal");
	}

}
