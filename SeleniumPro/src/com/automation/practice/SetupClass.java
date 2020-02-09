package com.automation.practice;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;


public class SetupClass {
	 static WebDriver driver;
	public static void setup()
	{
		String chromeDriver = ".//selenium_drivers//";
		int a;
		Scanner sc = new Scanner(System.in);
		System.out.println("*****Menu*****\n1. Chrome\n2. Firefox");
		a = sc.nextInt();
		
		switch(a) {
		case 1: System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
				break;
		case 2: System.setProperty("webdriver.gecko.driver", chromeDriver+"geckodriver.exe");
				break;
		}
		
		//driver = new ChromeDriver();
		//WebDriver driver = new ChromeDriver();
		//driver.get("https://corridor.pramati.com/");
		//driver.manage().window().maximize() ;
		//WebElement conn;
		
		sc.close();
	}

}
