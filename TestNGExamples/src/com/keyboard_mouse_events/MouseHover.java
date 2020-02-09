package com.keyboard_mouse_events;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseHover {
	//src-- https://www.softwaretestingmaterial.com/keyboard-mouse-events-using-selenium-actions-class/

	WebDriver driver;

	@BeforeTest
	void setUp() {
		System.out.println("Before Test");
		String chromeDriver = ".//selenium_drivers//";
		System.setProperty("webdriver.chrome.driver", chromeDriver + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corridor.pramati.com/");
		driver.manage().window().maximize();
	}

	@BeforeClass
	void setUpWeb() {
		System.out.println("Before Class");

		WebElement login;
		login = driver.findElement(By.linkText("LOGIN"));
		login.click();
		// implicit weights
		// driver.wait(2000);
		// Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		WebElement username;
		username = driver.findElement(By.id("username"));
		username.sendKeys("vibha.lakshmi@imaginea.com");
		WebElement conn2;
		// encrypt and decrypt
		conn2 = driver.findElement(By.id("password"));
		conn2.sendKeys("Vibha2108@");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// login
		WebElement loginbtn;
		loginbtn = driver.findElement(By.id("loginButton"));
		loginbtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(description = "Testing Holiday List", enabled = true)
	void holidayListMethod() throws Exception {
		System.out.println("*******");

		// Create object 'action' of an Actions class
		Actions actions = new Actions(driver);

		Thread.sleep(3000);
		// SCROLL DOWN
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		// SCROLL UP
		actions.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(3000);


		// click the launch button using action
		WebElement List_Holiday;
		List_Holiday = driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//a[1]"));
		// List_Holiday.click();

		// To mouseover on Launch
		actions.moveToElement(List_Holiday);

		// build() method is used to compile all the actions into a single step
		actions.click().build().perform();

		String j = driver.getTitle();
		System.out.println("Page title is: " + j);

		WebElement back_to_app;
		back_to_app = driver.findElement(By.className("btn-caption"));
		back_to_app.click();
	}

	@AfterClass
	void tearDownLogout() throws InterruptedException {
		System.out.println("After Class");
		// Logout
		WebElement logout;
		logout = driver.findElement(By.linkText("LOGOUT"));
		logout.click();
		Thread.sleep(2000);
		WebElement logout_link;
		logout_link = driver.findElement(By.linkText("log out"));
		logout_link.click();
		Thread.sleep(2000);
		driver.quit();
	}

	@AfterTest
	void tearDownSetup() {
		System.out.println("After Test");
	}

}
