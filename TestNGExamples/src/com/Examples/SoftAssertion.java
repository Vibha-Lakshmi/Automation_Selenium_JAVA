package com.Examples;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	
	@Test
	public void softAssert(){
		/**
		 * When an assertion fails, don't throw an exception but record the failure.
		 * Calling {@code assertAll()} will cause an exception to be thrown if at
		 * least one assertion failed.
		 */
		SoftAssert softAssertion= new SoftAssert();
		 System.out.println("softAssert Method Was Started");
		 softAssertion.assertTrue(false);
		 System.out.println("softAssert Method Was Executed");
		/*
		 * Note: If you forget to call assertAll() at the end of your test, the test
		 * will pass even if any assert objects threw exceptions. 
		 * So don’t forget to add assertAll()
		 */		 
		 softAssertion.assertAll();
	}
	
	@Test
	public void hardAssert(){
		System.out.println("hardAssert Method Was Started");
		Assert.assertTrue(false);
		System.out.println("hardAssert Method Was Executed");
	}

}
