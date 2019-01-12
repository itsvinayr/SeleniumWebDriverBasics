package com.learning.selenium.seleniumWebDriverBasics.testng;

import org.testng.annotations.Test;

public class SequencingAndPrioritizing {
	
	@Test(priority=0)
	public void runTest1() {
		System.out.println("runTest1");
	}
	
	@Test(priority=4)
	public void runTest2() {
		System.out.println("runTest2");
	}
	
	@Test(priority=2)
	public void runTest3() {
		System.out.println("runTest3");
	}
	
	@Test(priority=1)
	public void runTest4() {
		System.out.println("runTest4");
	}
	
	@Test(priority=5, enabled=false)
	public void runTest5() {
		System.out.println("runTest5");
	}
}
