package com.Examples;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class Test7 {
	@BeforeGroups("sanity")  
	public void before_it()  
	{  
	System.out.println("This method will be executed before the execution of sanity group");  
	}  
	
	@AfterGroups("sanity")  
	public void after_group()  
	{  
	System.out.println("The list which is shown above are the sanity group");  
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
}
