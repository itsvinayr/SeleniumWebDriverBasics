package com.learning.selenium.seleniumWebDriverBasics.testng;

import java.util.HashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/*
 * A factory will execute all the test methods present inside a test class using a 
 * separate instance of the respective class
 */

public class FactoryAndDataProvider {
	
	HashMap<String, String> data;
	
	@Factory(dataProvider = "personalData", dataProviderClass=DataProviderUsingExcel.class)
	public FactoryAndDataProvider(String id, String age, String profession, String experience) {
		data = new HashMap<String, String>();
		data.put("ID", id);
		data.put("Age", age);
		data.put("profession", profession);
		data.put("Experience", experience);
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("running before class ..");
	}
	
	@Test()
	public void testFactorBuilder() throws InterruptedException {
		
		System.out.println("Running : testFactorBuilder");
		System.out.println("ID "+data.get("ID")
							+"\tAge "+data.get("Age")
							+"\tProfession "+data.get("profession")
							+"\tExperience "+data.get("Experience"));
		System.out.println("Waiting...");
		Thread.sleep(5000L);
		System.out.println("Ending : testFactorBuilder");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after Class finish .. ");
	}

}
