package com.learning.selenium.seleniumWebDriverBasics.waitAndHandlingPopUps;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HandlingPopUps {
	
	@Test
	public void handleAlerts() {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.name("cusid")).sendKeys("53920");					
        driver.findElement(By.name("submit")).submit();
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert message "+ alert.getText());
        alert.accept();
        //alert.dismiss();
        driver.quit();
	}
	
	/*
	 * Handling unexpected alerts
	 * 
	 * DesiredCapabilities capabilities = new DesiredCapabilities();
	 * capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
	 * driver = new FirefoxDriver(capabilities);
	 * 
	 */
	
	@Test
	public void handleMultipleWindows() throws InterruptedException {
		WebDriver driver = null;
		String childHandle = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/popup.php");
		String mainWindow = driver.getWindowHandle();
		System.out.println("Main window handle : "+mainWindow+"\n Current URL : "+driver.getCurrentUrl());
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		System.out.println("Number of handles found : "+windowHandles.size());
		while(it.hasNext()) {
			childHandle = it.next();
			System.out.println("window handle : "+childHandle);
			if(childHandle.equals(mainWindow)) {
				continue;
			}else {
				driver.switchTo().window(childHandle);
				System.out.println("Switched to "+childHandle+"\n Current URL: "+driver.getCurrentUrl());
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		System.out.println("Switched to "+mainWindow+"\n Current URL: "+driver.getCurrentUrl());
		driver.close();
	}

}
