package com.learning.selenium.seleniumWebDriverBasics.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserNavigationCommands {
	
	@Test
	public void navigationCommands() {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\vinay\\Downloads\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.indianrail.gov.in/enquiry/PNR/PnrEnquiry.html?locale=en");
		System.out.println("Title of the page is : ---> "+driver.getTitle());
		System.out.println("Current URL is : ---> "+driver.getCurrentUrl());
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/div[1]/h4/a")).click();
		driver.findElement(By.xpath("//*[@id=\"collapse1\"]/ul/li[1]/a")).click();
		System.out.println("Current URL is : ---> "+driver.getCurrentUrl());
		driver.navigate().back();
		System.out.println("Current URL is : ---> "+driver.getCurrentUrl());
		driver.navigate().forward();
		System.out.println("Current URL is : ---> "+driver.getCurrentUrl());
		driver.navigate().to("http://amazon.com");
		System.out.println("Current URL is : ---> "+driver.getCurrentUrl());
		driver.navigate().refresh();
		driver.close();
	}

}
