package com.Examples;


	import org.testng.SkipException;
import org.testng.annotations.Test;

	public class Test5 {		
	/*
	 * @BeforeSuite void beforeSuite() { System.out.println("Before Suite"); }
	 * 
	 * @AfterSuite void afterSuite() { System.out.println("After Suite"); }
	 * 
	 * @BeforeTest void beforeTest() { System.out.println("Before Test"); }
	 * 
	 * @AfterTest void afterTest() { System.out.println("After Test"); }
	 * 
	 * @BeforeClass void beforeClass() { System.out.println("Before Class"); }
	 * 
	 * @AfterClass void afterClass() { System.out.println("After Class"); }
	 * 
	 * 
	 * @BeforeMethod void beforeMethod() { System.out.println("Before Method"); }
	 * 
	 * @AfterMethod void afterMethod() { System.out.println("After Method"); }
	 */
		
		

		@Test(description = "setting up", enabled = false)
		public void SetUp() {
			System.out.println("setup");
		
		}
		
		@Test(description = "Test setting up 1", priority=1, enabled = true)
		public void signup() {
			System.out.println("signup");
		}
		
		
		@Test(description = "Test setting up 1", priority=1, enabled = true, dependsOnMethods = {"signup","composeMail"})
		public void login() {
			System.out.println("login");

		}
		
		
		@Test(description = "Test setting up 1", priority=3, enabled = true)
		public void composeMail() {
			System.out.println("composeMail");
		}
		
	/*
	 * The root exception for special skip handling. In case a @Test
	 * or @Configuration throws this exception the method will be considered a skip
	 * or a failure according to the return of {@link #isSkip()}. Users may provide
	 * extensions to this mechanism by extending this class.
	 */
		@Test(description = "Test setting up 1")
		public void draftMail() {
			System.out.println("draftMail");
			System.out.println("Im in Conditional Skip");
			if(2>1)
			throw new SkipException("Skipping this exception");
			System.out.println("Executed Successfully");
		}
		
		@Test(description = "Test setting up 1")
		public void sendMail() {
			System.out.println("sendMail");
			System.out.println("Im in Conditional Skip");
			if(2<1)
			throw new SkipException("Skipping this exception");
			System.out.println("Executed Successfully");
		}
		
		@Test(description = "Test setting up 1", priority=6, enabled = false)
		public void logout() {
			System.out.println("logout");
		}
	}
