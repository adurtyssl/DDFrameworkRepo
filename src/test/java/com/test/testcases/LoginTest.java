package com.test.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.Reporter;
import com.test.base.TestBase;

public class LoginTest extends TestBase{
	
	
	@Test
	public void mngrLoginTest() {
		
		log.info("Inside LoginTest   ***********");
		driver.findElement(By.cssSelector(objrep.getProperty("mngrlogin"))).click();
		log.info("Login test success ***********");
		
		Assert.assertTrue(isElementPresent(By.cssSelector(objrep.getProperty("addcustomer"))),"Log in Failed");
		log.debug("'''''''''Login Successfull'''''''''''");
		Reporter.log("'''''''''Login Successfull'''''''''''");
		//Assert.fail("Login not successfull..........");
	}

}
