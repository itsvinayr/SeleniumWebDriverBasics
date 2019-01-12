package com.learning.selenium.seleniumWebDriverBasics.autoIT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UploadFile {
	
	public WebDriver driver = null;
	public String url = "http://toolsqa.wpengine.com/automation-practice-form";
	
	@BeforeClass
	public void intialize() {
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\vinay\\Downloads\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void uploadFile() throws IOException, InterruptedException {
		driver.get(url);
		driver.findElement(By.id("photo")).click();
		Thread.sleep(5000L);
		Runtime.getRuntime().exec("C://Users//vinay//Downloads//AutoITScripts//Upload.exe");
		Thread.sleep(5000L);
	}
	
	@AfterClass
	public void closeAll() {
		driver.quit();
	}

}
