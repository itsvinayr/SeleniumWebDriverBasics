package com.learning.selenium.seleniumWebDriverBasics.webElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDown {
	
	@Test
	public void usingSelect() throws InterruptedException {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://toolsqa.wpengine.com/automation-practice-form");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"continents\"]")));
		if(!select.isMultiple()) {
			int count = select.getOptions().size();
			System.out.println("Number of drop downs in list : "+count);
			for(int i=0; i<count; i++) {
				System.out.println("Selecting "+select.getOptions().get(i).getText()+" from drop down");
				select.selectByIndex(i);
				Thread.sleep(5000);
				System.out.println("Item selected in the drop down is "+select.getFirstSelectedOption().getText());
			}			
		}
		driver.quit();
	}
	
	@Test
	public void usingFindElementByTagname() throws InterruptedException {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://toolsqa.wpengine.com/automation-practice-form");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement dropDown = driver.findElement(By.xpath("//*[@id=\"continents\"]"));
		// Get the all the elements from the above drop down
		List<WebElement> items = dropDown.findElements(By.tagName("option"));
		System.out.println("Number of items available in the drop down : "+items.size());
		// Iterate throught he list
		for(int i=0; i<items.size(); i++) {
			System.out.println("Item "+ items.get(i).getText() + " will be selected");
			items.get(i).click();
			Thread.sleep(5000L);
		}
		driver.quit();
	}

}
