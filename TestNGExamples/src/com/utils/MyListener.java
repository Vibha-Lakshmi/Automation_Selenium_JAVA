package com.utils;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
/*import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
*/


public class MyListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("In On Test Start", true);
		System.out.println("onTestStart");
		System.out.println("Success of test cases and its details are : "+result.getName());  
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSuccess");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailure");
		
		//screenshot
		
		/*
		 * try{ // To create reference of TakesScreenshot TakesScreenshot
		 * screenshot=(TakesScreenshot)driver; // Call method to capture screenshot File
		 * src=screenshot.getScreenshotAs(OutputType.FILE); // Copy files to specific
		 * location // result.getName() will return name of test case so that screenshot
		 * name will be same as test case name FileUtils.copyFile(src, new
		 * File("D:\\all_screenshots\\"+result.getName()+".png"));
		 * System.out.println("Successfully captured a screenshot"); }catch (Exception
		 * e){ System.out.println("Exception while taking screenshot "+e.getMessage());
		 * }
		 */
		
		
		/*
		 * File screenshotFile =
		 * ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(screenshotFile, new
		 * File("D:\\SoftwareTestingMaterial.png"));
		 */
	    
	    
		/*
		 * String fileWithPath = "d://testingListener.png"; WebDriver driver = new
		 * ChromeDriver(); driver.get("d://test.png"); //Convert web driver object to
		 * TakeScreenshot
		 * 
		 * TakesScreenshot scrShot =((TakesScreenshot)driver);
		 * 
		 * //Call getScreenshotAs method to create image file
		 * 
		 * File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		 * 
		 * //Move image file to new destination
		 * 
		 * File DestFile=new File(fileWithPath);
		 * 
		 * //Copy file at destination
		 * 
		 * try { FileHandler.copy(SrcFile, DestFile); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSkipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onStart");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("onFinish");
	}

}
