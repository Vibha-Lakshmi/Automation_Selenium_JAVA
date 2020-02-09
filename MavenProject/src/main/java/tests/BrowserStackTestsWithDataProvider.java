package tests;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BrowserStackTestsWithDataProvider {
	//https://www.softwaretestingmaterial.com/run-selenium-tests-on-browserstack/#Run-Selenium-Tests-on-BrowserStack
	public WebDriver driver;
	public static final String USERNAME = "vibhalakshmisgop1";
	public static final String AUTOMATE_KEY = "AeKLFsu53qBCqp2Q9a8s";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	
        // Here to pass multiple test data to the script, I am using @DataProvider annotation of TestNG

	@Test(dataProvider="EnvironmentDetails")
	public void openSTM(Platform platform, String browserName, String browserVersion) throws InterruptedException, IOException {
		
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setPlatform(platform);
		capability.setBrowserName(browserName);
		capability.setVersion(browserVersion);
		capability.setCapability("browserstack.debug", "true");
				
		URL browserStackUrl = new URL(URL);

		driver = new RemoteWebDriver (browserStackUrl, capability);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://corridor.pramati.com/");
		
		// following 3 lines of code captures the screenshot
		 
		 driver = (RemoteWebDriver) new Augmenter().augment(driver);
		 File srcFile = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(srcFile, new File("/location/to/screenshot.png"));
		
		String actualURL = driver.getCurrentUrl();
		System.out.println("URL is "+actualURL);
		driver.quit();
		String expectedURL = "https://corridor.pramati.com/";
		Assert.assertEquals(actualURL, expectedURL,"Failed To Open");
	}
	
        // passing parallel = true to run the test scripts in parallel
        // DataProvider supports Object return type 
        // Passing values such as MAC with Chrome 62, Windows 8 with Chrome 62, and Windows 7 with firefox 57
	@DataProvider(name="EnvironmentDetails", parallel=true)
	public Object[][] getData(){
		
		Object[][] testData = new Object[][]{
			{Platform.MAC, "chrome", "62.0"},
			{Platform.WIN8, "chrome", "62.0"},
			{Platform.WINDOWS, "firefox", "57"}
		};
		
		return testData;		
	}
}