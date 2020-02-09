package com.practice.demo2;

import java.util.List;
import java.util.Vector;
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
				char dl = '\n';
				for (WebElement element: abc) {
				      //System.out.println(element.getText());
					 str = element.getText();
				      Vector<String> res = splitStrings(str, dl); 
			/*
			 * for (String x : res) { System.out.println(x); }
			 */
				      System.out.println(res.get(0)+" : "+res.get(1)+" "+res.get(2));
				}
		/*
		 * //List<WebElement> allElements = driver.findElements(By.
		 * xpath("//div[@name='livelist5']//ul[@class='app-livelist-container clearfix list-group']"
		 * )); List<WebElement> element3 = driver.findElements(By.
		 * xpath("//div[@name='livelist5']//ul[@class='app-livelist-container clearfix list-group']"
		 * )); // List<WebElement> element1 = driver.findElements(By.
		 * cssSelector("label.app-label ng-scope ng-isolate-scope[name='label128']"));
		 * //List<WebElement> element2 = driver.findElements(By.
		 * xpath("//div[@name='livelist5']//ul[@class='app-livelist-container clearfix list-group']"
		 * )); //List<WebElement> element1.size();
		 * System.out.println("size = "+size_element); //String lb1 = //for (WebElement
		 * element: element1) { for(int i=0; i< size_element;i++) { //String label1 =
		 * element1 //String label2 = element2.getText(); //String label3 =
		 * element3.getText(); //System.out.println(element.getText());
		 * System.out.println(element1.get(i).getText()+" : "); // ****************** //
		 * New Year's Day : Jan 01, 2019 }
		 */
		
		WebElement conn3;
		conn3 = driver.findElement(By.className("btn-caption"));
		conn3.click();
		Thread.sleep(2000);
		//
		WebElement conn4;
		conn4 = driver.findElement(By.xpath("//div[10]//div[1]//div[2]//div[1]//a[1]"));
		conn4.click();
		Thread.sleep(2000);
		driver.quit();

	}
	
	static Vector<String> splitStrings(String str, char dl)  
    { 
        String word = ""; 
  
        // to count the number of split Strings 
        //int num = 0; 
  
        // adding delimiter character  
        // at the end of 'str' 
        str = str + dl; 
  
        // length of 'str' 
        int l = str.length(); 
  
        // traversing 'str' from left to right 
        Vector<String> substr_list = new Vector<String>(); 
        for (int i = 0; i < l; i++) 
        { 
  
            // if str[i] is not equal to the delimiter 
            // character then accumulate it to 'word' 
            if (str.charAt(i) != dl) 
            { 
                word = word + str.charAt(i); 
            }  
            else 
            { 
  
                // if 'word' is not an empty String, 
                // then add this 'word' to the array 
                // 'substr_list[]' 
                if ((int) word.length() != 0)  
                { 
                    substr_list.add(word); 
                } 
  
                // reset 'word' 
                word = ""; 
            } 
        } 
  
        // return the splitted Strings 
        return substr_list; 
    } 
  

}
