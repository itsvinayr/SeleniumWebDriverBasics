package com.learning.selenium.seleniumWebDriverBasics.actionsClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ScreenShot {
	
	@Test
	public void takeScreenshot() throws IOException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\"
												+System.currentTimeMillis()+".png");
		FileUtils.copyFile(src, dest);
		driver.quit();
	}

}
