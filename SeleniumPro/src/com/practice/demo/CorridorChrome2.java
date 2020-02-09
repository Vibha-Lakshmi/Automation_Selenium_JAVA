package com.practice.demo;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class CorridorChrome2 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String chromeDriver = ".//selenium_drivers//";
		System.setProperty("webdriver.chrome.driver", chromeDriver+"chromedriver.exe");
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
		//login
		WebElement login;
		login = driver.findElement(By.id("loginButton"));
		login.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		
		/*
		 * // PAGE TITLE String j = driver.getTitle();
		 * System.out.println("Your page title Is : "+j); int a =
		 * j.compareTo("Apps | Corridor"); if (a != 0)
		 * System.out.println("Not Correct Title!!!"); else
		 * System.out.println("Correct Title!!!");
		 * System.out.println("******************");
		 */
		// HOLIDAY LIST
		WebElement List_Holiday;
		List_Holiday = driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//a[1]"));
		List_Holiday.click();
		Thread.sleep(2000);
		String hyd_list_xpath = "//span[contains(text(),'Hyderabad')]";
		WebElement List_Holiday_hyd = driver.findElement(By.xpath(hyd_list_xpath));
		List_Holiday_hyd.click();
		Thread.sleep(2000);
		
		String str1 = "sasidhar \n Redy";
		System.out.println(str1);
		//WebElement val = driver.findElement(By.xpath("//div[@name='livelist5']//ul[@class='app-livelist-container clearfix list-group']/li")); 

		List<WebElement> allElements = driver.findElements(By.xpath("//div[@name='livelist5']//ul[@class='app-livelist-container clearfix list-group']/li")); 

		for(int i=1; i<=allElements.size(); i++) {
			
			System.out.println(i +". Holiday : "+driver.findElement(By.xpath("//div[@name='livelist5']//ul[@class='app-livelist-container clearfix list-group']/li["+i+"]")).getText()); 

		}
		/*
		 * System.out.println(allElements.size() + "---------------"); for (WebElement
		 * element: allElements) { System.out.println("Holiday  : "+element.getText());
		 * 
		 * } WebElement conn3; conn3 = driver.findElement(By.className("btn-caption"));
		 * conn3.click(); Thread.sleep(2000);
		 */
		
		
		/*
		 * // PHONE BOOK WebElement conn4; conn4 =
		 * driver.findElement(By.xpath("//div[6]//div[1]//div[1]//div[1]//a[1]"));
		 * conn4.click(); Thread.sleep(2000); conn4 =
		 * driver.findElement(By.xpath("//span[contains(text(),'Hyderabad')]"));
		 * conn4.click(); Thread.sleep(2000); conn4 =
		 * driver.findElement(By.name("textSearch")); conn4.sendKeys("Vibha Gopi");
		 * //call function to take screenshot takeSnapShot(driver, "d://test.png") ;
		 * conn4 = driver.findElement(By.name("labelEmployeeName"));
		 * System.out.println("******************");
		 * System.out.println("Name: "+conn4.getText()); conn4 =
		 * driver.findElement(By.xpath(
		 * "//span[contains(text(),'vibha.lakshmi@imaginea.com')]"));
		 * System.out.println("Email id: "+conn4.getText()); //Thread.sleep(2000); conn4
		 * = driver.findElement(By.xpath("//span[contains(text(),'Back To Apps')]"));
		 * conn4.click(); Thread.sleep(2000);
		 */
		 
		/*
		 * // LEARNING @ PRAMATI WebDriverWait wait=new WebDriverWait(driver, 20);
		 * WebElement conn5; conn5 =
		 * driver.findElement(By.xpath("//div[8]//div[1]//div[1]//div[1]//a[1]"));
		 * conn5.click(); conn5 =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("label10")))
		 * ; //driver.manage().timeouts(). ; String str = conn5.getText();
		 * System.out.println("Learning Session = "+str);
		 * driver.navigate().to("https://corridor.pramati.com/apps/");
		 * Thread.sleep(2000);
		 * 
		 * //Logout WebElement conn6; conn6 = driver.findElement(By.linkText("LOGOUT"));
		 * conn6.click(); Thread.sleep(2000); WebElement conn7; conn7 =
		 * driver.findElement(By.linkText("log out")); conn7.click();
		 * Thread.sleep(2000);
		 */
//		driver.quit();

	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileHandler.copy(SrcFile, DestFile);

	}

}
