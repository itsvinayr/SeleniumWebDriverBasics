package com.learning.selenium.seleniumWebDriverBasics.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTests {
	
	@Parameters("browser")
	@Test
	public void testFirefox(String browser) throws InterruptedException {
		
		if(browser.equals("firefox")) {
			System.out.println("Waiting at firefox ...");
			Thread.sleep(50000);
		}
		
		if(browser.equals("chrome")) {
			System.out.println("Waiting at chrome ...");
			Thread.sleep(50000);
		}
		
		if(browser.equals("ie")) {
			System.out.println("Waiting at ie ...");
			Thread.sleep(50000);
		}
		
	}

}
