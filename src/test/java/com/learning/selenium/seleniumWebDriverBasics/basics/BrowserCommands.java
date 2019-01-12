package com.learning.selenium.seleniumWebDriverBasics.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserCommands {
	
	@Test
	public void browserCommands() {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		System.out.println("Title of the page is : ---> "+driver.getTitle());
		System.out.println("Current URL is : ---> "+driver.getCurrentUrl());
		// System.out.println("Get Page source : ---> "+driver.getPageSource());
		// closes current windows
		driver.close();
		// closes all the windows
		// driver.quit();
	}

}
