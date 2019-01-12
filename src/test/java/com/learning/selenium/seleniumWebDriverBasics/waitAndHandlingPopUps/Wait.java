package com.learning.selenium.seleniumWebDriverBasics.waitAndHandlingPopUps;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Wait {
	
	/* Wait implicitly for a certain amount of time, if element is not found. */
	@Test
	public void implicitWait() {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://toolsqa.wpengine.com/automation-practice-form");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
	
	/* Fluent wait can define maximum amount of time to wait for a condition
	 * and 
	 * frequency with which to check the condition before throwing "No such element found exception"
	 */
	@Test
	public void fluentWait() {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://softwaretestingplace.blogspot.com/2017/02/selenium-fluent-wait.html");
		driver.findElement(By.xpath("//*[@id='post-body-5280210221385817166']/div[1]/button")).click();
		
		@SuppressWarnings("deprecation")
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply (WebDriver driver) {
				WebElement element = driver.findElement(By.xpath("//*[@id=\"demo\"]"));
				String getTextOnPage = element.getText();
				if(getTextOnPage.equals("Software Testing Material - DEMO PAGE")){
					System.out.println(getTextOnPage);
					return element;
				}else{
					System.out.println("FluentWait Failed");
					return null;
				}
			}
		});
		driver.quit();
		
	}
	
	/* Condition which is expected to evaluate something further
	 */
	@Test
	public void webDriverWait() {
		WebDriver driver = null;
		WebDriverWait wait = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://softwaretestingplace.blogspot.com/2017/02/selenium-fluent-wait.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='post-body-5280210221385817166']/div[1]/button")));
		Assert.assertTrue(true, "Element is Clickable :-)");
		driver.findElement(By.xpath("//*[@id='post-body-5280210221385817166']/div[1]/button")).click();
		driver.quit();
		
	}
	
	/*Page load time out - amount of time to load a page
	 * and
	 * script timeout - amount of time for asynchrnous script
	 */
	@Test
	public void pageLoadAndScriptTimeout() {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://softwaretestingplace.blogspot.com/2017/02/selenium-fluent-wait.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS); // page load time out
		driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);	// script time out
	}
}
