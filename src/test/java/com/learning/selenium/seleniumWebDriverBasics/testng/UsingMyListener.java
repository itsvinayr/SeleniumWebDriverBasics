package com.learning.selenium.seleniumWebDriverBasics.testng;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyListener.class)
public class UsingMyListener {
	@Test
	public void testGoogle() {
		System.out.println("This is google");
	}
}
