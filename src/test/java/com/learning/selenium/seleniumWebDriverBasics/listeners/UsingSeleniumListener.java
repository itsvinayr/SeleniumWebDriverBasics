package com.learning.selenium.seleniumWebDriverBasics.listeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class UsingSeleniumListener {
	
	@Test
	public void getGoogleText() {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\vinay\\Downloads\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Create Event firing webdriver
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		// Create instance of your Listener
		MySeleniumListener myListener = new MySeleniumListener();
		// Now register your listener to EventFiringWebDriver
		eventDriver.register(myListener);
		eventDriver.get("http://www.google.com");
		System.out.println("Title of the page is "+eventDriver.getTitle().toString());
		String text = eventDriver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a")).getText().trim();
		System.out.println("Text is "+text);
		driver.quit();
	}

}
