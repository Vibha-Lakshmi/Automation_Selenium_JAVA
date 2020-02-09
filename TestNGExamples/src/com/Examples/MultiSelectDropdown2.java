package com.Examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class MultiSelectDropdown2 {
	WebDriver driver;

	@Test
	public void testApp() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".\\selenium_drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/lakshmis/Desktop/practice/multipleSelect.html");

		// DropDown
		WebElement dropdown = driver.findElement(By.name("cars"));
		Select fruits = new Select(dropdown);
		fruits.selectByVisibleText("BMW");
		fruits.selectByIndex(1);

//List<WebElement> selected_cars=fruits.getAllSelectedOptions();
//List<WebElement> selected_cars=fruits.getAllSelectedOptions();
		List<WebElement> selected_cars = fruits.getOptions();
		for (WebElement Cars : selected_cars) {
			System.out.println("car=" + Cars.getText());
		}

		// Radio Button
		WebElement radio1 = driver.findElement(By.cssSelector("input[value = 'male']"));
		WebElement radio2 = driver.findElement(By.cssSelector("input[value = 'female']"));
		WebElement radio3 = driver.findElement(By.cssSelector("input[value = 'other']"));

		radio1.click();
		System.out.println("selecting male");
		

		Thread.sleep(2000);

		System.out.println("selecting female");
		radio2.click();
		
		Thread.sleep(2000);

		System.out.println("selecting other");
		radio3.click();
		
		Thread.sleep(2000);

		// CheckBox
		WebElement chk1 = driver.findElement(By.name("vehicle1"));
		chk1.click();
		
		Thread.sleep(2000);
		
		

		driver.quit();
	}
}