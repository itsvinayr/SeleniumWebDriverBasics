package com.learning.selenium.seleniumWebDriverBasics.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeSuite
	public void runBeforeSuite() {
		System.out.println("runBeforeSuite");
	}
	
	@BeforeClass
	public void runBeforeClass() {
		System.out.println("runBeforeClass");
	}
	
	@BeforeMethod
	public void runBeforeMethod() {
		System.out.println("runBeforeMethod");
	}
	
	@BeforeTest
	public void runBeforeTest() {
		System.out.println("runBeforeTest");
	}
	
	@Test
	public void runTest() {
		System.out.println("runTest");
	}
	
	@AfterTest
	public void runAfterTest() {
		System.out.println("runAfterTest");
	}
	
	@AfterMethod
	public void runAfterMethod() {
		System.out.println("runAfterMethod");
	}
	
	@AfterClass
	public void runAfterClass() {
		System.out.println("runAfterClass");
	}
	
	@AfterSuite
	public void runAfterSuite() {
		System.out.println("runAfterSuite");
	}

}
