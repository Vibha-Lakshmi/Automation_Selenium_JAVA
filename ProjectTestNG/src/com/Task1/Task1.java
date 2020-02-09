package com.Task1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task1 {

	WebDriver driver;

	
	@Parameters({"url"})
	@BeforeSuite
	void setUpPage(String url) {
		System.out.println("Before Suite");

		String chromeDriver = ".//selenium_drivers//";
		System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corridor.pramati.com/");
		driver.manage().window().maximize() ;
		
		WebElement login;
		login = driver.findElement(By.linkText("LOGIN"));
		login.click();
	}
	
	@Test(priority = 1)
	void login()  {
		System.out.println("In Login Method");
				
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		
		WebElement username;
		username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys("vibha.lakshmi@imaginea.com");
		
		WebElement password;
		password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("Vibha2108@");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// login
		WebElement loginbtn;
		loginbtn = driver.findElement(By.id("loginButton"));
		loginbtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


	}

	@Test(priority = 2)
	void logout() {
		System.out.println("In Logout Method");
		//Logout
		WebElement logout;
		logout = driver.findElement(By.linkText("LOGOUT"));
		logout.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement logout_link;
		logout_link = driver.findElement(By.linkText("log out"));
		logout_link.click();

	}

	@AfterSuite
	void tearDown() {
		System.out.println("In TearDown");
		driver.quit();
	}
}
