package com.Task;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PhoneBookDoc {

	WebDriver driver;
	String blood_grp = null;

	@BeforeTest
	void setUp() {
		System.out.println("Before Test");
		int menu;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number from menu to choose Blood Group and fetch the data");
		System.out.println("1. A-\n2. B-\n3. O-\n4. AB-\n5. AB+\n6. O+\n7. B+\n8. A+");
		menu = sc.nextInt();

		switch (menu) {
		case 1:
			blood_grp = "A-";
			break;
		case 2:
			blood_grp = "B-";
			break;
		case 3:
			blood_grp = "O-";
			break;
		case 4:
			blood_grp = "AB-";
			break;
		case 5:
			blood_grp = "AB+";
			break;
		case 6:
			blood_grp = "O+";
			break;
		case 7:
			blood_grp = "B+";
			break;
		case 8:
			blood_grp = "A+";
			break;
		default:
			System.out.println("Please enter valid option(1-6)");
			System.exit(0);
		}
		
		String chromeDriver = ".//selenium_drivers//";
		System.setProperty("webdriver.chrome.driver", chromeDriver + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://corridor.pramati.com/");
		driver.manage().window().maximize();
		sc.close();
	}

	@BeforeClass
	void setUpWeb() {
		System.out.println("Before Class");
		// Click login button
		WebElement login;
		login = driver.findElement(By.linkText("LOGIN"));
		login.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		// type username
		WebElement username;
		username = driver.findElement(By.id("username"));
		username.clear();
		username.sendKeys("vibha.lakshmi@imaginea.com");
		// type password
		WebElement password;
		// encrypt and decrypt
		password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("Vibha2108@");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// login after entering username and password
		WebElement loginbtn;
		loginbtn = driver.findElement(By.id("loginButton"));
		loginbtn.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	void phoneBookSearchResult() throws InterruptedException, Exception {
		System.out.println("*******");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement launch_phbook;
		launch_phbook = driver.findElement(By.xpath("//div[6]//div[1]//div[1]//div[1]//a[1]"));
		launch_phbook.click();
		// launch_phbook =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[6]//div[1]//div[1]//div[1]//a[1]")));
		// launch_phbook.click();
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		// Thread.sleep(2000);
		long end = System.currentTimeMillis() + 2000;
		while (System.currentTimeMillis() < end) {
		}

		// driver.wait(500);
		WebElement search;
		search = driver.findElement(By.name("textSearch"));
		// wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("textSearch")
		// driver.findElement(By.name("textSearch"));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("textSearch")));
		search.clear();
		// search.sendKeys("A-");

		// Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		search.sendKeys(blood_grp);

		end = System.currentTimeMillis() + 2000;
		while (System.currentTimeMillis() < end) {
		}

		WebElement records;
		records = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Total records')]")));
		String num_records = records.getText();
		System.out.println(num_records);
		String[] str = num_records.split(": ");
		int x = Integer.parseInt(str[1]);
		System.out.println("x = " + x);
		int i = 0;
		List<WebElement> names = driver.findElements(By.xpath("//label[@name='labelEmployeeName']"));
		System.out.println("size === " + names.size());

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM_HH:mm");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));

		FileOutputStream fout = new FileOutputStream(".\\PrintData\\BloodGroup_" + blood_grp + ".txt");
		BufferedOutputStream bout = new BufferedOutputStream(fout);
		/*
		 * BufferedOutputStream bout = new BufferedOutputStream( new GZIPOutputStream(
		 * new FileOutputStream("D:\\BloodGroup.txt", true) ) );
		 */
		for (int j = 0; j < x; j++) {
			String emp_names = String.valueOf((j + 1)) + ". " + names.get(i).getText() + "\n";
			System.out.println(emp_names);

			// storing in file
			byte b[] = emp_names.getBytes();
			bout.write(b);

			i++;
			if ((i % 10) == 0) {
				i = 0;
				setElement();
			}
		}

		bout.flush();
		bout.close();
		// fout.close();
		System.out.println("success");

		/*
		 * WebElement details; details =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(
		 * "labelEmployeeName"))); System.out.println("******************");
		 * System.out.println("Name: "+details.getText());
		 */

		// search.submit();
		// driver.manage().timeouts().implicitlyWait(1,TimeUnit.MINUTES) ;

		// Thread.sleep(2000);

		WebElement back_btn;
		back_btn = driver.findElement(By.xpath("//span[contains(text(),'Back To Apps')]"));
		back_btn.click();
		Thread.sleep(2000);
	}

	public void setElement() {
		WebElement next_btn;
		next_btn = driver.findElement(By.xpath("//a[@name='next']"));
		next_btn.click();
		// int k=1;
		long end = System.currentTimeMillis() + 2000;
		while (System.currentTimeMillis() < end) {
		}

		// List<WebElement> names =
		// driver.findElements(By.xpath("//label[@name='labelEmployeeName']"));
		// System.out.println("size === " + names.size()+"===");
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
