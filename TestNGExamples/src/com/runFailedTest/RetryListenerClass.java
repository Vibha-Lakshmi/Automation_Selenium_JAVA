package com.runFailedTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestNGListener;
import org.testng.annotations.ITestAnnotation;

public class RetryListenerClass implements IAnnotationTransformer {
	/* extends ITestNGListener
	 * This method will be invoked by TestNG to give you a chance to modify a TestNG
	 * annotation read from your test classes. You can change the values you need by
	 * calling any of the setters on the ITest interface.
	 * 
	 * Note that only one of the three parameters testClass, testConstructor and
	 * testMethod will be non-null.
	 * 
	 */

	@Override
	public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor,
			Method testMethod) {
		IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

		if (retry == null) {
			testannotation.setRetryAnalyzer(RetryFailedTestCases.class);
		}

	}

}