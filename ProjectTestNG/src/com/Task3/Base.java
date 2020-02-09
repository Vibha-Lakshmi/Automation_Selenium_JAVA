package com.Task3;

import org.testng.annotations.BeforeSuite;

public class Base {

	@BeforeSuite(alwaysRun = true)
	void setUp() {
		System.out.println("In BeforeSuite");
	}
}
