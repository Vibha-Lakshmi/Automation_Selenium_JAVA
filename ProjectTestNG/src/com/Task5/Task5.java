package com.Task5;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task5 {

	@Parameters("browser")
	@Test(dependsOnMethods = "setUp", description = "This is login test")
	public void login(String browser) {
		System.out.println("*****Login Method");
		System.out.println("Browser : " + browser);
	}

	@Test(description = "This is setup test")
	public void setUp() {
		System.out.println("*****SetUp Method");
	}
	
	@Test(description = "This is composeMail test")
	public void composeMail() {
		System.out.println("*****composeMail Method");
	}
	
	@Test(description = "This is draftMail test")
	public void draftMail() {
		System.out.println("*****draftMail Method");
	}

	@Test(dependsOnMethods = "login", description = "This is logout test")
	public void logout() {
		System.out.println("*****Logout Method");
	}

}
