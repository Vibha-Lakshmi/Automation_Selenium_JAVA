package com.keyboard_mouse_events;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Drag_Drop {
	@Test
	public void actionsClass() throws InterruptedException {
		String chromeDriver = ".//selenium_drivers//";
		System.setProperty("webdriver.chrome.driver", chromeDriver + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Create an object 'action'
		Actions action = new Actions(driver);
		// navigate to the required url where we could do drag and drop action
		driver.get("http://jqueryui.com/droppable/");
		// WebdriverWait is used to wait for a frame to be available. Once it is
		// availble we switch to the frame to achieve our task
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
		// To get source locator
		WebElement sourceLocator = driver.findElement(By.cssSelector("#draggable"));
		// To get target locator
		WebElement targetLocator = driver.findElement(By.cssSelector("#droppable"));
		// dragAndDrop(source, target) method accepts two parameters source and locator.
		// used dragAndDrop method to drag and drop the source locator to target locator
		// build() method is used to compile all the actions into a single step

		action.dragAndDrop(sourceLocator, targetLocator).build().perform();
	}

}
