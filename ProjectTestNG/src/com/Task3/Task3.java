package com.Task3;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Task3 {

	@BeforeSuite(alwaysRun = true)
	void setUp() {
		System.out.println("In BeforeSuite");
	}
	
	@Test(groups = {"sanity"})
	void func1() {
		System.out.println("in func1");
	}

	@Test(groups = {"smoke","sanity"})
	void func2() {
		System.out.println("in func2");
	}
	
	@Test(groups = {"smoke"})
	void func3() {
		System.out.println("in func3");
	}
	
	@Test(groups = {"sanity"})
	void func4() {
		System.out.println("in func4");
	}
	
	@Test
	void func5() {
		System.out.println("in func5");
	}
	
	@Test
	void func6() {
		System.out.println("in func6");
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		System.out.println("In TearDown");
	}
}
