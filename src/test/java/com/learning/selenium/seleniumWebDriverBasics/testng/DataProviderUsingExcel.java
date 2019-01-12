package com.learning.selenium.seleniumWebDriverBasics.testng;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/*
 * A test method that uses DataProvider will be executed a multiple number of times based on the 
 * data provided by the DataProvider. The test method will be executed using the same instance of the test class 
 * to which the test method belongs.
 */

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learning.selenium.seleniumWebDriverBasics.excelUtilities.OperationsOnExcel;

public class DataProviderUsingExcel {
	
	@DataProvider(name="personalData")
	public static Object[][] getData() throws IOException{
		return OperationsOnExcel.readExcel("Humans.xlsx", "Vinay");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class .. ");
	}
	
	@Test(dataProvider="personalData")
	public void testData(String ID, String Age, String Profession, String Experience) {
		System.out.println(ID+"\t"+Age+"\t"+Profession+"\t"+Experience);
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class .. ");
	}

}
