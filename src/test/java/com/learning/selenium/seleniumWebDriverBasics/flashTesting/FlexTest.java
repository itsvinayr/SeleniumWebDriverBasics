package com.learning.selenium.seleniumWebDriverBasics.flashTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Flash.FlashObjectWebDriver;

public class FlexTest {
	
	@Test
	public void testFlexApp() throws InterruptedException {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "myFlashMovie");
		driver.get("http://demo.guru99.com/test/flash-testing.html");
		Thread.sleep(5000);		
	  	flashApp.callFlashObject("Play");			
	  	Thread.sleep(5000);		
		flashApp.callFlashObject("StopPlay");			
		Thread.sleep(5000);		
		flashApp.callFlashObject("SetVariable","/:message","Flash testing using selenium Webdriver");
	    System.out.println(flashApp.callFlashObject("GetVariable","/:message"));
	}

}
