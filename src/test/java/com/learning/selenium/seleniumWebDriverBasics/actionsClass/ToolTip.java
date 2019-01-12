package com.learning.selenium.seleniumWebDriverBasics.actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ToolTip {

	// in HTML, as an attribute title
	@Test
	public void usingHTML() throws InterruptedException {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		String URL = "http://demo.guru99.com/test/social-icon.html";
		 
		driver.get(URL);		 
		driver.manage().window().maximize();		 
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		 
		String toolTip = driver.findElement(By.xpath("//*[@id=\"top-bar\"]/div/div/div[2]/div/a[4]")).getAttribute("title");
		System.out.println("Tool tip is "+toolTip);
		driver.quit();		
	}
	
	// In div , class attribute
	@Test
	public void usingJquery() throws InterruptedException {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		String URL = "http://demo.guru99.com/test/tooltip.html";
		 
		driver.get(URL);		 
		driver.manage().window().maximize();		 
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		 
		WebElement element = driver.findElement(By.xpath("//*[@id=\"download_now\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		Thread.sleep(5000L);
		
		driver.findElement(By.xpath("//*[@id=\"demo_content\"]/div/div/div/a")).click();
		
		Thread.sleep(5000L);
		
		driver.quit();		
	}		 
}
