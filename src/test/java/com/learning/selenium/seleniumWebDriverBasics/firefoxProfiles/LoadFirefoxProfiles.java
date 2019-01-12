package com.learning.selenium.seleniumWebDriverBasics.firefoxProfiles;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.Test;

@SuppressWarnings("deprecation")
public class LoadFirefoxProfiles {
	
	@Test
	public void test() {
		
		// Make sure to create firefox profile xyzprofile		
		ProfilesIni profiles = new ProfilesIni();
		FirefoxProfile myProfile = profiles.getProfile("default");
		@SuppressWarnings("unused")
		WebDriver driver = new FirefoxDriver((Capabilities) myProfile);
		
	}
}
