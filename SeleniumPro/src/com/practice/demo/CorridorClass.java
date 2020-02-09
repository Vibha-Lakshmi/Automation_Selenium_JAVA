package com.practice.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CorridorClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.ie.driver", "C:\\Users\\lakshmis\\My folder\\zips_jars_exe\\Exe Files\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("https://corridor.pramati.com/");
		WebElement conn;
		conn = driver.findElement(By.linkText("LOGIN"));
		conn.click();
		driver.wait(2000);
		driver.quit();

	}

}
