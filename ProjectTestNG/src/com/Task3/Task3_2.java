package com.Task3;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Task3_2 extends Base{

	
	@Test(groups = {"sanity"})
	void func1() {
		System.out.println("in func1");
	}

	
	
	@Test
	void func6() {
		System.out.println("in func6");
	}

	@AfterSuite
	void tearDown() {
		System.out.println("In TearDown");
	}
}
