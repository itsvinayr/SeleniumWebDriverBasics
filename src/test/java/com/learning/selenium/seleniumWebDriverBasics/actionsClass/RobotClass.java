package com.learning.selenium.seleniumWebDriverBasics.actionsClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RobotClass {

	@Test
	public void usingRobot() throws InterruptedException, AWTException {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		String URL = "http://spreadsheetpage.com/index.php/file/animated_color_scales/";
		 
		driver.get(URL);		 
		driver.manage().window().maximize();		 
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		 
		WebElement downLoadElement = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul/li[3]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(downLoadElement).contextClick().build().perform();
		
		Robot robot = new Robot();
		Thread.sleep(2000L);
		for(int i=0; i<5; i++) {
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(5000L);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(5000L);
		robot.keyPress(KeyEvent.VK_ENTER);
	}		 
}
