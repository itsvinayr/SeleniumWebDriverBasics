package com.learning.selenium.seleniumWebDriverBasics.testng;

import org.testng.annotations.Test;

public class Grouping {
	
	@Test(groups= {"A"}, dependsOnMethods= {"runTest4"})
	public void runTest1() {
		System.out.println("runTest1");
	}
	
	@Test(groups= {"B"})
	public void runTest2() {
		System.out.println("runTest2");
	}
	
	@Test(groups= {"C"})
	public void runTest3() {
		System.out.println("runTest3");
	}
	
	@Test(groups= {"A", "C"})
	public void runTest4() {
		System.out.println("runTest4");
	}
	
	@Test(groups= {"B","C"})
	public void runTest5() {
		System.out.println("runTest5");
	}
}
