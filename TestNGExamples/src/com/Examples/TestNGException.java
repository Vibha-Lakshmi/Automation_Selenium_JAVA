package com.Examples;

import org.testng.annotations.Test;
public class TestNGException {

	@Test(expectedExceptions = ArithmeticException.class)
	public void testException() {
		System.out.println("In test Exception class");
		int i = 1 / 0;	
		System.out.println("i = "+i);
		System.out.println("In test Exception class");

		
	}
}