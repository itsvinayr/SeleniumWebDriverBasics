package com.learning.selenium.seleniumWebDriverBasics.javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class UsingJavaScriptExecutor {
	
	@Test
	public void testJavaScript() throws InterruptedException {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\vinay\\Downloads\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		System.out.println("Page is about to get refresh ... ");
		jsExecutor.executeScript("history.go(0)");
		Thread.sleep(5000L);
		System.out.println("Page refreshed successfully .. ");
		driver.quit();
	}

}
