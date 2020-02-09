package com.Examples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1 {
	
	/*
	 * Generally, @BeforeSuite is used when we have different URLs to run your test
	 * cases. Environment variables are set in a @BeforeSuite annotated method so
	 * that before executing all the test cases, you need to load all the
	 * environment variables for your framework, and then it starts executing your
	 * test cases.
	 */	
	@BeforeSuite(enabled = true)
	void beforeSuite() {
		System.out.println("Before Suite");
	}

	/*
	 * @AfterSuite annotation is used to stop the selenium web drivers.
	 */
	@AfterSuite
	void afterSuite() {
		System.out.println("After Suite");
	}
	
	@BeforeTest
	void beforeTest() {
		System.out.println("Before Test");
	}
	
	/*
	 * Once the execution is completed, there is a requirement to remove the
	 * cookies, delete the process or close the connection, so @AfterTest annotated
	 * method is used for this purpose.
	 */	
	@AfterTest
	void afterTest() {
		System.out.println("After Test");
	}
	
	@BeforeClass
	void beforeClass() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	void afterClass() {
		System.out.println("After Class");
	}
	
	
	@BeforeMethod
	void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	void afterMethod() {
		System.out.println("After Method");
	}
	
	

	@Test(description = "setting up", enabled = false)
	public void SetUp() {
		System.out.println("setup");
	
	}
	
	@Test(description = "Test setting up 1", enabled = false)
	public void TestSetUp1() {
		System.out.println("TestSetUp1");

	}
	
	@Test
	public void TestSetUp2() {
		System.out.println("TestSetUp2");
	}
	
	@Test
	public void TestSetUp3() {
		System.out.println("TestSetUp3");
	}
	
	@Test
	public void TestSetUp4() {
		System.out.println("TestSetUp4");
	}
	
	@Test
	public void TestSetUp5() {
		System.out.println("TestSetUp5");
	}
}
