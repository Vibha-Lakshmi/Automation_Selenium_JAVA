package com.practice.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CorridorFirefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", ".//selenium_drivers//geckodriver.exe");
		//System.setProperty("webdriver.gecko.marionette", ".//selenium_drivers//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://corridor.pramati.com/");
		
		driver.manage().window().maximize() ;
		WebElement conn;
		conn = driver.findElement(By.linkText("LOGIN"));
		conn.click();
		
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES) ;
		WebElement conn1;
		conn1 = driver.findElement(By.id("username"));
		conn1.sendKeys("vibha.lakshmi@imaginea");
		WebElement conn2;
		//encrypt and decrypt
		conn2 = driver.findElement(By.id("password"));
		conn2.sendKeys("Vibha2108@");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		//login
		WebElement login;
		login = driver.findElement(By.id("loginButton"));
		login.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		
		if(driver.switchTo().alert().getText().equals("Please enter a valid email id !!")) {
			System.out.println("TestCase pass!!");
		}
		else 
			System.out.println("TestCase fail!!");
		driver.quit();
	}

}
