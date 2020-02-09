package com.Examples;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test4 {
	
	@BeforeClass
	void beforeClass(){
		System.out.println("beforeClass");
	}
	
	@AfterClass
	void afterClass(){
		System.out.println("afterClass");
	}
	@BeforeTest
	void beforeTest() {
		System.out.println("beforeTest");
	}
	@AfterTest
	void afterTest(){
		System.out.println("afterTest");
	}
	@Test
	void test(){
		System.out.println("test");
	}


}
