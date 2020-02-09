package com.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ListenerMainClass {
	
	public static void main (String [] args){
		//src---https://www.softwaretestingmaterial.com/webdriver-event-listeners/
		System.setProperty("webdriver.gecko.driver", ".//selenium_drivers//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		EventFiringWebDriver eventHandler = new EventFiringWebDriver(driver); 
		EventCapture eCapture = new EventCapture(); 
		//Registering with EventFiringWebDriver
                //Register method allows to register our implementation of WebDriverEventListner to listen to the WebDriver events
		eventHandler.register(eCapture); 
		//navigating to the webpage "www.softwaretestingmaterial.com"
		eventHandler.navigate().to("https://corridor.pramati.com/cas/login?service=https://corridor.pramati.com/wp-login.php?redirect_to=apps#?authType=password"); 
		eventHandler.findElement(By.id("username")).sendKeys("vibha.lakshmi@imaginea.com");
		eventHandler.findElement(By.id("password")).sendKeys("Vibha2108@");
		eventHandler.findElement(By.id("loginButton")).click();


		//navigating to the webpage "www.softwaretestingmaterial.com/category/selenium/"
		eventHandler.navigate().to("https://corridor.pramati.com/hr/"); 
		//navigating back to the first page
		eventHandler.navigate().back();
		eventHandler.quit();
                //Unregister allows to detach
		eventHandler.unregister(eCapture);
		System.out.println("End of Listners Class");
	}
}