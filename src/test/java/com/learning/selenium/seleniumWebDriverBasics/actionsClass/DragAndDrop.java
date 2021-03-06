package com.learning.selenium.seleniumWebDriverBasics.actionsClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {

	@Test
	public void testDragAndDrop() throws InterruptedException {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		String URL = "http://www.dhtmlx.com/docs/products/dhtmlxTree/index.shtml";
		 
		driver.get(URL);
		 
		// It is always advisable to Maximize the window before performing DragNDrop action
		 
		driver.manage().window().maximize();
		 
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		 
		WebElement From = driver.findElement(By.xpath("//*[@id=\"treebox1\"]/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
		 
		WebElement To = driver.findElement(By.xpath("//*[@id=\"treebox2\"]/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
		 
		Actions builder = new Actions(driver);
		 
		Action dragAndDrop = builder.clickAndHold(From)
		 
		.moveToElement(To)
		 
		.release(To)
		 
		.build();
		 
		dragAndDrop.perform();
		
		Thread.sleep(50000L);
		
		driver.quit();
	}
		 
}
