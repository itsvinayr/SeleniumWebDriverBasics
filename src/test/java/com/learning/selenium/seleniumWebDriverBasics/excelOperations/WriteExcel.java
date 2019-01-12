package com.learning.selenium.seleniumWebDriverBasics.excelOperations;

import java.io.IOException;

import org.testng.annotations.Test;

import com.learning.selenium.seleniumWebDriverBasics.excelUtilities.OperationsOnExcel;

public class WriteExcel {
	
	@Test
	public void writeExcel() throws IOException {
		OperationsOnExcel.writeExcel("Humans.xlsx", "Vinay");
	}
	
	@Test (dependsOnMethods= {"writeExcel"})
	public void readExcel() throws IOException {
		OperationsOnExcel.readExcel("Humans.xlsx", "Vinay");
	}

}
