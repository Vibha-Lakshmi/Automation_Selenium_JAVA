package com.Examples;

import org.testng.annotations.Test;

public class ThreadPool {
	int i = 0;
	/*
	 * @Test(threadPoolSize = 3, <code class="plain">invocationCount = </code><code
	 * class="value">10</code>) public void testCase1(){
	 * 
	 * }
	 */

	@Test(threadPoolSize = 3, invocationCount = 10, timeOut = 10000)
	public void testCase2(){
		System.out.println("In TC2"+"..."+i+++"..."+Thread.currentThread().getId());
	}
}
