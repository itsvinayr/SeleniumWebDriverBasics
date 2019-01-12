package com.learning.selenium.seleniumWebDriverBasics.mouseScrolls;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ScrollElementIntoView {
	
	@Test
	public void testScrollElementIntoView() {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		JavascriptExecutor jexec = (JavascriptExecutor)driver;
		jexec.executeScript("document.getElementById('text-8').scrollIntoView(true);");
		driver.quit();
	}
	
	@Test
	public void testScrollWebPage() {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		JavascriptExecutor jexec = (JavascriptExecutor)driver;
		// scroll by pixels
		jexec.executeScript("window.scrollBy(0,1000)");
		
		// scroll the page till element is visible
        WebElement Element = driver.findElement(By.linkText("Linux"));

        //This will scroll the page till the element is found		
        jexec.executeScript("arguments[0].scrollIntoView();", Element);
		driver.quit();
	}

}
