package com.learning.selenium.seleniumWebDriverBasics.waitAndHandlingPopUps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HandlingIframes {
	
	@Test
	public void handleFrames() {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\vinay\\Downloads\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame("a077aa5e");
		driver.findElement(By.xpath("html/body/a/img")).click();
		driver.quit();
	}
}
