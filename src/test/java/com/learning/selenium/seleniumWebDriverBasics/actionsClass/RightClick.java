package com.learning.selenium.seleniumWebDriverBasics.actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RightClick {

	@Test
	public void testRightClick() throws InterruptedException {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		String URL = "http://only-testing-blog.blogspot.com/2014/09/selectable.html";
		 
		driver.get(URL);		 
		driver.manage().window().maximize();		 
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		 
		WebElement element = driver.findElement(By.xpath("//*[@id=\"post-body-7297556448793668582\"]/div[1]/button"));
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
		Thread.sleep(5000L);
		driver.quit();		
	}
		 
}
