package com.learning.selenium.seleniumWebDriverBasics.testng;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learning.selenium.seleniumWebDriverBasics.excelOperations.OperationsOnExcel;

public class DataProviderUsingExcel {
	
	@DataProvider(name="personalData")
	public static Object[][] getData() throws IOException{
		return OperationsOnExcel.readExcel("Likki");
	}
	
	@Test(dataProvider="personalData")
	public void testData(String ID, String Age, String Profession, String Experience) {
		System.out.println(ID+"\n"+Age+"\n"+Profession+"\n"+Experience);
	}

}
