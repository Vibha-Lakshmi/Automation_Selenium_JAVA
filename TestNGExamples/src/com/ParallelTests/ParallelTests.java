package com.ParallelTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelTests {
	
	/*
	 * tests – All the test cases inside <test> tag of testng.xml file will run
	 * parallel classes – All the test cases inside a java class will run parallel
	 * methods – All the methods with @Test annotation will execute parallel
	 * instances – Test cases in same instance will execute parallel but two methods
	 * of two different instances will run in different thread.
	 */
	@BeforeMethod
	void setup() {
		System.out.println("In Before Method");
	}
	
	@AfterMethod
	void teardown() {
		System.out.println("In After Method");
	}
	@Test
	public void getFirefox(){
                //System.setProperty("webdriver.gecko.driver", "geckodriver.exe path");
		/*
		 * String geckoDriver = ".//selenium_drivers//";
		 * System.setProperty("webdriver.gecko.driver", geckoDriver+"geckodriver.exe");
		 */

		System.setProperty("webdriver.gecko.driver", ".//selenium_drivers//geckodriver.exe");
		//System.setProperty("webdriver.gecko.driver", "D://Selenium Environment//Drivers//geckodriver.exe");
                System.out.println("GetFirefox Method is running on Thread : " + Thread.currentThread().getId());
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.close();
	}
	
	@Test
	public void getChorme(){
                //System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
		String chromeDriver = ".//selenium_drivers//";
		System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "D://Selenium Environment//Drivers//chromedriver.exe");
                System.out.println("GetChrome Method is running on Thread : " + Thread.currentThread().getId());
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.close();
	}

}