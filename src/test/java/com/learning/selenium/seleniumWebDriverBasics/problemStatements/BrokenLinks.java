package com.learning.selenium.seleniumWebDriverBasics.problemStatements;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrokenLinks {
	
	@Test
	public void testBrokenLinks() throws IOException {
		WebDriver driver = null;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for(int i=0; i<allLinks.size(); i++) {
			String url = allLinks.get(i).getAttribute("href");
			verifyURL(url);
		}
		
		driver.quit();
	}
	
	public static void verifyURL(String webURL) throws IOException {
		URL url = new URL(webURL);
		HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
		connection.setConnectTimeout(3000);
		connection.connect();
		if(connection.getResponseCode()==200) {
			System.out.println(webURL+"----"+connection.getResponseMessage());
		}else {
			System.out.println(webURL+"---"+connection.getResponseMessage());
		}
	}

}
