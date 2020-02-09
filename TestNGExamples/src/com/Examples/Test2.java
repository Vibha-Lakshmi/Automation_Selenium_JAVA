package com.Examples;

	import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

	public class Test2 {
		
	/*
	 * @BeforeSuite void beforeSuite() { System.out.println("Before Suite"); }
	 * 
	 * @AfterSuite void afterSuite() { System.out.println("After Suite"); }
	 */
		
		@BeforeTest
		void beforeTest() {
			System.out.println("Before Test");
		}
		
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
		
		

		@Test(description = "Test2 setup")
		public void SetUp() {
			System.out.println("setup");
		
		}
		
		@Test
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
