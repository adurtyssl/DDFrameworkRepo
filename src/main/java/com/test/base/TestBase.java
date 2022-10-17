package com.test.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.test.utilities.ExcelReader;
import com.test.utilities.ExtentManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties objrep = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader("C:\\Users\\Shyam\\eclipse-workspace-2"
			+ "\\DDFramework\\src\\main\\resources\\excel\\mydata.xlsx");
	public WebDriverWait wait;
	
	
	public ExtentReports report = ExtentManager.getInstance();
	public static ExtentTest test;
	
	
	
	@BeforeSuite
	public void setup() {
		
		if(driver==null) {
		//Reading properties file
		try {
			fis = new FileInputStream("C:\\Users\\Shyam\\eclipse-workspace-2"
					+ "\\DDFramework\\src\\main\\resources\\properties\\Config.properties");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.debug("Config file Loaded***********");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		//Reading Object Repository file
		try {
			fis = new FileInputStream("C:\\Users\\Shyam\\eclipse-workspace-2\\"
					+ "DDFramework\\src\\main\\resources\\properties\\OR.properties");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			objrep.load(fis);
			log.debug("Object Repository file Loaded***********");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		if (config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")
					+"\\src\\main\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Chome Launched ***********");
		}
		else if (config.getProperty("browser").equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")
					+"\\src\\main\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Firefox  Launched ***********");
		}
		
		driver.get(config.getProperty("testurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit-wait")), TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,10);
		
	}
	}
	
	public boolean isElementPresent(By by) {
		
		try {
			driver.findElement(by);
			return true;
		
	}catch(NoSuchElementException e) {
		return false;
	}
	}
	
	
	@AfterSuite
	public void teatdown() {
		driver.quit();
		
		
	}

}
