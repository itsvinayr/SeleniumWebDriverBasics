package com.learning.selenium.seleniumWebDriverBasics.excelOperations;

import java.io.IOException;

import org.testng.annotations.Test;

import com.learning.selenium.seleniumWebDriverBasics.excelUtilities.OperationsOnExcel;

public class Readexcel {
	
	@Test
	public void readExcel() throws IOException {
		OperationsOnExcel.readExcel("Humans.xlsx", "Vinay");
	}

}
