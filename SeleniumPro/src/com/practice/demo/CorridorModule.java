package com.practice.demo;

import java.util.List;
//import java.util.Vector;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CorridorModule {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lakshmis\\My folder\\zips_jars_exe\\Exe Files\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://corridor.pramati.com/");
		driver.manage().window().maximize() ;
		WebElement conn;
		conn = driver.findElement(By.linkText("LOGIN"));
		conn.click();
		//implicit weights
		//driver.wait(2000);
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES) ;
		WebElement conn1;
		conn1 = driver.findElement(By.id("username"));
		conn1.sendKeys("vibha.lakshmi@imaginea.com");
		WebElement conn2;
		//encrypt and decrypt
		conn2 = driver.findElement(By.id("password"));
		conn2.sendKeys("Vibha2108@");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		WebElement login;
		login = driver.findElement(By.id("loginButton"));
		login.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		
		//
		// HOLIDAY LIST
				WebElement List_Holiday;
				List_Holiday = driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//a[1]"));
				List_Holiday.click();
				Thread.sleep(2000);
				String hyd_list_xpath = "//span[contains(text(),'Hyderabad')]";
				WebElement List_Holiday_hyd = driver.findElement(By.xpath(hyd_list_xpath));
				List_Holiday_hyd.click();
				Thread.sleep(2000);
				
				
				List<WebElement> abc = driver.findElements(By.xpath("//div[@name='livelist5']//ul[@class='app-livelist-container clearfix list-group']/li"));
				
				//System.out.println("holiday lsit size : "+abc.size());
				System.out.println("HOLIDAY LIST");
				String str;
				//String dl = "\n";
				for (WebElement element: abc) {
				      //System.out.println(element.getText());
					 str = element.getText();
				      String[] res = str.split("\n"); 
			/*
			 * for (String x : res) { System.out.println(x); }
			 */
				      System.out.println(res[0]+" : "+res[1]+" "+res[2]);
				}
				
				WebElement conn3;
				conn3 = driver.findElement(By.className("btn-caption"));
				conn3.click();
		
		
		//driver.navigate().to("https://corridor.pramati.com/apps/");
		Thread.sleep(2000);
		driver.quit();

	}

}
