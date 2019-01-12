package com.learning.selenium.seleniumWebDriverBasics.actionsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class UntrustedCertificates {
	
	@Test
	public void skipUntrustedCertificates() {
		System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\vinay\\Downloads\\Drivers\\geckodriver.exe");
		DesiredCapabilities capabilites = new DesiredCapabilities();
		capabilites.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		@SuppressWarnings("deprecation")
		WebDriver driver = new FirefoxDriver(capabilites);
		driver.get("https://google.com");
		driver.quit();
	}

}
