package com.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;


public class TestListener {
	
	WebDriver driver;

	@BeforeMethod
	void setUp() {
		System.out.println("Before Test");
		String chromeDriver = ".//selenium_drivers//";
		System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corridor.pramati.com/");
		driver.manage().window().maximize() ;
	}

	@Test
	void func1() {
		Assert.assertEquals("Pramati", "Imaginea");
	}

	@Test(dependsOnMethods = { "func1" })
	void func2() {
		Assert.assertTrue((2 < 1), "SUCCESS");
		/*
		 * if(2>1) throw new SkipException("Skipping this exception");
		 */
	}

	@Test(timeOut = 200)
	public void testcase1() throws InterruptedException {

		System.out.println("***In TestCase 1");
		Thread.sleep(500);
		System.out.println("This is testcase1");
	}
	
	@AfterMethod //AfterMethod annotation - This method executes after every test execution
	public void screenShot(ITestResult result){
	//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		if(ITestResult.FAILURE==result.getStatus()){
			try{
				// To create reference of TakesScreenshot
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				// Call method to capture screenshot
				File src=screenshot.getScreenshotAs(OutputType.FILE);
				// Copy files to specific location 
				// result.getName() will return name of test case so that screenshot name will be same as test case name
				FileUtils.copyFile(src, new File("D:\\all_screenshots\\"+result.getName()+".png"));
				System.out.println("Successfully captured a screenshot");
			}catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
	}
	driver.quit();
	}

}
