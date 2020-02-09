package com.Examples;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {

	/*
	 * @Factory: A factory will execute all the test methods present inside a test
	 * class using a separate instance of the respective class with different set of
	 * data.
	 * 
	 * @DataProvider: A test method that uses DataProvider will be executed the
	 * specific methods multiple number of times based on the data provided by the
	 * DataProvider. The test method will be executed using the same instance of the
	 * test class to which the test method belongs.
	 */
	// This method takes data as input parameters. The attribute dataprovider is mapped to "getData"
	@Test (dataProvider="getData")
    // Number of columns should match the number of input parameters
	public void loginTest(String Uid, String Pwd){
		System.out.println("UserName is "+ Uid);
		System.out.println("Password is "+ Pwd);
	}
	
	//If the name is not supplied, the data provider’s name automatically defaults to the method’s name. 
	//A data provider returns an array of objects.
	@DataProvider(name="getData")
	public Object[][] getData(){
		//Object [][] data = new Object [rowCount][colCount];
		Object [][] data = new Object [2][2];
		
		data [0][0] = "FirstUid";
		data [0][1] = "FirstPWD";
		
		data[1][0] = "SecondUid";
		data[1][1] = "SecondPWD";
		
		return data;
		
	}
}

