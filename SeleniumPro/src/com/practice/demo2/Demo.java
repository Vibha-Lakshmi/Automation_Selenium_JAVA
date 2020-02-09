	package com.practice.demo2;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Demo {

		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lakshmis\\My folder\\zips_jars_exe\\Exe Files\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://www.gmail.com/");
			driver.manage().window().maximize();
			driver.findElement(By.id("identifierId")).sendKeys("g.vibhanaidu@gmail.com");
			Thread.sleep(2000);
			driver.findElement(By.className("CwaK9")).click();
			Thread.sleep(2000);
			String at = driver.getTitle();
			String et = "gmail";
			driver.close();
			if(at.equalsIgnoreCase(et))
			{
				System.out.println("Test Successful!!");
			}
			else
			{
				System.out.println("Test Failure");
			}
		}

	}

