package com.learning.selenium.seleniumWebDriverBasics.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	
	@DataProvider(name="credentials")
	public static Object[][] getCredentials(){
		return new Object[][] {{"test1","123"},{"test2","245"}};
	}
	
	@Test(dataProvider = "credentials")
	public void testCredentials(String name, String password) {
		System.out.println("Name : "+name+"\nPassword : "+password);
	}

}
