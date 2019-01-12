package com.learning.selenium.seleniumWebDriverBasics.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class UsingLog4J {
	
	private WebDriver driver = null;
	private static Logger Log = Logger.getLogger(UsingLog4J.class.getName());
	
	@Test
	public void testLog4j() {
		DOMConfigurator.configure("log4j.xml");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		Log.info("System property set to gecko driver");
		driver = new FirefoxDriver();
		Log.info("driver instantiated");
		driver.close();
		Log.info("driver closed");
	}

}
