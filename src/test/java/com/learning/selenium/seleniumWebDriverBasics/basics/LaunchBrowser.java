package com.learning.selenium.seleniumWebDriverBasics.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class LaunchBrowser {

	@Test
	public void invokeFirefoxBrowser() {
		WebDriver driver = null;
		/* For selenium 3, gecko driver need to be used to invoke firefox browser */
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\vinay\\Downloads\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.quit();
	}
	
	@Test
	public void invokeChromeBrowser() {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\vinay\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.quit();
	}
	
	@Test
	public void invokeIEBrowser() {
		WebDriver driver = null;
		System.setProperty("webdriver.ie.driver", "C:\\\\Users\\vinay\\Downloads\\Drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://www.google.com");
		driver.quit();
	}

}
