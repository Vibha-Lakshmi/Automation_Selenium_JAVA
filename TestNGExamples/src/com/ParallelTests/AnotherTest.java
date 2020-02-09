package com.ParallelTests;

import org.testng.annotations.Test;

public class AnotherTest {
	/*
	 * parallel="methods": TestNG will run all your test methods in separate
	 * threads. Dependent methods will also run in separate threads but they will
	 * respect the order that you specified.
	 * 
	 * parallel="tests": TestNG will run all the methods in the same <test> tag in
	 * the same thread, but each <test> tag will be in a separate thread. This
	 * allows you to group all your classes that are not thread safe in the same
	 * <test> and guarantee they will all run in the same thread while taking
	 * advantage of TestNG using as many threads as possible to run your tests.
	 * 
	 * parallel="classes": TestNG will run all the methods in the same class in the
	 * same thread, but each class will be run in a separate thread.
	 * 
	 * parallel="instances": TestNG will run all the methods in the same instance in
	 * the same thread, but two methods on two different instances will be running
	 * in different threads. Additionally, the attribute thread-count allows you to
	 * specify how many threads should be allocated for this execution.
	 */
	@Test(threadPoolSize = 3, invocationCount = 10)
	void func1() {
		System.out.println("This is another test 1 !!!");
	}
	
	@Test
	void func2() {
		System.out.println("This is another test 2 !!!");
	}
	
	@Test
	void func3() {
		System.out.println("This is another test 3 !!!");
	}
	
	@Test
	void func4() {
		System.out.println("This is another test 4 !!!");
	}
	
	@Test
	void func5() {
		System.out.println("This is another test 5 !!!");
		
		//int count = method.getTestMethod().getXmlTest().getThreadCount();
	}
}