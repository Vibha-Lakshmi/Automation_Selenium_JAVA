package com.Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test8 {
	
	@Parameters({"samplename"})
	@Test(enabled = true)
	void test(String str) {
		System.out.println("In test!!");
		System.out.println("Name = "+str);
	}
	
	@Parameters({"browser_name","url"})
	@Test
	void test1(String a, String b) {
		System.out.println("In test1!!");
		System.out.println("Browser Name = "+a+" URL = "+b);
	}
}
