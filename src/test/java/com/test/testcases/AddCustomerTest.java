package com.test.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.base.TestBase;

public class AddCustomerTest extends TestBase{

	@Test(dataProvider="getCustData")
	public void addCustomer(String firstName, String lastName, String postCode,  String alertText) throws InterruptedException {
		
		driver.findElement(By.cssSelector(objrep.getProperty("addcustomer"))).click();
		driver.findElement(By.cssSelector(objrep.getProperty("firstName"))).sendKeys(firstName);
		driver.findElement(By.cssSelector(objrep.getProperty("lastName"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(objrep.getProperty("postCode"))).sendKeys(postCode);
		driver.findElement(By.cssSelector(objrep.getProperty("addcustbtn"))).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(alertText));
		Thread.sleep(3000);
		alert.accept();
		Reporter.log("Customer added");
	}
	
	@DataProvider
	public Object[][] getCustData() {
		
		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for(int rownum=2; rownum<=2; rownum++) {
			for(int colnum=0; colnum<cols; colnum++) {
				data[rownum-2][colnum]= excel.getCellData(sheetName, colnum, rownum);
			}
		}
		return data;
	
		
	}
	  
}
