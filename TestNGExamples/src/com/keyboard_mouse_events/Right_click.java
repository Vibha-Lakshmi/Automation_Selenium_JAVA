package com.keyboard_mouse_events;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Right_click {
	//src-- https://www.softwaretestingmaterial.com/selenium-right-click-action/
	
	@Test
	public void textInCaps() throws InterruptedException{
                //Instantiating the WebDriver interface.
		String chromeDriver = ".//selenium_drivers//";
		System.setProperty("webdriver.chrome.driver", chromeDriver + "chromedriver.exe");		WebDriver driver = new ChromeDriver();
                //Open the required URL
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
                //To maximize the browser
		driver.manage().window().maximize();
                //Create an object 'action' of an Actions class
		Actions action = new Actions(driver);
		By locator = By.cssSelector(".context-menu-one");
                //Wait for the element. Used Explicit wait
                WebDriverWait wait = new WebDriverWait(driver, 5);
                wait.until(ExpectedConditions.presenceOfElementLocated(locator)); 
                WebElement rightClickElement=driver.findElement(locator);
                //contextClick() method to do right click on the element
                action.contextClick(rightClickElement).build().perform();
                Thread.sleep(2000);
                WebElement getCopyText =driver.findElement(By.cssSelector(".context-menu-icon-copy"));
                //getText() method to get the text value
                String GetText = getCopyText.getText();
                //To print the value
                System.out.println(GetText);
                //To close the browser
                driver.close();
	}
}