package com.learning.selenium.seleniumWebDriverBasics.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UsingParameters {
	
	@Parameters({"Browser"})
	@Test
	public void openBrowser(String browserName) {
		System.out.println("Browser name is "+browserName);
	}

}
