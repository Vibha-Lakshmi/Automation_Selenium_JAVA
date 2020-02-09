package com.practice.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wikidemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lakshmis\\My folder\\zips_jars_exe\\Exe Files\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		WebElement link;
		link = driver.findElement(By.linkText("English"));
		link.click();
		Thread.sleep(2000);
		WebElement searchbox;
		searchbox = driver.findElement(By.id("searchInput"));
		searchbox.sendKeys("software");
		searchbox.submit();
		Thread.sleep(2000);
		driver.quit();
	}

}
