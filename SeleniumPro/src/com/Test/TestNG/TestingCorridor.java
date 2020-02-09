package com.Test.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestingCorridor {
	
	@Test
	void setup(){
		String chromeDriver = ".//selenium_drivers//";
		System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://corridor.pramati.com/");
		driver.manage().window().maximize() ;
	}
	
	
	
	
	

}
