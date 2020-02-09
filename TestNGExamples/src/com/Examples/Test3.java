package com.Examples;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test3 {

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

	@BeforeMethod(enabled = false)
	void setup() {
		System.out.println("Before Method");
		driver = new ChromeDriver();
		driver.get("https://corridor.pramati.com/");
		driver.manage().window().maximize();
		WebElement login;
		login = driver.findElement(By.linkText("LOGIN"));
		login.click();
		// implicit weights
		// driver.wait(2000);
		// Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		WebElement username;
		username = driver.findElement(By.id("username"));
		username.clear();
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

	@Test(description = "Testing Title", enabled = false, priority = 1)
	void titleMethod() {
		System.out.println("*******");
		String j = driver.getTitle();
		System.out.println("Your page title Is : " + j);
		System.out.println("Using Assert---------\n");
		Assert.assertEquals(j, "Apps | Corridor", "Title doesn't match");

		int a = j.compareTo("Apps | Corridor");
		if (a != 0)
			System.out.println("Not Correct Title!!!");
		else
			System.out.println("Correct Title!!!");
		System.out.println("******************");

	}

	// +++++++++++++
	/*
	 * Add another test case for Print all app name and url from corridor.---done
	 */

	// +++++++++++
	// verify the count of holidays use assert

	// Assert page title--- done

	@Test(description = "Print all the App links and titles", enabled = false)
	void printLinks_Titles() {
		System.out.println("*******");
		/*
		 * List<WebElement> Links1 = driver.findElements(By.
		 * xpath("//body[contains(@class,'page-template-default page page-id-16527 logged-in smooth-scroll wpb-js-composer js-comp-ver-5.4.7 vc_responsive')]/div[contains(@class,'site-wrapper wrapall')]/div[@id='page-wrap']/div[@id='content']/div[5]"
		 * )); String str; for(WebElement element: Links1) {
		 * System.out.println("*****Apps Page Title and Links*****");
		 * //System.out.println("==="+element.getText());
		 * //System.out.println("-----"+element.getTagName());
		 * System.out.println("link="+element.getAttribute("href"));
		 * str=element.getText(); String[] res = str.split("\n");
		 * System.out.println("======"+res[0]);
		 * 
		 * }
		 */
		List<WebElement> Links1 = driver.findElements(By.xpath(
				"//body[contains(@class,'page-template-default page page-id-16527 logged-in smooth-scroll wpb-js-composer js-comp-ver-5.4.7 vc_responsive')]/div[contains(@class,'site-wrapper wrapall')]/div[@id='page-wrap']/div[@id='content']/div[5]"));
		System.out.println("size1 = " + Links1.size());

		// <h1>
		List<WebElement> header = driver.findElements(By.tagName("h1"));

		// <a>
		List<WebElement> link_list = driver.findElements(By.tagName("a"));
		int href_size = link_list.size();
		System.out.println("size 2 = " + href_size);
		for (int j = 0; j < (href_size - 2 - 17); j++) {
			// Printing the links
			System.out.println(
					(j + 1) + ". " + header.get(j + 1).getText() + "===" + link_list.get(17 + j).getAttribute("href"));
		}

	}

	@Test(description = "Testing Holiday List", enabled = false)
	void holidayListMethod() throws InterruptedException {
		System.out.println("*******");
		WebElement List_Holiday;
		List_Holiday = driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//a[1]"));
		List_Holiday.click();
		Thread.sleep(2000);
		String hyd_list_xpath = "//span[contains(text(),'Hyderabad')]";
		WebElement List_Holiday_hyd = driver.findElement(By.xpath(hyd_list_xpath));
		List_Holiday_hyd.click();
		Thread.sleep(2000);

		List<WebElement> allElements = driver.findElements(
				By.xpath("//div[@name='livelist5']//ul[@class='app-livelist-container clearfix list-group']/li"));

		System.out.println("HOLIDAY LIST");
		String str;
		for (WebElement element : allElements) {
			// System.out.println(element.getText());
			str = element.getText();
			String[] res = str.split("\n");
			System.out.println(res[0] + " : " + res[1] + " " + res[2]);

		}

		WebElement back_to_app;
		back_to_app = driver.findElement(By.className("btn-caption"));
		back_to_app.click();
		Thread.sleep(2000);
	}

	@Test(description = "Testing Phone Book", enabled = false)
	void phoneBookMethod() throws Exception {
		System.out.println("*******");
		WebElement launch_phbook_btn;
		launch_phbook_btn = driver.findElement(By.xpath("//div[6]//div[1]//div[1]//div[1]//a[1]"));
		launch_phbook_btn.click();
		Thread.sleep(2000);
		WebElement hyd_list;
		hyd_list = driver.findElement(By.xpath("//span[contains(text(),'Hyderabad')]"));
		hyd_list.click();
		Thread.sleep(2000);
		WebElement search_name;
		search_name = driver.findElement(By.name("textSearch"));
		search_name.clear();
		search_name.sendKeys("Vibha Gopi");
		// call function to take screenshot
		// takeSnapShot(driver, "d://test.png") ;
		// Thread.sleep(2000);
		// driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement details;
		details = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("labelEmployeeName")));

		// driver.findElement(By.name("labelEmployeeName"));
		System.out.println("******************");
		System.out.println("Name: " + details.getText());
		WebElement get_email;
		get_email = driver.findElement(By.xpath("//span[contains(text(),'vibha.lakshmi@imaginea.com')]"));
		System.out.println("Email id: " + get_email.getText());
		// Thread.sleep(2000);
		WebElement back_btn;
		back_btn = driver.findElement(By.xpath("//span[contains(text(),'Back To Apps')]"));
		back_btn.click();
		Thread.sleep(2000);
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

	@Test(description = "Testing Let's Meet", enabled = true)
	void letsMeetMethod() throws InterruptedException {
		// src---https://www.softwaretestingmaterial.com/handle-drop-down-and-multi-select-list-using-selenium
		System.out.println("*******");
		WebElement launch_letsmeet;
		launch_letsmeet = driver.findElement(By.xpath("//div[10]//div[1]//div[2]//div[1]//a[1]"));
		launch_letsmeet.click();

		// List<WebElement> check_time =
		// driver.findElements(By.xpath("//div[@name='gridrow7']//div[@name='gridcolumn17']//div[@class='app-ng-transclude']"));
		WebElement check_time;
		check_time = driver.findElement(
				By.xpath("//div[@name='gridrow7']//div[@name='gridcolumn17']//div[@class='app-ng-transclude']"));
		System.out.println("***Place,Time and date displayed on Let's Meet page***");
		System.out.println("print = " + check_time.getText());

		WebElement check_time2 = driver.findElement(By
				.xpath("//div[@name='gridrow7']//div[@name='gridcolumn17']//div[@class='app-ng-transclude']/label[1]"));
		System.out.println(check_time2.getAttribute("textContent") + "----------------");

		System.out.println("=====Hyderabad=====");
		WebElement dropdown1;
		dropdown1 = driver.findElement(By.name("location_formWidget"));
		Select selection = new Select(dropdown1);
		selection.selectByVisibleText("Hyderabad");
	
		// check
		WebElement check_avaiblility;
		check_avaiblility = driver.findElement(By.xpath("//span[contains(text(),'Check Availability')]"));
		check_avaiblility.click();

		Thread.sleep(5000);

		WebElement room;
		room = driver.findElement(By.xpath("//div[@name='gridcolumn19']//select[@placeholder='Select value']"));
		Select selection_location = new Select(room);

		List<WebElement> l = selection_location.getOptions();
		int location_size;
		location_size = l.size();

		System.out.println("Number of rooms = " + location_size);

		System.out.println("=====Chennai=====");
		selection.selectByValue("string:Chennai");
		//selection.selectByVisibleText("Chennai");
		//check
		check_avaiblility.click();
		
		Thread.sleep(5000);
		
		//get no. of options
		List<WebElement> ll = selection_location.getOptions();
		location_size = ll.size();
		
		System.out.println("Number of rooms = " + location_size);
		
		System.out.println("=====Bangalore=====");
		selection.selectByIndex(0);
		//selection.selectByVisibleText("Bangalore");
		//check
		check_avaiblility.click();
		
		Thread.sleep(5000);
		
		//get no. of options
		List<WebElement> lll = selection_location.getOptions();
		location_size = lll.size();
		
		System.out.println("Number of rooms = " + location_size);


		/*
		 * //Printing My Bookings WebDriverWait wait = new WebDriverWait(driver, 20);
		 * WebElement order_link; order_link=
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//a[@name='orderLink']")));
		 * //driver.findElement(By.xpath("//a[@name='orderLink']")); order_link.click();
		 * Thread.sleep(2000);
		 * 
		 * //find no of cols
		 * 
		 * List<WebElement> cols = driver.findElements(By.xpath(
		 * "//table[@id='table_header_e0db6755-d623-75bc-c348-a2f110221286']/thead/tr[1]/th"
		 * )); System.out.println("Columns = "+cols.size());
		 */

		driver.navigate().to("https://corridor.pramati.com/apps");
		;
		Thread.sleep(2000);
	}

	@Test(description = "Testing Learning@Pramati", enabled = false)
	void learn_pramatiMethod() throws Exception {
		System.out.println("*******");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement conn5;
		conn5 = driver.findElement(By.xpath("//div[8]//div[1]//div[1]//div[1]//a[1]"));
		conn5.click();
		conn5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("label10")));
		// driver.manage().timeouts(). ;
		String str = conn5.getText();
		System.out.println("Learning Session = " + str);
		driver.navigate().to("https://corridor.pramati.com/apps/");
		Thread.sleep(2000);
	}

	@AfterMethod(enabled = false)
	void tearDown() throws InterruptedException {
		System.out.println("After Method");
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
