package com.Examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BackHome {
	
	WebDriver driver;
	
	@BeforeTest
	void setUp() {
		System.out.println("Before Test");
		String chromeDriver = ".//selenium_drivers//";
		System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corridor.pramati.com/");
		driver.manage().window().maximize() ;
	}
	@BeforeClass
	void setUpWeb() {
		System.out.println("Before Class");
	
		WebElement login;
		login = driver.findElement(By.linkText("LOGIN"));
		login.click();
		//implicit weights
		//driver.wait(2000);
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES) ;
		WebElement username;
		username = driver.findElement(By.id("username"));
		username.sendKeys("vibha.lakshmi@imaginea.com");
		WebElement conn2;
		//encrypt and decrypt
		conn2 = driver.findElement(By.id("password"));
		conn2.sendKeys("Vibha2108@");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		//login
		WebElement loginbtn;
		loginbtn = driver.findElement(By.id("loginButton"));
		loginbtn.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		
		Assert.assertTrue(2>3);
		Assert.assertEquals("Pramati", "Imagiena");
		
	}

	
	
	

	
	@Test(enabled = true)
	void letsMeetMethod() throws InterruptedException {
		WebElement launch_letsmeet;
		launch_letsmeet = driver.findElement(By.xpath("//div[10]//div[1]//div[2]//div[1]//a[1]"));
		launch_letsmeet.click();
		
		//List<WebElement> check_time = driver.findElements(By.xpath("//div[@name='gridrow7']//div[@name='gridcolumn17']//div[@class='app-ng-transclude']"));
		WebElement check_time;
		check_time= driver.findElement(By.xpath("//div[@name='gridrow7']//div[@name='gridcolumn17']//div[@class='app-ng-transclude']"));
		System.out.println("***Place,Time and date displayed on Let's Meet page***");
		System.out.println("print = "+check_time.getText());
		
		WebElement check_time2= driver.findElement(By.xpath("//div[@name='gridrow7']//div[@name='gridcolumn17']//div[@class='app-ng-transclude']/label[1]"));
		System.out.println(check_time2.getAttribute("textContent") + "----------------");
		
//		driver.navigate().to("https://corridor.pramati.com/apps");;
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod(enabled = false)
	void tearDown() throws InterruptedException {
		System.out.println("After Method");
		//Logout
				WebElement logout;
				logout = driver.findElement(By.linkText("LOGOUT"));
				logout.click();
				Thread.sleep(2000);
				WebElement logout_link;
				logout_link = driver.findElement(By.linkText("log out"));
				logout_link.click();
				Thread.sleep(2000);
				driver.quit();
	}
	
	

	

}
