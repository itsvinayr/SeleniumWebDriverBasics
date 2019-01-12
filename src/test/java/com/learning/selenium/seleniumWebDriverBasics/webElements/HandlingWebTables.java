package com.learning.selenium.seleniumWebDriverBasics.webElements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HandlingWebTables {
	
	@Test
	public void printTableData() {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\vinay\\Downloads\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-table/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement table = driver.findElement(By.xpath("//*[@id=\"content\"]/table"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(int i=0; i<rows.size(); i++) {
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			for(int j=0; j<columns.size(); j++) {
				System.out.print(columns.get(j).getText().trim()+" || ");
			}
			System.out.println();
		}
		driver.quit();
	}

}
