package tests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/*import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;
import java.io.File;*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserStackTests {
	public WebDriver driver;
	public static final String USERNAME = "vibhalakshmisgop1";
	public static final String AUTOMATE_KEY = "AeKLFsu53qBCqp2Q9a8s";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	
	@Test
	public void openSTM() throws Exception {
                // To execute scripts through remote server or grid on mulitple browsers, we need to set capabilities of platform, version etc., to run the scripts
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "76.0.3809.100");
		caps.setCapability("browserstack.local", "false");
		caps.setCapability("browserstack.selenium_version", "3.141.59");	
		/*
		 * DesiredCapabilities capability = new DesiredCapabilities();
		 * capability.setPlatform(Platform.MAC); capability.setBrowserName("firefox");
		 * capability.setVersion("38"); capability.setCapability("browserstack.debug",
		 * "true");
		 */
		
		// Creatng URL object
		URL browserStackUrl = new URL(URL);
		// Create object of driver. We execute scripts remotely. So we use RemoteWebDriver
		//There are many constructors to remotewebdriver
                //To pass URL object and Capabilities object, use the below mentioned constructor
                //RemoteWebDriver(URL remoteAddress, Capabilities desiredCapabilities)
		driver = new RemoteWebDriver (browserStackUrl, caps);
		//Implicit wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// to open url
		driver.get("https://corridor.pramati.com/");
			//driver.get("https://www.softwaretestingmaterial.com");
		// To get the current url
		String actualURL = driver.getCurrentUrl();
		// To print the URL
		System.out.println("URL is "+actualURL);
		driver.quit();
		String expectedURL = "https://corridor.pramati.com/";
                //Assert to verify the actual and expected values
		Assert.assertEquals(actualURL, expectedURL,"Expected and Actual are not same");		
	}
}